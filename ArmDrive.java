// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import frc.robot.Constants;
import frc.robot.RobotContainer;
import edu.wpi.first.wpilibj2.command.SubsystemBase;


public class ArmDrive extends SubsystemBase {

	TalonSRX frontMotor = new TalonSRX(Constants.armConstants.FRONT_MOTOR);
	TalonSRX backMotor = new TalonSRX(Constants.armConstants.BACK_MOTOR);

	public boolean triggerState,grabTriggerState,deployTC;
	public int debounceCooldown,grabDebounceCooldown,deployDebounceCooldown;

	public ArmDrive()
	{
        frontMotor.setInverted(true);
		backMotor.setInverted(false);

		frontMotor.setNeutralMode(NeutralMode.Brake);
		backMotor.setNeutralMode(NeutralMode.Brake);

		setBackMotor(0);
		setFrontMotor(0);
    }

	public void init()
	{
		RobotContainer.pneumatics.disableCompressor();
		RobotContainer.pneumatics.offFrontArmSolenoid();
		RobotContainer.pneumatics.offBackArmSolenoid();
		RobotContainer.pneumatics.offGrabSolenoid();
		RobotContainer.pneumatics.offDeploySolenoid();

		triggerState = false;
		grabTriggerState = false;
		deployTC = false;
		debounceCooldown = 0;
		grabDebounceCooldown = 0;
		deployDebounceCooldown = 0;
		System.out.println("INITALIZATION");

		RobotContainer.pneumatics.enableCompressor();
	}

	@Override
	public void periodic()
	{
	// This method will be called once per scheduler run
		if (debounceCooldown < 20 && !RobotContainer.controller.getRawButton(1))
			debounceCooldown++;
		if (grabDebounceCooldown < 20 && !RobotContainer.controller.getRawButton(2))
			grabDebounceCooldown++;
		if (deployDebounceCooldown < 20 && !RobotContainer.controller.getRawButton(3))
			deployDebounceCooldown++;
	}

	@Override
	public void simulationPeriodic()
	{
	// This method will be called once per scheduler run during simulation
	}


	public void setFrontMotor(double speed)
	{
		if (speed >= -1 && speed <= 1)
		{
			frontMotor.set(ControlMode.PercentOutput, speed);
		}
		else
		{
			frontMotor.set(ControlMode.PercentOutput, 0);
		}
	}
	public void setBackMotor(double speed)
	{
		if (speed >= -1 && speed <= 1)
		{
			backMotor.set(ControlMode.PercentOutput, speed);
		}
		else
		{
			backMotor.set(ControlMode.PercentOutput, 0);
		}
	}

}