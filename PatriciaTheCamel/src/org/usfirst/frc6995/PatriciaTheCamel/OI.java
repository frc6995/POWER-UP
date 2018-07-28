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


    
    public JoystickButton trigger;
    public JoystickButton rotatorIn3;
    public JoystickButton conveyorIn4;
    public JoystickButton rotatorOut5;
    public JoystickButton conveyorOut6;
    //public JoystickButton lifterSwitchStack7;
    public JoystickButton lifterTurboCombo8;
    public JoystickButton lifterTurboCombo9;
    public JoystickButton lifterPowerSet10;
    public JoystickButton lifterUp11;
    public JoystickButton lifterDown12;
    public Joystick joystick;
    public LifterComPercentage lifterComPercentage;
    
    class RiserButtonMonitor implements RiserReqMonitor {

    	final Joystick joystick;
    	final int upButton;
    	final int dnButton;
    	final int inButton;
    	final int outButton;
    	final int zeroButton;
    	
    	RiserButtonMonitor(Joystick joystick, int upButton, int dnButton, int inButton, int outButton, int zeroButton) {
    		this.joystick = joystick;
    		this.upButton = upButton;
    		this.dnButton = dnButton;
    		this.inButton = inButton;
    		this.outButton = outButton;
    		this.zeroButton = zeroButton;
    	}
    	
		@Override
		public int riserRequest() {
			
			if ( true ) {
				//System.out.println("riserRequest");
				boolean riserUp = this.joystick.getRawButton(this.upButton);
				boolean riserDn = this.joystick.getRawButton(this.dnButton);
				
				if (riserUp && !riserDn) {
					System.out.println("lifterUp");
					return 1;
					
				}
				else if ( ! riserUp && riserDn) {
					System.out.println("lifterDown");
					return -1;
				}
			}
			
			return 0;
		}

		@Override
		public boolean rotatorConveyorStopZero() {

			// Only report zero when last button read was pressed and this button read is released
			//System.out.println("ZeroAdj");
			return this.joystick.getRawButtonReleased(this.zeroButton);
		}

		@Override
		public int rotatorMoveRequest() {

			//System.out.println("ZeroAdj");
			final boolean rotatorIn = this.joystick.getRawButton(this.inButton);
			final boolean rotatorOut = this.joystick.getRawButton(this.outButton);
			
			if (rotatorIn && ! rotatorOut) {
				return 1;
			}
			else if ( ! rotatorIn && rotatorOut) {
				return -1;
			}

			return 0;
		}

		@Override
		public boolean isClimbing() {
			if (joystick.getRawButton(7) && joystick.getRawButton(8)) {
				return true;
			} else {
				return false;
			}
		}

		@Override
		public double powerIncrement(double prevPower) { // cycles between 1/4,1/3,1/2.
			double prevpowerRecip = 1.0 / prevPower;
			double newPowerRecip;
			
			if (prevpowerRecip == 2) { 
				newPowerRecip = 4;
			} else {
				newPowerRecip = prevpowerRecip - 1;
			}
			
			return 1.0 / newPowerRecip;
			
		}
    	
    }

    public OI() {

        joystick = new Joystick(0);

    	//LifterManual lifterManual = new LifterManual(new RiserButtonMonitor(joystick, 5, 3));
    	
        lifterComPercentage = new LifterComPercentage(new RiserButtonMonitor(joystick, 11, 12, 3, 5, 7));
    	
        lifterDown12 = new JoystickButton(joystick, 12);
        lifterDown12.whenPressed(lifterComPercentage);
        lifterUp11 = new JoystickButton(joystick, 11); // This 
        lifterUp11.whenPressed(lifterComPercentage);
        lifterPowerSet10 = new JoystickButton(joystick, 10);
        //lifterConveyorGrab10.whenPressed(new LifterConveyorGrab());
        lifterTurboCombo9 = new JoystickButton(joystick, 9);
        //lifterFenceClear9.whenPressed(new LifterFenceClear());
        lifterTurboCombo8 = new JoystickButton(joystick, 8);
        //lifterScale8.whenPressed(new LifterScale());
        //lifterSwitchStack7 = new JoystickButton(joystick, 7);
        //lifterSwitchStack7.whenPressed(new LifterSwitchStack());
        rotatorOut5 = new JoystickButton(joystick, 5);
        rotatorOut5.whileHeld(lifterComPercentage);
        rotatorIn3 = new JoystickButton(joystick, 3);
        rotatorIn3.whenPressed(lifterComPercentage);
        trigger = new JoystickButton(joystick, 1);
        trigger.whenPressed(new GrabRelease());
        

        // SmartDashboard Buttons
        SmartDashboard.putData("LIFTER_PERCENTAGE", lifterComPercentage);
        
        SmartDashboard.putData("Autonomous Command", new AutonomousCommand());
        SmartDashboard.putData("DriveCom", new DriveCom());
        SmartDashboard.putData("GrabRelease", new GrabRelease());
        //SmartDashboard.putData("LifterReset", new LifterReset());
        //SmartDashboard.putData("LifterManual", lifterManual);
        SmartDashboard.putData("LifterManual", lifterComPercentage);
        //SmartDashboard.putData("LifterSwitchStack", new LifterSwitchStack());
        //SmartDashboard.putData("LifterScale", new LifterScale());
        //SmartDashboard.putData("LifterFenceClear", new LifterFenceClear());
        //SmartDashboard.putData("LifterConveyorGrab", new LifterConveyorGrab());
        //SmartDashboard.putData("LifterGroundGrab", new LifterGroundGrab());

    }

    public Joystick getJoystick() {
        return joystick;
    }
}

