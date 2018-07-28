package org.usfirst.frc.team6995.PatriciaTheCamel.commands;

import edu.wpi.first.wpilibj.CameraServer;
import edu.wpi.first.wpilibj.command.Command;

import org.usfirst.frc.team6995.PatriciaTheCamel.Robot;
import org.usfirst.frc.team6995.PatriciaTheCamel.RobotMap;

import com.ctre.phoenix.motorcontrol.ControlMode;

/**
 *
 */
public class LifterComPercentage extends Command {
	
	private RiserReqMonitor riserReq;
	int cycles = 50;
	enum BrakeState {
		eBrakeStateUnbraked,
		eBrakeStateUnbraking,
		eBrakeStateBraking,
		eBrakeStateBraked,	
	};
	BrakeState brakeState = BrakeState.eBrakeStateUnbraked;
	double riserPowerUp= 1/4;
	final int BRAKING_VELOCITY_THRESHOLD = 375;   //TODO Need real value
	final int BRAKING_CYCLES = 10;
	final int UNBRAKING_CYCLES = 5;
	private int brakingCycles;
	private int unbrakingCycles;
//	static int destAngleEnc = 0;

	final int CONVEYOR_STOP_DEGREES = 60;
	final int CONVEYOR_GRAB_DEGREES = 17;
	
	public LifterComPercentage(RiserReqMonitor riserReqMonitor) {
		this.riserReq = riserReqMonitor;
		this.setInterruptible(false);
		requires(Robot.lifter);
	}
	
    private LifterComPercentage() {
    }

    // Called just before this Command runs the first time
    @Override
    protected void initialize() {
    	RobotMap.lifterLifterMotorA.set(ControlMode.PercentOutput,0);
    }

    // Called repeatedly when this Command is scheduled to run
    @Override
    protected void execute() {
    	final int currAngleEnc = RobotMap.lifterLifterRotatorMotor.getSensorCollection().getQuadraturePosition();
    	final int currLifterVelocity = RobotMap.lifterLifterMotorA.getSensorCollection().getQuadratureVelocity();
		//final int rotatorAdjustDirection = Math.max(-1, Math.min(this.riserReq.rotatorZeroAdjustRequest(), 1)) * -5;
		final boolean climbing = this.riserReq.isClimbing();

		//System.out.print("LifterComPercentage: rotatorAdjustDirection = ");
		//System.out.print(currAngleEnc);
		//System.out.print(" by ");
		//System.out.println(rotatorAdjustDirection);
		//if (0 != rotatorAdjustDirection) {
			//RobotMap.lifterLifterRotatorMotor.getSensorCollection().setQuadraturePosition(currAngleEnc - rotatorAdjustDirection, 10);	
		//}
		
    	int riserDirection = this.riserReq.riserRequest();
    	
    	switch (brakeState) {
    	case eBrakeStateBraked:
    		if (riserDirection != 0 || climbing) {
            	brakeState = BrakeState.eBrakeStateUnbraking;
            	unbrakingCycles = UNBRAKING_CYCLES;  // Initialize our delay time
            	RobotMap.lifterBrake.set(false);  // Remove brake
            	System.out.println("Unbraking");
            	
    		} else {
            	RobotMap.lifterBrake.set(true);  // Apply brake
    		}
    		break;
    	case eBrakeStateBraking:
    		if (riserDirection != 0) {
    			// TODO Remove brake, transition to unbraked
    			brakeState = BrakeState.eBrakeStateUnbraked;
    		} else {
    			if (brakingCycles > 0) {
					brakingCycles -= 1;
				} else if (brakingCycles <= 0) {
					brakeState = BrakeState.eBrakeStateBraked;
				}
    		}
    		break;
    	case eBrakeStateUnbraked:
			
			// Transition in to Unbraked state & apply power
		    if (climbing) {    		        	
	        	//RobotMap.lifterLifterMotorA.set(-1);
	        	System.out.println("CLIMBING");
		        //	System.out.println("Climbing");
		    } else if (riserDirection == 0) {
	    		// Transition to Braking
	    		brakeState = BrakeState.eBrakeStateBraking;
	        	brakingCycles = BRAKING_CYCLES; 
	    		System.out.println("Braking");
	    		
	    	} else if (riserDirection > 0) {
	        	RobotMap.lifterLifterMotorA.set(0.5);
		        //	System.out.println("Going UP");
		        	
			} else if (riserDirection < 0) {
				RobotMap.lifterLifterMotorA.set(-0.25);
				
			} else /* going down normal rate */ {
	        	RobotMap.lifterLifterMotorA.set(0);
		        //	System.out.println("Going Down");
			}
     		break;
    	case eBrakeStateUnbraking:
    		if (riserDirection != 0 || climbing) {
    			if (unbrakingCycles > 0) unbrakingCycles -= 1;
    			
    			if (unbrakingCycles <= 0) {
    				brakeState = BrakeState.eBrakeStateUnbraked;
    			}   	
    		} else {
    			brakeState = BrakeState.eBrakeStateBraking;
	        	brakingCycles = BRAKING_CYCLES;    		
    		}    		
    	default:
    		// Do Nothing
    	}
    	/*if ((brakeState == BrakeState.eBrakeStateUnbraking && unbrakingCycles <= 0)) {
    		brakeState = BrakeState.eBrakeStateUnbraked;
    		unbrakingCycles = UNBRAKING_CYCLES;
    		System.out.println("UNBRAKED");
    	}
    	
    	if ((brakeState == BrakeState.eBrakeStateBraking && 
    			Math.abs(currLifterVelocity) < BRAKING_VELOCITY_THRESHOLD) || (brakeState == BrakeState.eBrakeStateBraking && brakingCycles <= 0)) {
    		brakeState = BrakeState.eBrakeStateBraked;
    		RobotMap.lifterBrake.set(true);
    		brakingCycles = BRAKING_CYCLES;
    		System.out.println("BRAKED");
    	}
    	*/
    	//RobotMap.lifterLifterRotatorMotor.set(ControlMode.MotionMagic, destAngleEnc);
    	if (cycles == 0) {	
    	final boolean rotatorReset = this.riserReq.rotatorConveyorStopZero();
    	if (rotatorReset) {
    		RobotMap.lifterLifterRotatorMotor.getSensorCollection().setQuadraturePosition(rotatorDegToEncCounts(CONVEYOR_STOP_DEGREES), 0);
        	RobotMap.lifterLifterRotatorMotor.set(ControlMode.MotionMagic, rotatorDegToEncCounts(0));
        	System.out.println("Rotator @ " + RobotMap.lifterLifterRotatorMotor.getSensorCollection().getQuadraturePosition());
    	}


    	int rotatorDirection = this.riserReq.rotatorMoveRequest();
    	
    	if (rotatorDirection > 0) {
    		if (GrabRelease.getGrabberOpen()) {
    			RobotMap.lifterLifterRotatorMotor.set(ControlMode.PercentOutput, 0.3);
    		}
    		else {
    			RobotMap.lifterLifterRotatorMotor.set(ControlMode.PercentOutput, 0.9);
    		}
    		System.out.println("Lifter @ " + RobotMap.lifterLifterRotatorMotor.getSensorCollection().getQuadraturePosition());
		} else if (rotatorDirection < 0) {
			if (GrabRelease.getGrabberOpen()) { 
				RobotMap.lifterLifterRotatorMotor.set(ControlMode.PercentOutput, -0.3);
			}
			else {
				RobotMap.lifterLifterRotatorMotor.set(ControlMode.PercentOutput, -0.9);
			}
			System.out.println("Lifter @ " + RobotMap.lifterLifterRotatorMotor.getSensorCollection().getQuadraturePosition());
		} else {
        	RobotMap.lifterLifterRotatorMotor.set(ControlMode.PercentOutput, 0);
		}
   	
    	if (riserDirection > 0) {
        	RobotMap.lifterLifterMotorA.set(ControlMode.PercentOutput, 1.0/3);
		} else if (riserDirection < 0) {
        	RobotMap.lifterLifterMotorA.set(ControlMode.PercentOutput, -0.125);
		} else {
        	RobotMap.lifterLifterMotorA.set(ControlMode.PercentOutput, 0);
		}
    	
    		System.out.println("Riser   @ " + RobotMap.lifterLifterMotorA.getSensorCollection().getQuadraturePosition());
    		System.out.println("Rotator @ " + RobotMap.lifterLifterRotatorMotor.getSensorCollection().getQuadraturePosition());
   		cycles = 50;
    	}
    	cycles -= 1;
    	
    	/*if (Robot.oi.joystick.getRawButtonPressed(10)) {
    		riserPowerUp = this.riserReq.powerIncrement(riserPowerUp);
    	}
    	
    	if (brakeState == BrakeState.eBrakeStateBraking) {
    		brakingCycles --;
    	}
    	if (brakeState == BrakeState.eBrakeStateUnbraking) {
			unbrakingCycles --;
		}*/
    }

    // Make this return true when this Command no longer needs to run execute()
    @Override
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    @Override
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    @Override
    protected void interrupted() {
    	end();
    }
    
    public static void setAngle(double Angle) {
//    	destAngleEnc = (int) rotatorDegToEncCounts(Angle);
    }
    
    public static int rotatorDegToEncCounts(double deg) {
    	return (int) ((4096/360) * deg);
  }
}
