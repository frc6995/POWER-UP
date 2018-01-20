package org.usfirst.frc6995.NOMAD.commands;

import org.usfirst.frc6995.NOMAD.Robot;
import edu.wpi.first.wpilibj.command.Command;

public class grabberCom extends Command {
	
	boolean toggle = true;
    boolean grabbed = false;

    public grabberCom() {
        //Declares the required subsystem for this command
        requires(Robot.PNEUMATICS);
    }

    // Called just before this Command and runs once the first time
    protected void initialize() {
    	Robot.PNEUMATICS.closeCylinder();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	
    	//toggle for the cube grabber cylinder
    	if (toggle && Robot.CONTROLS.joystick.getRawButton(2)) {
            toggle = false;
            if (grabbed) {
                grabbed = false;
                Robot.PNEUMATICS.openCylinder();
            } else {
                grabbed = true;
                Robot.PNEUMATICS.closeCylinder();
            }
        }
        else if (!Robot.CONTROLS.joystick.getRawButton(2)) {
            toggle = true;
        }
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
