package org.usfirst.frc6995.PatriciaTheCamel;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.FeedbackDevice;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Servo;
import edu.wpi.first.wpilibj.Spark;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
    public static final int JOYSTICK_X_AXIS = 0;
	public static final int JOYSTICK_Y_AXIS = 1;
	public static final int JOYSTICK_R_AXIS = 2;
	public static final int JOYSTICK_SLIDER = 3;

    //public static DoubleSolenoid grabberGrabberCylinder;
    public static Spark conveyorConveyorMotor;
    public static DigitalInput conveyorConveyorSwitch;
    public static Servo cameraShuttleCameraServo;
    public static WPI_TalonSRX lifterLifterMotorA;
    public static WPI_TalonSRX lifterLifterMotorB;
    public static DigitalInput lifterLifterTopSwitch;
    public static DigitalInput lifterLifterBottomSwitch;
    public static WPI_TalonSRX lifterLifterRotatorMotor;
    public static WPI_TalonSRX drivebaseDriveLeft;
    public static WPI_TalonSRX drivebaseDriveRight;

	public static void init() {
        //grabberGrabberCylinder = new DoubleSolenoid(0, 0, 1);
        //LiveWindow.addActuator("Grabber", "GrabberCylinder", grabberGrabberCylinder);
        
        conveyorConveyorMotor = new Spark(9);
        
        conveyorConveyorSwitch = new DigitalInput(0);
        
        cameraShuttleCameraServo = new Servo(0);
        
        lifterLifterMotorA = new WPI_TalonSRX(5);
        
        lifterLifterMotorB = new WPI_TalonSRX(6);
        lifterLifterMotorB.set(ControlMode.Follower, 5.0);
        
        
        lifterLifterTopSwitch = new DigitalInput(3);
        
        lifterLifterBottomSwitch = new DigitalInput(4);
        
        lifterLifterRotatorMotor = new WPI_TalonSRX(4);
        lifterLifterRotatorMotor.setSensorPhase(false);
        lifterLifterRotatorMotor.setInverted(false);
        lifterLifterRotatorMotor.getSensorCollection().setQuadraturePosition(0, 10);
        
        // Set the peak and nominal outputs, 12V means full      
        lifterLifterRotatorMotor.configNominalOutputForward(0.0, 0);
        lifterLifterRotatorMotor.configNominalOutputReverse(0.0, 0);
        lifterLifterRotatorMotor.configPeakOutputForward(12.0, 0);
        lifterLifterRotatorMotor.configPeakOutputReverse(-12.0, 0);
        
        // Set closed loop gains in slot0 - see documentation
        lifterLifterRotatorMotor.selectProfileSlot(0, 0);
        lifterLifterRotatorMotor.config_kF(0, 1.68, 0);
        lifterLifterRotatorMotor.config_kP(0, 1.2, 0);  // Need something to give a consisten correction for error
        lifterLifterRotatorMotor.config_kI(0, 0, 0);
        lifterLifterRotatorMotor.config_kD(0, 0, 0);
        lifterLifterRotatorMotor.configMotionCruiseVelocity(480, 0);  // At full power, read ~610 counts/100msec
        lifterLifterRotatorMotor.configMotionAcceleration(4800, 0);  // Since this is a slow max speed we want a quick ramp
        // The above settings gave high repeatability on Fwd/Bkwd movements of 1/2 rotation (+1024 to -1024).
        // Typically saw ending position error vary by no more than 5 counts (4096 cnt/rev)
        
        
        drivebaseDriveLeft = new WPI_TalonSRX(3);
        drivebaseDriveLeft.configSelectedFeedbackSensor(FeedbackDevice.CTRE_MagEncoder_Relative, 0, 0);
        drivebaseDriveLeft.setSensorPhase(false);
        drivebaseDriveLeft.setInverted(true);
        
        drivebaseDriveRight = new WPI_TalonSRX(2);
        drivebaseDriveRight.configSelectedFeedbackSensor(FeedbackDevice.CTRE_MagEncoder_Relative, 0, 0);
        drivebaseDriveRight.setSensorPhase(false);
        drivebaseDriveRight.setInverted(true);
    }
}
