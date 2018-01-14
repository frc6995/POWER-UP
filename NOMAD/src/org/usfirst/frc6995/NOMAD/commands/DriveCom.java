
package org.usfirst.frc6995.NOMAD.commands;
import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc6995.NOMAD.Robot;
import org.usfirst.frc6995.NOMAD.RobotMap;

public class DriveCom extends Command {

    public DriveCom() {
    	//setting the required subsystem
        requires(Robot.DRIVE_TRAIN);
    }

    // Called just before this Command runs the first time
    @Override
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    @Override
    protected void execute() {
    	double rot = Robot.CONTROLS.joystick.getRawAxis(RobotMap.JOYSTICK_Y_AXIS);
    	double move = Robot.CONTROLS.joystick.getRawAxis(RobotMap.JOYSTICK_X_AXIS);
    	double throt = Robot.CONTROLS.joystick.getThrottle();
    	
    	Robot.DRIVE_TRAIN.arcadeDriveForward(move, rot, throt);
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
}