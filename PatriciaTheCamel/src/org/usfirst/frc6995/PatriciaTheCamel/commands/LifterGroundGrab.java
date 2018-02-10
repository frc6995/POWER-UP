
package org.usfirst.frc6995.PatriciaTheCamel.commands;
import org.usfirst.frc6995.PatriciaTheCamel.commands.LifterComGroup;
import org.usfirst.frc6995.PatriciaTheCamel.commands.LifterCom;

/**
 *
 */
public class LifterGroundGrab extends LifterComGroup {

    public LifterGroundGrab() {

    	super("LifterGroundGrab");
    	
    	this.addSequential(new LifterCom(7.0, 135.0));  //REVISIT: What are the correct heights?
    }
}
