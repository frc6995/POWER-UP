// RobotBuilder Version: 2.0
//
// This file was generated by RobotBuilder. It contains sections of
// code that are automatically generated and assigned by robotbuilder.
// These sections will be updated in the future when you export to
// Java from RobotBuilder. Do not put any code or make any change in
// the blocks indicating autogenerated code or it will be lost on an
// update. Deleting the comments indicating the section will prevent
// it from being updated in the future.


package org.usfirst.frc6995.PatriciaTheCamel;

// BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=IMPORTS
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import edu.wpi.first.wpilibj.CounterBase.EncodingType;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.PIDSourceType;
import edu.wpi.first.wpilibj.Servo;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=IMPORTS
import edu.wpi.first.wpilibj.livewindow.LiveWindow;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS
    public static DoubleSolenoid grabberS1;
    public static WPI_TalonSRX conveyorM5;
    public static DigitalInput conveyorLS3;
    public static Servo cameraShuttleM6;
    public static DoubleSolenoid clampPunterS2;
    public static DoubleSolenoid clampPunterClamp;
    public static WPI_TalonSRX lifterM3A;
    public static WPI_TalonSRX lifterM3B;
    public static Encoder lifterE3;
    public static DigitalInput lifterLS1;
    public static DigitalInput lifterLS2;
    public static WPI_TalonSRX lifterM4;
    public static Encoder lifterE4;
    public static WPI_TalonSRX drivebaseM1A;
    public static WPI_TalonSRX drivebaseM2A;
    public static DifferentialDrive drivebaseDriveTrain;
    public static final int JOYSTICK_X_AXIS = 0;
	public static final int JOYSTICK_Y_AXIS = 1;
	public static final int JOYSTICK_R_AXIS = 2;

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS

    @SuppressWarnings("deprecation")
	public static void init() {
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTORS
        grabberS1 = new DoubleSolenoid(0, 0, 1);
        LiveWindow.addActuator("Grabber", "S1", grabberS1);
        
        conveyorM5 = new WPI_TalonSRX(0);
        
        
        conveyorLS3 = new DigitalInput(0);
        LiveWindow.addSensor("Conveyor", "LS3", conveyorLS3);
        
        cameraShuttleM6 = new Servo(0);
        LiveWindow.addActuator("CameraShuttle", "M6", cameraShuttleM6);
        
        clampPunterS2 = new DoubleSolenoid(0, 2, 3);
        LiveWindow.addActuator("ClampPunter", "S2", clampPunterS2);
        
        clampPunterClamp = new DoubleSolenoid(0, 4, 5);
        LiveWindow.addActuator("ClampPunter", "Clamp", clampPunterClamp);
        
        lifterM3A = new WPI_TalonSRX(1);
        
        
        lifterM3B = new WPI_TalonSRX(4);
        
        
        lifterE3 = new Encoder(1, 2, false, EncodingType.k4X);
        LiveWindow.addSensor("Lifter", "E3", lifterE3);
        lifterE3.setDistancePerPulse(1.0);
        lifterE3.setPIDSourceType(PIDSourceType.kRate);
        lifterLS1 = new DigitalInput(3);
        LiveWindow.addSensor("Lifter", "LS1", lifterLS1);
        
        lifterLS2 = new DigitalInput(4);
        LiveWindow.addSensor("Lifter", "LS2", lifterLS2);
        
        lifterM4 = new WPI_TalonSRX(5);
        
        
        lifterE4 = new Encoder(5, 6, false, EncodingType.k4X);
        LiveWindow.addSensor("Lifter", "E4", lifterE4);
        lifterE4.setDistancePerPulse(1.0);
        lifterE4.setPIDSourceType(PIDSourceType.kRate);
        drivebaseM1A = new WPI_TalonSRX(2);
        
        
        drivebaseM2A = new WPI_TalonSRX(3);
        
        
        drivebaseDriveTrain = new DifferentialDrive(drivebaseM1A, drivebaseM2A);
        LiveWindow.addActuator("Drivebase", "DriveTrain", drivebaseDriveTrain);
        drivebaseDriveTrain.setSafetyEnabled(true);
        drivebaseDriveTrain.setExpiration(0.2);
        drivebaseDriveTrain.setMaxOutput(1.0);


    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTORS
    }
}
