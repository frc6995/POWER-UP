
package org.usfirst.frc.team6995.PatriciaTheCamel.commands;
import org.usfirst.frc.team6995.PatriciaTheCamel.commands.LifterCom;
import org.usfirst.frc.team6995.PatriciaTheCamel.commands.LifterComGroup;

/**
 *
 */
public class LifterScale extends LifterComGroup {

    public LifterScale() {

    	super("LifterScale");
    	
    	this.addSequential(new LifterCom(100.0, 45.0));  // Let LifterCom limit to the maximum height
    }
}
