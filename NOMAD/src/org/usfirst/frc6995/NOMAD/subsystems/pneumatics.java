package org.usfirst.frc6995.NOMAD.subsystems;

import org.usfirst.frc6995.NOMAD.RobotMap;
import org.usfirst.frc6995.NOMAD.commands.grabberCom;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.DoubleSolenoid;



/**
 *
 */
public class pneumatics extends Subsystem {

    // Put methods for controlling this subsystem
    // here. Call these from Commands.
    DoubleSolenoid doubleSolenoid =new DoubleSolenoid(1,2);
    Compressor compressor = new Compressor();


    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        setDefaultCommand(new grabberCom());
    }
    
    public void initilizeCompressor() {
    	
    }
    
    public void openCylinder() {
    }
}

