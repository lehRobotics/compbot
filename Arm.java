// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import frc.robot.Constants;
import frc.robot.RobotContainer;
import edu.wpi.first.wpilibj2.command.CommandBase;

/** An example command that uses an example subsystem. */
public class Arm extends CommandBase
{
    @SuppressWarnings({ "PMD.UnusedPrivateFeld", "PMD.SingularField" })


    /**
     * Creates a new TankDrive.
     *
     * @param subsystem The subsystem used by this command.
     */
	public Arm()
	{
		// Use addRequirements() here to declare subsystem dependencies.
		addRequirements(RobotContainer.pneumatics);
  	}

	// Called when the command is initially scheduled.
	@Override
	public void initialize() 
	{
		RobotContainer.armDrive.init();
	}


	// Called every time the scheduler runs while the command is scheduled.
	@Override
	public void execute() 
	{
		boolean triggerState = RobotContainer.armDrive.triggerState;
		boolean grabTriggerState = RobotContainer.armDrive.grabTriggerState;
		boolean deployTriggerState = RobotContainer.armDrive.deployTC;



		int debounceCooldown = RobotContainer.armDrive.debounceCooldown;
		int grabDebounceCooldown = RobotContainer.armDrive.grabDebounceCooldown;
		int deployDebounceCooldown = RobotContainer.armDrive.deployDebounceCooldown;
		
		// arm
		boolean rawPress1 = RobotContainer.controller.getRawButtonPressed(1);
		// grab
		boolean rawPress2 = RobotContainer.controller.getRawButtonPressed(2);
		// deploy
		boolean rawPress3 = RobotContainer.controller.getRawButtonPressed(3);

		if (rawPress1 && triggerState == false && debounceCooldown > 10)
		{
			RobotContainer.pneumatics.offBackArmSolenoid();
			RobotContainer.pneumatics.onFrontArmSolenoid();
			RobotContainer.armDrive.triggerState = true;
			RobotContainer.armDrive.debounceCooldown = 0;
		}
		else if (rawPress1 && triggerState == true && debounceCooldown > 10)
		{
			RobotContainer.pneumatics.onBackArmSolenoid();
			RobotContainer.pneumatics.offFrontArmSolenoid();
			RobotContainer.armDrive.triggerState = false;
			RobotContainer.armDrive.debounceCooldown = 0;
		}
		if (rawPress2 && grabTriggerState == false && grabDebounceCooldown > 10)
		{
			RobotContainer.pneumatics.onGrabSolenoid();
			RobotContainer.armDrive.grabTriggerState = true;
			RobotContainer.armDrive.grabDebounceCooldown = 0;
		}
		else if (rawPress2 && grabTriggerState == true && grabDebounceCooldown > 10)
		{
			RobotContainer.pneumatics.offGrabSolenoid();
			RobotContainer.armDrive.grabTriggerState = false;
			RobotContainer.armDrive.grabDebounceCooldown = 0;
		}
		if (rawPress3 && deployTriggerState == false && deployDebounceCooldown > 10)
		{
			RobotContainer.pneumatics.onDeploySolenoid();
			RobotContainer.armDrive.deployTC = true;
			RobotContainer.armDrive.deployDebounceCooldown = 0;
		}
		if (rawPress3 && deployTriggerState == true && deployDebounceCooldown > 10)
		{
			RobotContainer.pneumatics.offDeploySolenoid();
			RobotContainer.armDrive.deployTC = false;
			RobotContainer.armDrive.deployDebounceCooldown = 0;
		}
		

		if (RobotContainer.controller.getPOV() == 0)
		{
			RobotContainer.armDrive.setFrontMotor(Constants.armConstants.FRONT_MOTOR_SPEED);
			RobotContainer.armDrive.setBackMotor(Constants.armConstants.BACK_MOTOR_SPEED);
		}
		else if (RobotContainer.controller.getPOV() == 180)
		{
			RobotContainer.armDrive.setFrontMotor(-Constants.armConstants.FRONT_MOTOR_SPEED);
			RobotContainer.armDrive.setBackMotor(-Constants.armConstants.BACK_MOTOR_SPEED);
		}
		else
		{
			RobotContainer.armDrive.setFrontMotor(0);
			RobotContainer.armDrive.setBackMotor(0);
		}
  	}

	// Called once the command ends or is interrupted.
	@Override
	public void end(boolean interrupted) 
	{
		RobotContainer.pneumatics.disableCompressor();
		RobotContainer.pneumatics.offFrontArmSolenoid();
		RobotContainer.pneumatics.offBackArmSolenoid();
	}

	// Returns true when the command should end.
	@Override
	public boolean isFinished()
	{
		return false;
	}
}
