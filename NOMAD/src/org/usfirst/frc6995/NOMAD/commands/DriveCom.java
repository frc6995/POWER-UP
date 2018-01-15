
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
    	//sets the joystick axis and buttons to variables
    	double leftRight = Robot.CONTROLS.joystick.getRawAxis(RobotMap.JOYSTICK_X_AXIS);
    	double frontBack = Robot.CONTROLS.joystick.getRawAxis(RobotMap.JOYSTICK_Y_AXIS);
    	double throt = Robot.CONTROLS.joystick.getThrottle();
    	double rot = Robot.CONTROLS.joystick.getRawAxis(RobotMap.JOYSTICK_R_AXIS);
    	//creates a variable to combine the leftRight and rot together
    	double rotation;
    	
    	//Combines both the X axis of the joystick and the rotation of the joystick.
    	if (Math.abs(leftRight) > Math.abs(rot)) {
			rotation = leftRight;
		}
    	else if (Math.abs(leftRight) < Math.abs(rot)) {
			rotation = rot ;
		}
    	else {
    		rotation = leftRight;
    	}
    	
    	//Inputs the variables into the arcadeDrive method defined in CubeGrabber
    	Robot.DRIVE_TRAIN.arcadeDrive(frontBack, rotation, throt);
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
