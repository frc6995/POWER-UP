
package org.usfirst.frc.team6995.PatriciaTheCamel.commands;
import org.usfirst.frc.team6995.PatriciaTheCamel.commands.LifterCom;
import org.usfirst.frc.team6995.PatriciaTheCamel.commands.LifterComGroup;

/**
 *
 */
public class LifterConveyorGrab extends LifterComGroup {

    public LifterConveyorGrab() {
    	
    	super("LifterConveyorGrab");
    	
    	this.addSequential(new LifterCom(20.0, 90.0));  //REVISIT: What are the correct heights?
    }
}
