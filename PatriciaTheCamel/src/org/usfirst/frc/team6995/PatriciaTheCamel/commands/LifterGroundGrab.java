
package org.usfirst.frc.team6995.PatriciaTheCamel.commands;
import org.usfirst.frc.team6995.PatriciaTheCamel.commands.LifterCom;
import org.usfirst.frc.team6995.PatriciaTheCamel.commands.LifterComGroup;

/**
 *
 */
public class LifterGroundGrab extends LifterComGroup {

    public LifterGroundGrab() {

    	super("LifterGroundGrab");
    	
    	this.addSequential(new LifterCom(/*7.0*/0.0, -135.0));  //REVISIT: What are the correct heights?
    }
}
