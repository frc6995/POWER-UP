// RobotBuilder Version: 2.0
//
// This file was generated by RobotBuilder. It contains sections of
// code that are automatically generated and assigned by robotbuilder.
// These sections will be updated in the future when you export to
// Java from RobotBuilder. Do not put any code or make any change in
// the blocks indicating autogenerated code or it will be lost on an
// update. Deleting the comments indicating the section will prevent
// it from being updated in the future.


package org.usfirst.frc.team6995.PatriciaTheCamel.commands;

import org.usfirst.frc.team6995.PatriciaTheCamel.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class ConveyorOut extends Command {


	int cycles_out_max = 0;
	int cycles_left = 0;

    public ConveyorOut() {
        this(0);
        cycles_out_max = 50 * 3;  // Default to 3 seconds
    }

    public ConveyorOut(double timeout) {
        super(timeout);
        
        cycles_out_max = (int)(timeout * 50 + 0.5);

        requires(Robot.conveyor);
    }

    // Called just before this Command runs the first time
    @Override
    protected void initialize() {
    	cycles_left = cycles_out_max;
    	if (0 < cycles_left) {
    		Robot.conveyor.conveyorMotor.set(-0.3);
    	}
    }

    // Called repeatedly when this Command is scheduled to run
    @Override
    protected void execute() {
    	if (0 < cycles_left) {
    		cycles_left -= 1;
    	}
    }
    
    @Override
    protected boolean isFinished() {
    	return (0 >= cycles_left);
    }
    
    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    @Override
    protected void interrupted() {
    	end();
    }
    
    // Called once after isFinished returns true
    @Override
    protected void end() {
    	Robot.conveyor.conveyorMotor.set(0);
    }   
}