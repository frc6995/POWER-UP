package org.usfirst.frc6995.PatriciaTheCamel.commands;

import org.usfirst.frc6995.PatriciaTheCamel.Robot;
import org.usfirst.frc6995.PatriciaTheCamel.RobotMap;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class IntakeIn extends Command {

    public IntakeIn() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(Robot.intake);
    	
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	RobotMap.grabberIntakeLeft.set(-Robot.intake.motorSpeedIn);
    	RobotMap.grabberIntakeRight.set(Robot.intake.motorSpeedIn);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    	RobotMap.grabberIntakeLeft.set(0);
    	RobotMap.grabberIntakeRight.set(0);
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	end();
    }
}
