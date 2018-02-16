package org.usfirst.frc6995.PatriciaTheCamel.commands;

import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc6995.PatriciaTheCamel.Robot;
import org.usfirst.frc6995.PatriciaTheCamel.commands.LifterCom;

/**
 *
 */
public class RotatorCom extends Command {
	int angle = 0;
    int prevAngle = -2;
    public RotatorCom() {
        // Use requires() here to declare subsystem dependencies
    	
    	
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	angle = Robot.oi.joystick.getPOV();
    	
    	if (angle != prevAngle && angle != -1) {
        	double lifterAngleDeg = (angle >= 180) ? angle - 360 : angle;
			System.out.print("Hat requesting angle ");
			System.out.println(lifterAngleDeg);
			
			LifterCom.overrideDestAngleDeg(lifterAngleDeg);
    	}
    	prevAngle=angle;
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
