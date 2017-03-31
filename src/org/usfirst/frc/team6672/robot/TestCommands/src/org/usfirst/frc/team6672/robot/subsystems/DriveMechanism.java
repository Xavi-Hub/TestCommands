package org.usfirst.frc.team6672.robot.subsystems;

import org.usfirst.frc.team6672.robot.commands.CommandBase;
import org.usfirst.frc.team6672.robot.commands.NormalDriving;

import edu.wpi.first.wpilibj.ADXRS450_Gyro;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.command.Subsystem;


/**
 *
 */
public class DriveMechanism extends Subsystem {

    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	
	RobotDrive myRobotDrive = new RobotDrive(1, 0);
	ADXRS450_Gyro myGyro = new ADXRS450_Gyro();
	
	double driveSpeed;
	double rotateSpeed;
	
	public void setDriveSpeed(double newDriveSpeed) {
		driveSpeed = newDriveSpeed;
	}
	
	public void setRotateSpeed(double newRotateSpeed) {
		rotateSpeed = newRotateSpeed;
	}
	
	public void arcadeDrive() {
			myRobotDrive.arcadeDrive(CommandBase.oi.getStickAxis1() * driveSpeed, CommandBase.oi.getStickAxis4() * rotateSpeed);
	}

	public void drive (double moveValue, double rotateValue) {
		myRobotDrive.drive(moveValue, rotateValue);
	}
	
	public double getGyroAngle() {
		return myGyro.getAngle();
	}

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    	setDefaultCommand(new NormalDriving());
    }
}

