
package org.usfirst.frc6995.PatriciaTheCamel.commands;
import edu.wpi.first.wpilibj.command.CommandGroup;
import org.usfirst.frc6995.PatriciaTheCamel.commands.LifterCalibCom;

/**
 *
 */
public class LifterReset extends CommandGroup {

    public LifterReset(int dirtyInitCycles) {
    	
    	super();

    	final int RISER_BOTTOM_STOP_OFFSET_ENC = 25;  // TODO Determine real offset needed to avoid bouncing off mech on high speed run/stop
    	final int ROTATOR_INSIDE_STOP_OFFSET_ENC = 5;  // TODO Determine real offset needed to reach parallel to the lifter frame
    	
    	// First, move Up and Out to get off of any stops, stopping early if no movement
    	// Encoders are reset at the end of this command
    	this.addSequential(new LifterCalibCom(20, 5, 20, 25));
    	
    	// Second, move Down and Out at least far enough to rotate more than half way,
    	// This is only for a dirty powerup. The same command sequence could be used for
    	// a clean powerup by reducing the timeout to an insignificant time.
    	// Encoders are reset at the end of this command
    	this.addSequential(new LifterCalibCom(Integer.MIN_VALUE, 180, 20, 50 * 20));
    	
    	// Third, move Down and In to hit the mechanical stops
    	// On a clean powerup this should take slightly more than the settling time.
    	// Encoders are reset at the end of this command
    	this.addSequential(new LifterCalibCom(Integer.MIN_VALUE, -180, 20, 50 * 20));
    	
    	// Fourth, move Up and Out fixed amounts and reset the encoders again to set (0,0)
    	this.addSequential(new LifterCalibCom(RISER_BOTTOM_STOP_OFFSET_ENC, ROTATOR_INSIDE_STOP_OFFSET_ENC, 10, 50 * 1));
    }
    
    public LifterReset() {
    	this(1);
    }

}
