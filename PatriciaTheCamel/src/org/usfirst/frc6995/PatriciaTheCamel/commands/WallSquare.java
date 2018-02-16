package org.usfirst.frc6995.PatriciaTheCamel.commands;
import edu.wpi.first.wpilibj.command.TimedCommand;
import org.usfirst.frc6995.PatriciaTheCamel.Robot;

/**
 *
 */
public class WallSquare extends TimedCommand {
	public WallSquare() {
		this(5);
	}

    public WallSquare(double timeout) {
    	super(timeout);
    	requires(Robot.drivebase);
    }

    // Called just before this Command runs the first time
    @Override
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    @Override
    protected void execute() {
    	Robot.drivebase.driveLeft.set(-0.2);
    	Robot.drivebase.driveRight.set(0.2);
    }

    // Make this return true when this Command no longer needs to run execute()
    //@Override
    //protected boolean isFinished() {
        //return false;
    //}

    // Called once after isFinished returns true
    @Override
    protected void end() {
    	Robot.drivebase.driveLeft.set(0);
    	Robot.drivebase.driveRight.set(0);
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    @Override
    protected void interrupted() {
    }
}
