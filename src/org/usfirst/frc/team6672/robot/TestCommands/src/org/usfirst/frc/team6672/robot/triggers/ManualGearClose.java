package org.usfirst.frc.team6672.robot.triggers;

import org.usfirst.frc.team6672.robot.Robot;

import edu.wpi.first.wpilibj.buttons.Trigger;

/**
 *
 */
public class ManualGearClose extends Trigger {

    public boolean get() {
    	if (Robot.oi != null) {
        	return Robot.oi.manualGearCloseActivated();
    	}
    	return false;
    }
}
