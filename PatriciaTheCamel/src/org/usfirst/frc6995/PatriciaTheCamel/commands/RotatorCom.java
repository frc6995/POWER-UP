package org.usfirst.frc6995.PatriciaTheCamel.commands;

import org.omg.CORBA.PUBLIC_MEMBER;
import org.usfirst.frc6995.PatriciaTheCamel.Robot;

import edu.wpi.first.wpilibj.command.Command;

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
    	if (angle != prevAngle) {
    		switch (angle) {
    			case 135:
    				System.out.println("Hat at -135 degrees");
    			break;
    			case 90:
    				System.out.println("Hat at -90 degrees");
    			break;
    			case 45:
    				System.out.println("Hat  at -45 degrees");
    			break;
    			case 0:
    				System.out.println("Hat at 0 degrees");
    			break;
    			case 315:
    				System.out.println("Hat at 45 degrees");
    			break;
    			case 270:
    				System.out.println("Hat at 90 degrees");
    			break;
    			case 225:
    				System.out.println("Hat at 135 degrees");
    			break;
    			case -1:
    				System.out.println("Hat at center");
    			break;
    			default:
    				System.out.println("Hats off to the Queen");
    			break;
    		}
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
