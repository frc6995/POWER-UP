package org.usfirst.frc6995.PatriciaTheCamel.commands;

import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc6995.PatriciaTheCamel.Robot;

/**
 *
 */
public class ConveyorIn extends Command {

	int cycles_out_max = 0;
	int cycles_left = 0;

    public ConveyorIn() {
        this(0);
        cycles_out_max = 50 * 10;  // Default to 10 seconds
    }

    public ConveyorIn(double timeout) {
        super(timeout);
        
        cycles_out_max = (int)(timeout * 50 + 0.5);

        requires(Robot.conveyor);
    }

    // Called just before this Command runs the first time
    @Override
    protected void initialize() {
    	cycles_left = cycles_out_max;
    	if (0 < cycles_left) {
    		Robot.conveyor.conveyorMotor.set(0.1875);
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
    	if ((0 >= cycles_left) || Robot.conveyor.conveyorSwitch.get()) {
    		return true;
    	}
    	else {
    		return false;
    	}
    }
        
    // Called once after isFinished returns true
    @Override
    protected void end() {
    	Robot.conveyor.conveyorMotor.set(0);
    }
        
    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    @Override
    protected void interrupted() {
    	end();
    }
}