package org.usfirst.frc.team6672.robot.subsystems;

import org.usfirst.frc.team6672.robot.Robot;

import org.usfirst.frc.team6672.robot.commands.NormalDriving;

import edu.wpi.first.wpilibj.ADXRS450_Gyro;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.command.Subsystem;


/**
 *
 */
public class DriveMechanism extends Subsystem {

    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	
	Spark lSpeedController = new Spark(1);
	Spark rSpeedController = new Spark(0);
	DifferentialDrive myRobotDrive = new DifferentialDrive(lSpeedController, rSpeedController);
//	RobotDrive myRobotDrive = new RobotDrive(1, 0);
	ADXRS450_Gyro myGyro = new ADXRS450_Gyro();
	
	double driveSpeed = 0.8;
	double rotateSpeed = 0.7;
	
	public void setDriveSpeed(double newDriveSpeed) {
		driveSpeed = newDriveSpeed;
	}
	
	public void setRotateSpeed(double newRotateSpeed) {
		rotateSpeed = newRotateSpeed;
	}
	
	public void arcadeDrive() {
			myRobotDrive.arcadeDrive(Robot.oi.getStickAxis1() * driveSpeed, Robot.oi.getStickAxis4() * rotateSpeed);
	}

	public void drive (double moveValue, double rotateValue) {
		myRobotDrive.curvatureDrive(moveValue, rotateValue, true);
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

