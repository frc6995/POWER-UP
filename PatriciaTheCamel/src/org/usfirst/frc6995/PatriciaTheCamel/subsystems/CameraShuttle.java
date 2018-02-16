package org.usfirst.frc6995.PatriciaTheCamel.subsystems;

import org.usfirst.frc6995.PatriciaTheCamel.RobotMap;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.Servo;


/**
 *
 */
public class CameraShuttle extends Subsystem {

    private final Servo cameraServo = RobotMap.cameraShuttleCameraServo;

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

