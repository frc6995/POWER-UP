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
    
    class RiserButtonMonitor implements RiserReqMonitor {

    	final Joystick joystick;
    	final int upButton;
    	final int dnButton;
    	
    	RiserButtonMonitor(Joystick joystick, int upButton, int dnButton) {
    		this.joystick = joystick;
    		this.upButton = upButton;
    		this.dnButton = dnButton;
    	}
    	
		@Override
		public int riserRequest() {
			
			if (180 != this.joystick.getPOV()) {
				boolean riserUp = this.joystick.getRawButton(this.upButton);
				boolean riserDn = this.joystick.getRawButton(this.dnButton);
				
				if (riserUp && !riserDn) {
					return 1;
				}
				else if (!riserUp && riserDn) {
					return -1;
				}
			}
			
			return 0;
		}

		@Override
		public int rotatorZeroAdjustRequest() {
			
			if (180 == this.joystick.getPOV()) {
				boolean rotatorIn = this.joystick.getRawButton(this.upButton);
				boolean rotatorOut = this.joystick.getRawButton(this.dnButton);
				
				if (rotatorIn && !rotatorOut) {
					return 1;
				}
				else if (!rotatorIn && rotatorOut) {
					return -1;
				}
			}

			return 0;
		}
    	
    }

    public OI() {

        joystick = new Joystick(0);

    	LifterManual lifterManual = new LifterManual(new RiserButtonMonitor(joystick, 5, 3));
    	
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
        lifterSwitchStack7.whenPressed(new LifterSwitchStack());
        conveyorOut6 = new JoystickButton(joystick, 6);
        conveyorOut6.whenPressed(new ConveyorOut(3));
        lifterUp5 = new JoystickButton(joystick, 5);
        lifterUp5.whenPressed(lifterManual);
        conveyorIn4 = new JoystickButton(joystick, 4);
        conveyorIn4.whenPressed(new ConveyorIn(7));
        lifterDown3 = new JoystickButton(joystick, 3);
        lifterDown3.whenPressed(lifterManual);
        trigger = new JoystickButton(joystick, 1);
        trigger.whenPressed(new GrabRelease());
        

        // SmartDashboard Buttons
        SmartDashboard.putData("Autonomous Command", new AutonomousCommand());
        SmartDashboard.putData("DriveCom", new DriveCom());
        SmartDashboard.putData("GrabRelease", new GrabRelease());
        SmartDashboard.putData("LifterReset", new LifterReset());
        SmartDashboard.putData("CameraLeft", new CameraLeft());
        SmartDashboard.putData("LifterManual", lifterManual);
        SmartDashboard.putData("LifterSwitchStack", new LifterSwitchStack());
        SmartDashboard.putData("LifterScale", new LifterScale());
        SmartDashboard.putData("LifterFenceClear", new LifterFenceClear());
        SmartDashboard.putData("LifterConveyorGrab", new LifterConveyorGrab());
        SmartDashboard.putData("LifterGroundGrab", new LifterGroundGrab());
        SmartDashboard.putData("ConveyorOut", new ConveyorOut());
        SmartDashboard.putData("ConveyorIn", new ConveyorIn());
    }

    public Joystick getJoystick() {
        return joystick;
    }
}

