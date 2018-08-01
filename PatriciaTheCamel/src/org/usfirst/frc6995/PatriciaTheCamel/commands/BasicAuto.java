package org.usfirst.frc6995.PatriciaTheCamel.commands;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class BasicAuto extends CommandGroup {

    public BasicAuto() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	addSequential(new DriveDistance(Robot.autoDistance));
    	System.out.println("drive Command added to group" );
    }
}
