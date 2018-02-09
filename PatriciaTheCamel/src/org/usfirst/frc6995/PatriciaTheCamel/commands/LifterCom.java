
package org.usfirst.frc6995.PatriciaTheCamel.commands;
import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc6995.PatriciaTheCamel.Robot;

/**
 *
 */
public class LifterCom extends Command {

	final int destHeightEnc;
	final int destAngleEnc;
	
	public LifterCom(double destHeightInch, double destAngleDeg) {
		
		this.setInterruptible(true);
		
		this.destHeightEnc = this.riserInchToEnc(destHeightInch);
		this.destAngleEnc = this.rotatorDegToEnc(destAngleDeg);
		requires(Robot.lifter);
	}
	
	// The default constructor should perform a "dirty" (unknown position)
	// mechanical initialization, ending up in the reset position (0.0, UP)
	// with the encoders reset.
	public LifterCom() {

        this(0.0, 0.0);  //TODO: Update to support a dirty init.
    }

    // Called just before this Command runs the first time
    @Override
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    @Override
    protected void execute() {
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
    
    public int riserInchToEnc(double heightInch) {
    	double limitedHeightInch = Math.max(0.5, Math.min(heightInch, 81.0));
    	final int ENCODER_COUNTS_PER_INCH = 100; //REVISIT - What is the real encoding resolution?
    	return (int) (limitedHeightInch * ENCODER_COUNTS_PER_INCH);
    }
    
    public int rotatorDegToEnc(double angleDeg) {
    	double limitedAngleDeg = Math.max(-150.0, Math.min(angleDeg, 150.0));
    	final int ENCODER_COUNTS_PER_ROTATION = 1000; //REVISIT - What is the real encoding resolution?
    	return (int) (limitedAngleDeg * ENCODER_COUNTS_PER_ROTATION / 360);
    }
}
