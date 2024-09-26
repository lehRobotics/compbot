// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.CommandScheduler;
import frc.robot.commands.Arm;

/**
 * The VM is configured to automatically run this class, and to call the functions corresponding to
 * each mode, as described in the TimedRobot documentation. If you change the name of this class or
 * the package after creating this project, you must also update the manifest file in the resource
 * directory.
 */
public class Robot extends TimedRobot {


  /**
   * This function is run when the robot is first started up and should be used for any
   * initialization code.
   */
  @Override
  public void robotInit() {
    // We need to invert one side of the drivetrain so that positive voltages
    // result in both sides moving forward. Depending on how your robot's
    // gearbox is constructed, you might have to invert the left side instead.

  }

  Timer autoTimer = new Timer();
  /** This function is run once each time the robot enters autonomous mode. */
  @Override
  public void autonomousInit() {
    autoTimer.reset();
    autoTimer.start();
    RobotContainer.pneumatics.enableCompressor();
    
		RobotContainer.pneumatics.onDeploySolenoid();
    RobotContainer.pneumatics.onGrabSolenoid();

  }

  /** This function is called periodically during autonomous. */
  @Override
  public void autonomousPeriodic() {

    if (Constants.driveConstants.AUTOCONFIG == 1) 
    {
    //1 is drive for 4 seconds (center) (speed of __)
      if (!autoTimer.hasElapsed(4))
      {
        RobotContainer.driveTrain.BLMset(-Constants.driveConstants.AUTOSPEED);
        RobotContainer.driveTrain.BRMset(-Constants.driveConstants.AUTOSPEED);
        RobotContainer.driveTrain.FLMset(-Constants.driveConstants.AUTOSPEED);
        RobotContainer.driveTrain.FRMset(-Constants.driveConstants.AUTOSPEED);
      }
      else 
      {
        RobotContainer.driveTrain.BLMset(0);
        RobotContainer.driveTrain.BRMset(0);
        RobotContainer.driveTrain.FLMset(0);
        RobotContainer.driveTrain.FRMset(0);
      }
  }

  if (Constants.driveConstants.AUTOCONFIG == 2) 
    {
    //2 is drive for 3 turn right for 3 move for 3 turn left for 3 (if you are on left side) (speed of __)
      if (!autoTimer.hasElapsed(3))
      {
        RobotContainer.driveTrain.BLMset(Constants.driveConstants.AUTOSPEED);
        RobotContainer.driveTrain.BRMset(Constants.driveConstants.AUTOSPEED);
        RobotContainer.driveTrain.FLMset(Constants.driveConstants.AUTOSPEED);
        RobotContainer.driveTrain.FRMset(Constants.driveConstants.AUTOSPEED);
      }
      else if (!autoTimer.hasElapsed(6))
      {
        RobotContainer.driveTrain.BLMset(Constants.driveConstants.AUTOSPEED);
        RobotContainer.driveTrain.BRMset(0);
        RobotContainer.driveTrain.FLMset(Constants.driveConstants.AUTOSPEED);
        RobotContainer.driveTrain.FRMset(0);
      }
      else if (!autoTimer.hasElapsed(9))
      {
        RobotContainer.driveTrain.BLMset(Constants.driveConstants.AUTOSPEED);
        RobotContainer.driveTrain.BRMset(Constants.driveConstants.AUTOSPEED);
        RobotContainer.driveTrain.FLMset(Constants.driveConstants.AUTOSPEED);
        RobotContainer.driveTrain.FRMset(Constants.driveConstants.AUTOSPEED);
      }
      else if (!autoTimer.hasElapsed(12))
      {
        RobotContainer.driveTrain.BRMset(Constants.driveConstants.AUTOSPEED);
        RobotContainer.driveTrain.BLMset(0);
        RobotContainer.driveTrain.FRMset(Constants.driveConstants.AUTOSPEED);
        RobotContainer.driveTrain.FLMset(0);
      }
      else if (!autoTimer.hasElapsed(15))
      {
        RobotContainer.driveTrain.BLMset(Constants.driveConstants.AUTOSPEED);
        RobotContainer.driveTrain.BRMset(Constants.driveConstants.AUTOSPEED);
        RobotContainer.driveTrain.FLMset(Constants.driveConstants.AUTOSPEED);
        RobotContainer.driveTrain.FRMset(Constants.driveConstants.AUTOSPEED);
      }
      else 
      {
        RobotContainer.driveTrain.BLMset(0);
        RobotContainer.driveTrain.BRMset(0);
        RobotContainer.driveTrain.FLMset(0);
        RobotContainer.driveTrain.FRMset(0);
      }
  }
  if (Constants.driveConstants.AUTOCONFIG == 3) 
  {
  //3 is drive for 3 seconds (center) (speed of __)
    if (!autoTimer.hasElapsed(3))
    {
      RobotContainer.driveTrain.BLMset(Constants.driveConstants.AUTOSPEED);
      RobotContainer.driveTrain.BRMset(Constants.driveConstants.AUTOSPEED);
      RobotContainer.driveTrain.FLMset(Constants.driveConstants.AUTOSPEED);
      RobotContainer.driveTrain.FRMset(Constants.driveConstants.AUTOSPEED);
    }
    else 
    {
      RobotContainer.driveTrain.BLMset(0);
      RobotContainer.driveTrain.BRMset(0);
      RobotContainer.driveTrain.FLMset(0);
      RobotContainer.driveTrain.FRMset(0);
    }
  } else if (Constants.driveConstants.AUTOCONFIG == 4) 
    {
      // score cone in low and back out of community
      if (!autoTimer.hasElapsed(6))
      {
        // RobotContainer.pneumatics.onDeploySolenoid();
        // RobotContainer.pneumatics.offBackArmSolenoid();
      // }
      // else if (!autoTimer.hasElapsed((6)))
      // {
        RobotContainer.pneumatics.offDeploySolenoid();
      }
      else if (!autoTimer.hasElapsed((9.25)))
      {
        // RobotContainer.driveTrain.BLMset(0);
        // RobotContainer.driveTrain.BRMset(0);
        RobotContainer.driveTrain.BLMset(-Constants.armConstants.FRONT_MOTOR_SPEED);
        RobotContainer.driveTrain.BRMset(-Constants.armConstants.FRONT_MOTOR_SPEED);
      }
      else
      {
        RobotContainer.driveTrain.BLMset(-0);
        RobotContainer.driveTrain.BRMset(-0);
        RobotContainer.driveTrain.FLMset(-0);
        RobotContainer.driveTrain.FRMset(-0);
        RobotContainer.armDrive.setFrontMotor(0);
        RobotContainer.armDrive.setBackMotor(0);
        RobotContainer.pneumatics.offGrabSolenoid();
			 RobotContainer.armDrive.grabTriggerState = false;
			 RobotContainer.armDrive.grabDebounceCooldown = 0;
      }
    }
      else if (Constants.driveConstants.AUTOCONFIG == 5) 
    {
      // drop cone in low goal, don't move
      if (!autoTimer.hasElapsed(4))
      {
        RobotContainer.pneumatics.onDeploySolenoid();
      }
      else if (!autoTimer.hasElapsed((6)))
      {
        RobotContainer.pneumatics.offDeploySolenoid();
      }
      else
      {
        RobotContainer.driveTrain.BLMset(0);
        RobotContainer.driveTrain.BRMset(0);
        RobotContainer.driveTrain.FLMset(0);
        RobotContainer.driveTrain.FRMset(0);
        RobotContainer.armDrive.setFrontMotor(0);
        RobotContainer.armDrive.setBackMotor(0);
      }
}
  
}

  /** This function is called once each time the robot enters teleoperated mode. */
  @Override
  public void teleopInit()
  {
    RobotContainer.airTest.schedule();
    RobotContainer.tankDrive.schedule();

    

  }

  /** This function is called periodically during teleoperated mode. */
  @Override
  public void teleopPeriodic() {
    CommandScheduler.getInstance().run();
  }

  /** This function is called once each time the robot enters test mode. */
  @Override
  public void testInit() {}

  /** This function is called periodically during test mode. */
  @Override
  public void testPeriodic() {}
}
