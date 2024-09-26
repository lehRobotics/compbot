// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;
import frc.robot.Constants;
import edu.wpi.first.wpilibj2.command.SubsystemBase;


public class DriveTrain extends SubsystemBase {

	VictorSPX frontRightMotor = new VictorSPX(Constants.driveConstants.FRONT_RIGHT_MOTOR);
	VictorSPX backRightMotor = new VictorSPX(Constants.driveConstants.BACK_RIGHT_MOTOR);
	VictorSPX frontLeftMotor = new VictorSPX(Constants.driveConstants.FRONT_LEFT_MOTOR);
	VictorSPX backLeftMotor = new VictorSPX(Constants.driveConstants.BACK_LEFT_MOTOR);

	public DriveTrain()
	{
        backLeftMotor.setInverted(false);
		backRightMotor.setInverted(true);
		frontLeftMotor.setInverted(false);
		frontRightMotor.setInverted(true);
    }

	@Override
	public void periodic()
	{
	// This method will be called once per scheduler run
	}

	@Override
	public void simulationPeriodic()
	{
	// This method will be called once per scheduler run during simulation
	}


	public void FLMset(double speed)
	{
		// since the talon/victor only accepts values between -1 and 1 (100% backwards & forwards respectivly)
		if (speed >= -1 && speed <= 1)
		{
			frontLeftMotor.set(ControlMode.PercentOutput, speed);
		}
		else
		{
			frontLeftMotor.set(ControlMode.PercentOutput, 0);
		}
	}

	public void FRMset(double speed)
	{
		if (speed >= -1 && speed <= 1)
		{
			frontRightMotor.set(ControlMode.PercentOutput, speed);
		}
		else
		{
			frontRightMotor.set(ControlMode.PercentOutput, 0);
		}
	}
	public void BRMset(double speed)
	{
		if (speed >= -1 && speed <= 1)
		{
			backRightMotor.set(ControlMode.PercentOutput, speed);
		}
		else
		{
			backRightMotor.set(ControlMode.PercentOutput, 0);
		}
	}
	public void BLMset(double speed)
	{
		if (speed >= -1 && speed <= 1)
		{
			backLeftMotor.set(ControlMode.PercentOutput, speed);
		}
		else
		{
			backLeftMotor.set(ControlMode.PercentOutput, 0);
		}
	}
	
}
