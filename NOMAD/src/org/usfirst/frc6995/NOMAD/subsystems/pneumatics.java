package org.usfirst.frc6995.NOMAD.subsystems;

import org.usfirst.frc6995.NOMAD.RobotMap;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.DoubleSolenoid;


/**
 *
 */
public class pneumatics extends Subsystem {

    // Put methods for controlling this subsystem
    // here. Call these from Commands.
    private final DoubleSolenoid doubleSolenoid = RobotMap.BOX_GRABBER_CYLLINDER;

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}
