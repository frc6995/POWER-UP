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
        	double lifterAngleDeg = 0.0;
        	switch (angle) {
    			case 135:
    				lifterAngleDeg = -135.0;
    			break;
    			case 90:
    				lifterAngleDeg = -90.0;
    			break;
    			case 45:
    				lifterAngleDeg = -45.0;
    			break;
    			case 0:
    				lifterAngleDeg = 0.0;
    			break;
    			case 315:
    				lifterAngleDeg = 45.0;
    			break;
    			case 270:
    				lifterAngleDeg = 90.0;
    			break;
    			case 225:
    				lifterAngleDeg = 135.0;
    			break;
    			default:
    				System.out.println("Unsupported hat angle reported");
    			break;
    		}
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
