
package org.usfirst.frc6995.PatriciaTheCamel.commands;
import edu.wpi.first.wpilibj.command.Command;

import java.io.Console;

import org.usfirst.frc6995.PatriciaTheCamel.Robot;
import org.usfirst.frc6995.PatriciaTheCamel.RobotMap;

import com.ctre.phoenix.motorcontrol.ControlMode;

/**
 *
 */
public class LifterCom extends Command {

	static final int ENCODER_COUNTS_PER_INCH = 1024;
	static final int RISER_STOP_DIST_ENC = 1024;  // TODO: Need real numbers
	static final int ENCODER_COUNTS_PER_ROTATION = 4096;
	static final int ROTATOR_STOP_DIST_ENC = 128;

	// Though we don't know the exact interference heights until the mechanics are built,
	// we do know what the causes of interference are and can predict many of the breakpoints
	// in our mech interference logic.  Mostly we want to know when we can start
	//
	// - We know that at the very bottom position the ground and the conveyor will interfere with the rotation.
	// - We know that the ground will be the first interference to go away.
	// - We know that we want to be able to grab a box on the conveyor at 45 deg up.
	static final int RISER_GROUND_CLEARANCE_pos135_ENC = (int) (5.0 * ENCODER_COUNTS_PER_INCH);
	
	static final int OVERRIDE_ANGLE_INVALID = -1000;
	
	static int overrideAngleEnc = OVERRIDE_ANGLE_INVALID;
	
	private int destHeightEnc;
	private int destAngleEnc;
	
	private boolean enableAngleOverride;
	private boolean enableRiserReq;
	private RiserReqMonitor riserReq;

	
	class RiserReqStub implements RiserReqMonitor {

		@Override
		public int riserRequest() {
			System.out.println("**WARNING** - unexpected call to RiserReqStub");
			return 0;
		}
		
	}
	
	
	public LifterCom(double destHeightInch, double destAngleDeg) {
		
		this.setInterruptible(true);
		this.enableAngleOverride = true;
		
		this.riserReq = new RiserReqStub();  // This should not ever be called, but let's avoid an exception.
		this.enableRiserReq = false;
		
		this.destHeightEnc = riserInchToEnc(destHeightInch);
		this.destAngleEnc = rotatorDegToEnc(destAngleDeg);
		requires(Robot.lifter);
	}
	
	
	public LifterCom(RiserReqMonitor riserReqMonitor) {
		
		this(0.0, 0.0);
		this.riserReq = riserReqMonitor;
		this.enableRiserReq = true;
	}
	
	// The default constructor should perform a "dirty" (unknown position)
	// mechanical initialization, ending up in the reset position (0.0, UP)
	// with the encoders reset.
	public LifterCom() {

        this(0.0, 0.0);  //TODO: Update to support a dirty init.
		this.enableAngleOverride = false;
    }

    // Called just before this Command runs the first time
    @Override
    protected void initialize() {
    	if (this.enableAngleOverride) {
    		// Mark the override angle as invalid so we know when it finally gets updated
    		overrideAngleEnc = OVERRIDE_ANGLE_INVALID;
    	}
    }

    // Called repeatedly when this Command is scheduled to run
    @Override
    protected void execute() {

    	final int currHeightEnc = RobotMap.lifterLifterMotorA.getSensorCollection().getQuadraturePosition();
    	final int currAngleEnc = RobotMap.lifterLifterRotatorMotor.getSensorCollection().getQuadraturePosition();

		if (this.enableRiserReq) {
			int direction = this.riserReq.riserRequest();
			
			this.destHeightEnc = currHeightEnc;
			this.destAngleEnc = currAngleEnc;
			
			if (direction > 0) {
				this.destHeightEnc += RISER_STOP_DIST_ENC;
			}
			else if (direction < 0) {
				this.destHeightEnc -= RISER_STOP_DIST_ENC;
			}
		}

    	int nextHeightEnc = currHeightEnc;
    	int nextAngleEnc = currAngleEnc;

    	// Support for override angle control
    	if (this.enableAngleOverride && OVERRIDE_ANGLE_INVALID != overrideAngleEnc) {
    		// Head to this angle instead of the standard one
    		nextAngleEnc = overrideAngleEnc;
    	}
    	
    	// Now that we know where we want to get to
    	// we need to figure out how to get there (and if we can)
    	
    	
    	if (this.destHeightEnc != currHeightEnc) {
    	   	if (this.destHeightEnc > currHeightEnc) {
        		// Then we need to go higher - unless we need to get out of a keep-out zone
        		nextHeightEnc += Math.min(this.destHeightEnc - currHeightEnc, RISER_STOP_DIST_ENC);
        	}
        	else {
        		// Then we need to go lower - always safe
        		nextHeightEnc -= Math.min(currHeightEnc - this.destHeightEnc, RISER_STOP_DIST_ENC);
        	}
    	}
     	else {
        	// We have arrived at the right height. No adjustment needed.
    	}
    	
    	// Now we have to check constraints.
    	//  a) We can only adjust our height iff no mech interference
    	//  b) We must adjust our angle to a position safe to enter the new height
    	//  NOTE: In our mech the only place we know of that we may have to adjust
    	//        our height to get to a safe angle is up at the very top.
    	//        We can use a sequence move to navigate in to pre-climb position
    	//        and avoid the complexity of a more general solution.
    	
    	// TODO Call a function to determine constraints at the requested height.
    	
    	int minAngleEnc = rotatorMinAngleEnc(nextHeightEnc);
    	int maxAngleEnc = rotatorMaxAngleEnc(nextHeightEnc);

    	// TODO Figure out how to apply the keep out region
    	//int minAngleKeepOutEnc = rotatorMinAngleKeepOutEnc(nextHeightEnc);
    	//int maxAngleKeepOutEnc = rotatorMaxAngleKeepOutEnc(nextHeightEnc):

    	// Limit the next angle based on constraints
    	nextAngleEnc = Math.max(minAngleEnc, Math.min(nextAngleEnc, maxAngleEnc));	
    	
    	// Update next angle request
    	if (nextAngleEnc != currAngleEnc) {
        	if (nextAngleEnc > currAngleEnc) {
        		// Then we need to go out - unless we can't due to a constraint
        		nextAngleEnc += Math.min(nextAngleEnc - currAngleEnc, ROTATOR_STOP_DIST_ENC);
        	}
        	else if (nextAngleEnc < currAngleEnc) {
        		// Then we need to go in
        		nextAngleEnc -= Math.min(currAngleEnc - nextAngleEnc, ROTATOR_STOP_DIST_ENC);
        	}
    	}
    	else {
    		// We have arrived at the right angle. No adjustment needed.
    	}
    	// Go to new angle
    	RobotMap.lifterLifterRotatorMotor.set(ControlMode.MotionMagic, nextAngleEnc);;
    	

    	// If it is safe to change height, then do so.
    	if (currAngleEnc <= maxAngleEnc && currAngleEnc >= minAngleEnc &&
    			nextAngleEnc <= maxAngleEnc && nextAngleEnc >= minAngleEnc) {
    		// Go to new height
        	RobotMap.lifterLifterMotorA.set(ControlMode.MotionMagic, nextHeightEnc);;
    	}
    }

    // Make this return true when this Command no longer needs to run execute()
    @Override
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    @Override
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    @Override
    protected void interrupted() {
    	end();
    }
    
    protected static int riserInchToEnc(double heightInch) {
    	double limitedHeightInch = Math.max(0.5, Math.min(heightInch, 81.0));
    	return (int) (limitedHeightInch * ENCODER_COUNTS_PER_INCH);
    }
    
    protected static int rotatorDegToEnc(double angleDeg) {
    	double limitedAngleDeg = Math.max(-150.0, Math.min(angleDeg, 150.0));
    	return (int) (limitedAngleDeg * ENCODER_COUNTS_PER_ROTATION / 360);
    }
    
    // Called to request a destination angle override
    public static void overrideDestAngleDeg(double destAngleDeg) {
    	overrideAngleEnc = rotatorDegToEnc(destAngleDeg);
    }
    
    // Called to get the constraint angles for a specific height.
    // Though it would be more Java-like to return these in a class
    // we ought to do our best to avoid dynamic allocation to avoid 
    // uncontrolled garbage collection.  This means we might as well
    // provide separate functions for each constraint.  (They will each
    // return different values anyway.
    public static int rotatorMinAngleEnc(int heightEnc) {
    	return rotatorDegToEnc(-6.5);  // TODO Need real values
    }
    
    public static int rotatorMaxAngleEnc(int heightEnc) {
    	
    	if (RISER_GROUND_CLEARANCE_pos135_ENC >= heightEnc) {
    		return rotatorDegToEnc(90.0);  // TODO Need real values
    	}
		return rotatorDegToEnc(150.0);  // TODO Need real values
    }
}
