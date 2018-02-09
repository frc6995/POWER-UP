package org.usfirst.frc6995.PatriciaTheCamel.commands;

public interface RiserReqMonitor {
    // Function called in execute cycle to determine the 
	// direction to adjust the riser height.
	// A negative return value causes the riser to lower.
	// A zero return value causes the riser to stop.
	// A positive return value causes the riser to raise.
	int riserRequest();
}
