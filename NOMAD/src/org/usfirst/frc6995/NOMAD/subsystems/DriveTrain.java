package org.usfirst.frc6995.NOMAD.subsystems;

import org.usfirst.frc6995.NOMAD.RobotMap;
import org.usfirst.frc6995.NOMAD.commands.*;
import org.usfirst.frc6995.NOMAD.definitions.Range;

import edu.wpi.first.wpilibj.PIDController;
import edu.wpi.first.wpilibj.command.Subsystem;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;


public class DriveTrain extends Subsystem {
	
	//Declaring Drive Motors/Encoders
    private final WPI_TalonSRX driveLeft = RobotMap.MOTOR_DRIVE_LEFT;
    private final WPI_TalonSRX driveRight = RobotMap.MOTOR_DRIVE_RIGHT;
    
    //Declaring Drive motor PID controllers
    private final PIDController drivePIDLeft = RobotMap.PID_MOTOR_DRIVE_LEFT;
    private final PIDController drivePIDRight = RobotMap.PID_MOTOR_DRIVE_RIGHT;

    @Override
    public void initDefaultCommand() {
    	//setting the default command for this subsystem
        setDefaultCommand(new DriveCom());
    }

    @Override
    public void periodic() {
        // Put code here to be run every loop
    }
    public void motorInit() {
    	driveLeft.setSafetyEnabled(true);
    	driveRight.setSafetyEnabled(true);
    	
    	driveLeft.setExpiration(0.2);
    	driveRight.setExpiration(0.2);
    }
    public void pidInit() {
    	final double miliseconds = 4000;
    	boolean init = false;
    	double speed = 0;
    	double time = System.currentTimeMillis();
    	while (!init) {
			if (drivePIDRight.getError() < 10 || drivePIDLeft.getError() < 10) {
				speed = speed + 0.002;
				driveLeft.set(Range.clip(speed, 0, 0.2));
				driveRight.set(Range.clip(speed, 0, 0.2));
				System.out.print("pidleft: "+drivePIDLeft.getError());
				System.out.print("pidright: "+drivePIDRight.getError());
			}
			else if (drivePIDLeft.getError() >= 10 && drivePIDRight.getError() >= 10) {
				speed = 0;
				init = true;
			}
			
			if (System.currentTimeMillis()-time >= miliseconds) {
				System.out.print("Unable to find exact location of motor, resetting encoders to aproximate position.");
				break;
			}
    	}
    }
    
    /**Methods to call from command**/
    //Arcade drive method
    public void arcadeDrive(double moveSpeed, double rotSpeed, double throt) {
    	
    	//Setting the throttle to run from 0 to 1 instead of -1 to 1
    	double throttle = (throt-1)/2;
    	
    	//multiplying the given speeds from the controller by the throttle
    	double move = moveSpeed*throttle;
    	double rot = -rotSpeed*throttle;
    	
    	//setting the motor speeds
    	driveLeft.set(move + rot);
    	driveRight.set(-move + rot);
    }   
}

