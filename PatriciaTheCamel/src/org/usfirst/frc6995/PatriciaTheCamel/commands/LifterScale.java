package org.usfirst.frc6995.PatriciaTheCamel.commands;
import org.usfirst.frc6995.PatriciaTheCamel.commands.LifterComGroup;
import org.usfirst.frc6995.PatriciaTheCamel.commands.LifterCom;

/**
 *
 */
public class LifterScale extends LifterComGroup {

    public LifterScale() {

    	super("LifterScale");
    	
    	this.addSequential(new LifterCom(100.0, 45.0));  // Let LifterCom limit to the maximum height
    }
}
