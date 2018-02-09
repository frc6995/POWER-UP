
package org.usfirst.frc6995.PatriciaTheCamel.commands;
import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc6995.PatriciaTheCamel.Robot;

/**
 *
 */
public class LifterCom extends Command {

	static final int OVERRIDE_ANGLE_INVALID = -1000;
	static int overrideAngleEnc = OVERRIDE_ANGLE_INVALID;
	
	final int destHeightEnc;
	final int destAngleEnc;
	
	private boolean enableAngleOverride;

	
	public LifterCom(double destHeightInch, double destAngleDeg) {
		
		this.setInterruptible(true);
		this.enableAngleOverride = true;
		
		this.destHeightEnc = riserInchToEnc(destHeightInch);
		this.destAngleEnc = rotatorDegToEnc(destAngleDeg);
		requires(Robot.lifter);
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
    	
    	// Support for override angle control
    	int nextAngleEnc = this.destAngleEnc;
    	if (this.enableAngleOverride && OVERRIDE_ANGLE_INVALID != overrideAngleEnc) {
    		// Head to this angle instead of the standard one
    		nextAngleEnc = overrideAngleEnc;
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
    	final int ENCODER_COUNTS_PER_INCH = 100; //REVISIT - What is the real encoding resolution?
    	return (int) (limitedHeightInch * ENCODER_COUNTS_PER_INCH);
    }
    
    protected static int rotatorDegToEnc(double angleDeg) {
    	double limitedAngleDeg = Math.max(-150.0, Math.min(angleDeg, 150.0));
    	final int ENCODER_COUNTS_PER_ROTATION = 1000; //REVISIT - What is the real encoding resolution?
    	return (int) (limitedAngleDeg * ENCODER_COUNTS_PER_ROTATION / 360);
    }
    
    // Called to request a destination angle override
    public static void overrideDestAngleDeg(double destAngleDeg) {
    	overrideAngleEnc = rotatorDegToEnc(destAngleDeg);
    }
}
