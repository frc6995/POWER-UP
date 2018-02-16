package org.usfirst.frc6995.PatriciaTheCamel.commands;

/**
 *
 *
public class ConveyorToEnd extends Command {
    public ConveyorToEnd() {
    }

    // Called just before this Command runs the first time
    @Override
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    @Override
    protected void execute() {
    	while(Conveyor.lS3 == false) {
    		Conveyor.m5.set(1);
    	}
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
    }
}
*/