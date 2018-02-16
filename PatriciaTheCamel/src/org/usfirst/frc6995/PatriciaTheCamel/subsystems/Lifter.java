package org.usfirst.frc6995.PatriciaTheCamel.subsystems;

import org.usfirst.frc6995.PatriciaTheCamel.RobotMap;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.DigitalInput;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

/**
 *
 */
public class Lifter extends Subsystem {

    private final WPI_TalonSRX lifterMotorA = RobotMap.lifterLifterMotorA;
    private final WPI_TalonSRX lifterMotorB = RobotMap.lifterLifterMotorB;
    private final DigitalInput lifterTopSwitch = RobotMap.lifterLifterTopSwitch;
    private final DigitalInput lifterBottomSwitch = RobotMap.lifterLifterBottomSwitch;
    private final WPI_TalonSRX lifterRotatorMotor = RobotMap.lifterLifterRotatorMotor;

    // Initialize your subsystem here
    public Lifter() {
        // Use these to get going:
        // setSetpoint() -  Sets where the PID controller should move the system
        //                  to
        // enable() - Enables the PID controller.
    }

    @Override
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}
