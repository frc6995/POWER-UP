package org.usfirst.frc6995.PatriciaTheCamel.subsystems;

import org.usfirst.frc6995.PatriciaTheCamel.RobotMap;
import org.usfirst.frc6995.PatriciaTheCamel.commands.*;

import edu.wpi.first.wpilibj.command.Subsystem;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

/**
 *
 */
public class Drivebase extends Subsystem {

	public final WPI_TalonSRX driveLeft = RobotMap.drivebaseDriveLeft;
    public final WPI_TalonSRX driveRight = RobotMap.drivebaseDriveRight;

    @Override
    public void initDefaultCommand() {
        setDefaultCommand(new DriveCom());
        setDefaultCommand(new DriveCom());
    }
    
    public void arcadeDrive(double moveSpeed, double rotSpeed, double throt) {
    	
    	//Setting the throttle to run from 0 to 1 instead of -1 to 1
    	double throttle = (throt-1)/2;
    	
    	//multiplying the given speeds from the controller by the throttle
    	double move = moveSpeed*throttle;
    	double rot = rotSpeed*throttle;
    	
    	//setting the motor speeds
    	driveLeft.set(move + rot);
    	driveRight.set(-move + rot);
    }   
    @Override
    public void periodic() {
        // Put code here to be run every loop

    }

    // Put methods for controlling this subsystem
    // here. Call these from Commands.

}

