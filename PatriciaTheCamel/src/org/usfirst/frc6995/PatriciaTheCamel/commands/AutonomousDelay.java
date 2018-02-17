package org.usfirst.frc6995.PatriciaTheCamel.commands;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class AutonomousDelay extends Command {
	int cycles;

    public AutonomousDelay(int seconds) {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	cycles = seconds * 20;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	cycles --;
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return cycles <= 0;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
    
    public void setDelay(int seconds) {
    	cycles = seconds * 20;
    }
}
