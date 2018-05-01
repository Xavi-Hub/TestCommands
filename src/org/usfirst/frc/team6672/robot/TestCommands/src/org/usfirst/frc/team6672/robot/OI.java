package org.usfirst.frc.team6672.robot;

import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import edu.wpi.first.wpilibj.buttons.Trigger;

import org.usfirst.frc.team6672.robot.commands.CloseGearHolderContinued;
import org.usfirst.frc.team6672.robot.commands.CloseGearHolderOnce;
import org.usfirst.frc.team6672.robot.commands.DriveSpeed10;
import org.usfirst.frc.team6672.robot.commands.DriveSpeed8;
import org.usfirst.frc.team6672.robot.commands.OpenGearHolderContinued;
import org.usfirst.frc.team6672.robot.commands.OpenGearHolderOnce;
import org.usfirst.frc.team6672.robot.commands.RotateSpeed10;
import org.usfirst.frc.team6672.robot.commands.RotateSpeed6;
import org.usfirst.frc.team6672.robot.commands.RotateSpeed7;
import org.usfirst.frc.team6672.robot.commands.TurnRopeClimber;
import org.usfirst.frc.team6672.robot.triggers.AutoGearClose;
import org.usfirst.frc.team6672.robot.triggers.AutoGearOpen;
import org.usfirst.frc.team6672.robot.triggers.ManualGearClose;
import org.usfirst.frc.team6672.robot.triggers.ManualGearOpen;

import edu.wpi.first.wpilibj.Joystick;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
	//// CREATING BUTTONS
	// One type of button is a joystick button which is any button on a
	//// joystick.
	// You create one by telling it which joystick it's on and which button
	// number it is.
	// Joystick stick = new Joystick(port);
	// Button button = new JoystickButton(stick, buttonNumber);

	// There are a few additional built in buttons you can use. Additionally,
	// by subclassing Button you can create custom triggers and bind those to
	// commands the same as any other Button.

	//// TRIGGERING COMMANDS WITH BUTTONS
	// Once you have a button, it's trivial to bind it to a button in one of
	// three ways:

	// Start the command when the button is pressed and let it run the command
	// until it is finished as determined by it's isFinished method.
	// button.whenPressed(new ExampleCommand());

	// Run the command while the button is being held down and interrupt it once
	// the button is released.
	// button.whileHeld(new ExampleCommand());

	// Start the command when the button is released and let it run the command
	// until it is finished as determined by it's isFinished method.
	// button.whenReleased(new ExampleCommand());
	Joystick stick = new Joystick(0);
	Button A = new JoystickButton(stick, 1);
	Button B = new JoystickButton(stick, 2);
	Button X = new JoystickButton(stick, 3);
	Button Y = new JoystickButton(stick, 4);
	Button LB = new JoystickButton(stick, 5);
	Button RB = new JoystickButton(stick, 6);
	Button SELECT = new JoystickButton(stick, 7);
	
	Trigger autoGearOpen = new AutoGearOpen();
	Trigger autoGearClose = new AutoGearClose();
	Trigger manualGearOpen = new ManualGearOpen();
	Trigger manualGearClose = new ManualGearClose();
	
	public double getStickAxis1(){
		double stickAxis1 = stick.getRawAxis(1);
		return stickAxis1;
	}
	
	public double getStickAxis4(){
		double stickAxis4 = stick.getRawAxis(4);
		return stickAxis4;
	}
	
	public boolean autoGearOpenPressed() {
		return stick.getRawAxis(3) > .5 ;
	}
	
	public boolean autoGearClosePressed() {
		return stick.getRawAxis(2) > .5 ;
	}
	
	public boolean manualGearOpenActivated() {
		return SELECT.get() && stick.getRawAxis(3) > .5 ;
	}
	
	public boolean manualGearCloseActivated() {
		return SELECT.get() && stick.getRawAxis(2) > .5 ;
	}
	
	public OI(){
		autoGearOpen.whenActive(new OpenGearHolderOnce());
		autoGearClose.whenActive(new CloseGearHolderOnce());
		manualGearOpen.whileActive(new OpenGearHolderContinued());
		manualGearClose.whileActive(new CloseGearHolderContinued());
		X.whenPressed(new RotateSpeed6());
		A.whenPressed(new RotateSpeed7());
		B.whenPressed(new RotateSpeed10());
		Y.whileHeld(new TurnRopeClimber());
		LB.whenPressed(new DriveSpeed8());
		RB.whenPressed(new DriveSpeed10());
		
	}
	
}
