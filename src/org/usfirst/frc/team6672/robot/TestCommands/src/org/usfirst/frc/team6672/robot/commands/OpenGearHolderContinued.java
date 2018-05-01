package org.usfirst.frc.team6672.robot.commands;
import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc.team6672.robot.Robot;


/**
 *
 */
public class OpenGearHolderContinued extends Command {

    public OpenGearHolderContinued() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(Robot.gearHolder);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	Robot.gearHolder.open();
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.gearHolder.stop();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	end();
    }
}
