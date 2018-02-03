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

import org.usfirst.frc6995.PatriciaTheCamel.commands.*;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;


/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
    //// CREATING BUTTONS
    // One type of button is a joystick button which is any button on a joystick.
    // You create one by telling it which joystick it's on and which button
    // number it is.
    // Joystick stick = new Joystick(port);
    // Button button = new JoystickButton(stick, buttonNumber);

    // There are a few additional built in buttons you can use. Additionally,
    // by subclassing Button you can create custom triggers and bind those to
    // commands the same as any other Button.

    //// TRIGGERING COMMANDS WITH BUTTONS
    // Once you have a button, it's trivial to bind it to a button in one of
    // three ways:

    // Start the command when the button is pressed and let it run the command
    // until it is finished as determined by it's isFinished method.
    // button.whenPressed(new ExampleCommand());

    // Run the command while the button is being held down and interrupt it once
    // the button is released.
    // button.whileHeld(new ExampleCommand());

    // Start the command when the button is released  and let it run the command
    // until it is finished as determined by it's isFinished method.
    // button.whenReleased(new ExampleCommand());


    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS
    public JoystickButton trigger;
    public JoystickButton lifterDown3;
    public JoystickButton conveyorIn4;
    public JoystickButton lifterUp5;
    public JoystickButton conveyorOut6;
    public JoystickButton lifterSwitchStack7;
    public JoystickButton lifterScale8;
    public JoystickButton lifterFenceClear9;
    public JoystickButton lifterConveyorGrab10;
    public JoystickButton lifterGroundGrab11;
    public JoystickButton drivebaseWallSquare12;
    public Joystick joystick;

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS

    public OI() {
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTORS

        joystick = new Joystick(0);
        
        drivebaseWallSquare12 = new JoystickButton(joystick, 12);
        drivebaseWallSquare12.whenPressed(new WallSquare(5));
        lifterGroundGrab11 = new JoystickButton(joystick, 11);
        lifterGroundGrab11.whenPressed(new LifterGroundGrab());
        lifterConveyorGrab10 = new JoystickButton(joystick, 10);
        lifterConveyorGrab10.whenPressed(new LifterConveyorGrab());
        lifterFenceClear9 = new JoystickButton(joystick, 9);
        lifterFenceClear9.whenPressed(new LifterFenceClear());
        lifterScale8 = new JoystickButton(joystick, 8);
        lifterScale8.whenPressed(new LifterScale());
        lifterSwitchStack7 = new JoystickButton(joystick, 7);
        lifterSwitchStack7.whileHeld(new LifterSwitchStack());
        conveyorOut6 = new JoystickButton(joystick, 6);
        conveyorOut6.whenPressed(new ConveyorOut(3));
        lifterUp5 = new JoystickButton(joystick, 5);
        lifterUp5.whileHeld(new LifterUp());
        conveyorIn4 = new JoystickButton(joystick, 4);
        conveyorIn4.whenPressed(new ConveyorIn(7));
        lifterDown3 = new JoystickButton(joystick, 3);
        lifterDown3.whileHeld(new LifterDown());
        trigger = new JoystickButton(joystick, 1);
        trigger.whenPressed(new GrabRelease());
        

        // SmartDashboard Buttons
        SmartDashboard.putData("Autonomous Command", new AutonomousCommand());
        SmartDashboard.putData("DriveCom", new DriveCom());
        SmartDashboard.putData("GrabRelease", new GrabRelease());
        SmartDashboard.putData("Clamp", new Clamp());
        SmartDashboard.putData("LifterDown", new LifterDown());
        SmartDashboard.putData("CameraLeft", new CameraLeft());
        SmartDashboard.putData("LifterUp", new LifterUp());
        SmartDashboard.putData("LifterSwitchStack", new LifterSwitchStack());
        SmartDashboard.putData("LifterScale", new LifterScale());
        SmartDashboard.putData("LifterFenceClear", new LifterFenceClear());
        SmartDashboard.putData("LifterConveyorGrab", new LifterConveyorGrab());
        SmartDashboard.putData("LifterGroundGrab", new LifterGroundGrab());
        SmartDashboard.putData("ConveyorOut", new ConveyorOut());
        SmartDashboard.putData("ConveyorIn", new ConveyorIn());

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTORS
    }

    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=FUNCTIONS
    public Joystick getJoystick() {
        return joystick;
    }


    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=FUNCTIONS
}
