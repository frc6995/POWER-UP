package org.usfirst.frc6995.PatriciaTheCamel;

import edu.wpi.first.wpilibj.CameraServer;
import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import org.usfirst.frc6995.PatriciaTheCamel.commands.*;
import org.usfirst.frc6995.PatriciaTheCamel.subsystems.*;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the TimedRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the build.properties file in 
 * the project.
 */
public class Robot extends TimedRobot {

	RotatorCom rotatorCom;
    Command autonomousCommand;
    SendableChooser<Command> chooser = new SendableChooser<>();

    public static OI oi;
    
    public static Grabber grabber;
    public static Conveyor conveyor;
    public static CameraShuttle cameraShuttle;
    public static Lifter lifter;
    public static Drivebase drivebase;

    /**
     * This function is run when the robot is first started up and should be
     * used for any initialization code.
     */
    @Override
    public void robotInit() {
        RobotMap.init();
        
        grabber = new Grabber();
        conveyor = new Conveyor();
        cameraShuttle = new CameraShuttle();
        lifter = new Lifter();
        drivebase = new Drivebase();

        CameraServer.getInstance().startAutomaticCapture();
        // OI must be constructed after subsystems. If the OI creates Commands
        //(which it very likely will), subsystems are not guaranteed to be
        // constructed yet. Thus, their requires() statements may grab null
        // pointers. Bad news. Don't move it.
        oi = new OI();
        rotatorCom = new RotatorCom();
        // Add commands to Autonomous Sendable Chooser

        chooser.addDefault("Autonomous Command", new AutonomousCommand());

        SmartDashboard.putData("Auto mode", chooser);
    }

    /**
     * This function is called when the disabled button is hit.
     * You can use it to reset subsystems before shutting down.
     */
    @Override
    public void disabledInit(){

    }

    @Override
    public void disabledPeriodic() {
        Scheduler.getInstance().run();
    }

    @Override
    public void autonomousInit() {
        autonomousCommand = chooser.getSelected();
        // schedule the autonomous command (example)
        if (autonomousCommand != null) autonomousCommand.start();
        String gameData;
		gameData = DriverStation.getInstance().getGameSpecificMessage();
		if(gameData.charAt(0) == 'L')
		{
			if(gameData.charAt(1) == 'L')
			{
				System.out.println("Switch L, Scale L");
			} else {
				System.out.println("Switch L, Scale R");
			}
		} else {
			if(gameData.charAt(1) == 'L') 
			{
				System.out.println("Switch R, Scale L");
			} else {
				System.out.println("Switch R, Scale R");
			}
		}
    }

    /**
     * This function is called periodically during autonomous
     */
    @Override
    public void autonomousPeriodic() {
        Scheduler.getInstance().run();
    }

    @Override
    public void teleopInit() {
        // This makes sure that the autonomous stops running when
        // teleop starts running. If you want the autonomous to
        // continue until interrupted by another command, remove
        // this line or comment it out.
        if (autonomousCommand != null) autonomousCommand.cancel();
    }

    /**
     * This function is called periodically during operator control
     */
    @Override
    public void teleopPeriodic() {
    	if (!rotatorCom.isRunning() || rotatorCom.isCanceled()) {
    		rotatorCom.start();
    	}
    	
        Scheduler.getInstance().run();
    }
}