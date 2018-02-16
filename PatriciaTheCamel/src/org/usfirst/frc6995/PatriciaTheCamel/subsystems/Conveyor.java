package org.usfirst.frc6995.PatriciaTheCamel.subsystems;

import org.usfirst.frc6995.PatriciaTheCamel.RobotMap;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.DigitalInput;


/**
 *
 */
public class Conveyor extends Subsystem {
    public final Spark conveyorMotor = RobotMap.conveyorConveyorMotor;
    public final DigitalInput conveyorSwitch = RobotMap.conveyorConveyorSwitch;

    @Override
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        // setDefaultCommand(new MySpecialCommand());
    }

    @Override
    public void periodic() {
        // Put code here to be run every loop

    }

    // Put methods for controlling this subsystem
    // here. Call these from Commands.
}

