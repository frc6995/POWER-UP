
package org.usfirst.frc6995.PatriciaTheCamel.commands;
import org.usfirst.frc6995.PatriciaTheCamel.commands.LifterComGroup;
import org.usfirst.frc6995.PatriciaTheCamel.commands.LifterCom;

/**
 *
 */
public class LifterSwitchStack extends LifterComGroup {

    public LifterSwitchStack() {

    	super("LifterSwitchStack");
    	
    	this.addSequential(new LifterCom(33.0, 90.0));  //REVISIT: What are the correct heights?
    }
}
