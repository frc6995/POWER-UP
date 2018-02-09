
package org.usfirst.frc6995.PatriciaTheCamel.commands;
import org.usfirst.frc6995.PatriciaTheCamel.commands.LifterComGroup;
import org.usfirst.frc6995.PatriciaTheCamel.commands.LifterCom;

/**
 *
 */
public class LifterFenceClear extends LifterComGroup {

    public LifterFenceClear() {

    	super("LifterFenceClear");
    	
    	this.addSequential(new LifterCom(20.0, 90.0));  //REVISIT: What are the correct heights?
    }
}
