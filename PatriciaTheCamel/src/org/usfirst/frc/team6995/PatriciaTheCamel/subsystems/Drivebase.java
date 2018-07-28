// RobotBuilder Version: 2.0
//
// This file was generated by RobotBuilder. It contains sections of
// code that are automatically generated and assigned by robotbuilder.
// These sections will be updated in the future when you export to
// Java from RobotBuilder. Do not put any code or make any change in
// the blocks indicating autogenerated code or it will be lost on an
// update. Deleting the comments indicating the section will prevent
// it from being updated in the future.


package org.usfirst.frc.team6995.PatriciaTheCamel.subsystems;

import org.usfirst.frc.team6995.PatriciaTheCamel.commands.*;
import org.usfirst.frc.team6995.PatriciaTheCamel.RobotMap;

import edu.wpi.first.wpilibj.command.Subsystem;
// BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=IMPORTS
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;


    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=IMPORTS


/**
 *
 */
public class Drivebase extends Subsystem {

    public final WPI_TalonSRX driveLeft = RobotMap.drivebaseDriveLeft;
    public final WPI_TalonSRX driveRight = RobotMap.drivebaseDriveRight;

    @Override
    public void initDefaultCommand() {
        setDefaultCommand(new DriveCom());


        // Set the default command for a subsystem here.Pat
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

