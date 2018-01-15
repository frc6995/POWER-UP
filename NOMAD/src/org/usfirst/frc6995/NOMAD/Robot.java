package org.usfirst.frc6995.NOMAD;

import edu.wpi.cscore.CameraServerJNI;
import edu.wpi.first.wpilibj.CameraServer;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import org.usfirst.frc6995.NOMAD.commands.*;
import org.usfirst.frc6995.NOMAD.subsystems.*;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the TimedRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the build.properties file in 
 * the project.
 */
public class Robot extends TimedRobot {

    Command AUTONOMOUS;
    SendableChooser<Command> chooser = new SendableChooser<>();

    //setting subsystems to variables
    public static OI CONTROLS;
    public static DriveTrain DRIVE_TRAIN;
    public static pneumatics PNEUMATICS;

    /**
     * This function is run when the robot is first started up and should be
     * used for any initialization code.
     */
    @Override
    public void robotInit() {
        RobotMap.init();
        //Setting subsystems
        //setting up the driveTrain subsystem
        DRIVE_TRAIN = new DriveTrain();
        PNEUMATICS = new pneumatics();
       

        //OI.java (CONTROLS) MUST BE SET UP AFTER ANY OTHER SUBSYSTEMS. DO NOT PUT ANY SUBSYSTEMS AFTER THIS
        CONTROLS = new OI();

        // Add commands to Autonomous Sendable Chooser

        //Creating the autonomous command
        chooser.addDefault("Autonomous Command", new AutonomousCommand());

        SmartDashboard.putData("Auto mode", chooser);
    }

    /**
     * This function is called when the disabled button is hit.
     * You can use it to reset subsystems before shutting down.
     */
    @Override
    public void disabledInit() {

    }

    @Override
    public void disabledPeriodic() {
        Scheduler.getInstance().run();
    }

    @Override
    public void autonomousInit() {
    	AUTONOMOUS = chooser.getSelected();
        // schedule the autonomous command (example)
        if (AUTONOMOUS != null) AUTONOMOUS.start();
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
        // teleop starts running.
        if (AUTONOMOUS != null) AUTONOMOUS.cancel();
    }

    /**
     * This function is called periodically during operator control
     */
    @Override
    public void teleopPeriodic() {
        Scheduler.getInstance().run();
    }
}
