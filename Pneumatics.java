// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;


import frc.robot.Constants;
import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.PneumaticsModuleType;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Pneumatics extends SubsystemBase {

	Compressor pcmCompressor = new Compressor(0, PneumaticsModuleType.CTREPCM);
	DoubleSolenoid frontArmSolenoid = new DoubleSolenoid(PneumaticsModuleType.CTREPCM, Constants.armConstants.FRONT_ARM_PORT_0, Constants.armConstants.FRONT_ARM_PORT_1);
	DoubleSolenoid backArmSolenoid = new DoubleSolenoid(PneumaticsModuleType.CTREPCM, Constants.armConstants.BACK_ARM_PORT_0, Constants.armConstants.BACK_ARM_PORT_1);
	DoubleSolenoid grabSolenoid = new DoubleSolenoid(PneumaticsModuleType.CTREPCM, Constants.armConstants.GRAB_PORT_0, Constants.armConstants.GRAB_PORT_1);
	DoubleSolenoid deploySolenoid = new DoubleSolenoid(PneumaticsModuleType.CTREPCM, Constants.armConstants.DEPLOY_PORT_0, Constants.armConstants.DEPLOY_PORT_1);

	public Pneumatics()
	{
        pcmCompressor.disable();
		frontArmSolenoid.set(Value.kOff);
		backArmSolenoid.set(Value.kOff);
		grabSolenoid.set(Value.kReverse);
		deploySolenoid.set(Value.kForward);
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


	public void disableCompressor()
	{
		pcmCompressor.disable();
	}
	public void enableCompressor()
	{
		pcmCompressor.enableDigital();
	}

	public void onBackArmSolenoid()
	{
		backArmSolenoid.set(Value.kForward);
	}
	public void offBackArmSolenoid()
	{
		backArmSolenoid.set(Value.kReverse);
	}
	public void onFrontArmSolenoid()
	{
		frontArmSolenoid.set(Value.kForward);
	}
	public void offFrontArmSolenoid()
	{
		frontArmSolenoid.set(Value.kReverse);
	}
	public void onGrabSolenoid()
	{
		grabSolenoid.set(Value.kForward);
	}
	public void offGrabSolenoid()
	{
		grabSolenoid.set(Value.kReverse);
	}
	public void onDeploySolenoid()
	{
		deploySolenoid.set(Value.kForward);
	}
	public void offDeploySolenoid()
	{
		deploySolenoid.set(Value.kReverse);
	}
}
