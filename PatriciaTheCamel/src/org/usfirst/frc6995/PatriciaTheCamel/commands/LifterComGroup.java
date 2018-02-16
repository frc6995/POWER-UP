package org.usfirst.frc6995.PatriciaTheCamel.commands;
import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class LifterComGroup extends CommandGroup {

	public final String groupName;  // OK to be public since final
	
	public LifterComGroup(String groupName) {
		this.groupName = groupName;
	}
	
    public LifterComGroup() {

    	this("unknown");
    }

    // Called just before this Command runs the first time
    @Override
    protected void initialize() {
    	System.out.println(groupName + "initialized");
    	super.initialize();
    }

    // Called repeatedly when this Command is scheduled to run
    //@Override
    //protected void execute() {
    //}

    // Make this return true when this Command no longer needs to run execute()
    //@Override
    //protected boolean isFinished() {
    //    return false;
    //}

    // Called once after isFinished returns true
    @Override
    protected void end() {
    	System.out.println(groupName + " ended");
    	super.end();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    @Override
    protected void interrupted() {
    	System.out.println(groupName + " interrupted");
    	super.interrupted();
    }
}
