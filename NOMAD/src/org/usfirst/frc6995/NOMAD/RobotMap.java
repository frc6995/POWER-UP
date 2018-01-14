package org.usfirst.frc6995.NOMAD;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.PIDController;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
	//getting the Joystick one x and y axis to use in controlling the robot
    public static final int JOYSTICK_X_AXIS = 1;
	public static final int JOYSTICK_Y_AXIS = 0;
	public static final int JOYSTICK_R_AXIS = 2;
	
	//Adding in drive motors
    public static WPI_TalonSRX MOTOR_DRIVE_LEFT;
    public static WPI_TalonSRX MOTOR_DRIVE_RIGHT;
    
    //Adding in drive motors' PID controllers
	public static PIDController PID_MOTOR_DRIVE_LEFT;
	public static PIDController PID_MOTOR_DRIVE_RIGHT;
	
	//Method for initializing stuff
    public static void init() {
        //Setting the motor controller's CAN ID
    	MOTOR_DRIVE_LEFT = new WPI_TalonSRX(2);
    	MOTOR_DRIVE_RIGHT = new WPI_TalonSRX(3);
    }
}
