
package org.usfirst.frc.team6995.PatriciaTheCamel.commands;
import org.usfirst.frc.team6995.PatriciaTheCamel.commands.LifterCom;
import org.usfirst.frc.team6995.PatriciaTheCamel.commands.LifterComGroup;

/**
 *
 */
public class LifterSwitchStack extends LifterComGroup {

    public LifterSwitchStack() {

    	super("LifterSwitchStack");
    	
    	this.addSequential(new LifterCom(/*33.0*/ 0.0, -90.0));  //REVISIT: What are the correct heights?
    }
}
