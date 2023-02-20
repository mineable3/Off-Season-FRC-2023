// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands.DriveTrainCommands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.RobotContainer;


public class MoveForDistance extends CommandBase {
  /** Creates a new MoveForDistance. */

  double distance;

  public MoveForDistance(double distanceInFeet) {
    // Use addRequirements() here to declare subsystem dependencies.
    distance = distanceInFeet;
    addRequirements(RobotContainer.m_DriveTrain);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    RobotContainer.m_DriveTrain.resetEncoders();
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    System.out.println("" + RobotContainer.m_DriveTrain.getDriveEncoders());
    RobotContainer.m_DriveTrain.arcadeDrive(.5, 0);
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    RobotContainer.m_DriveTrain.arcadeDrive(0, 0);
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return (RobotContainer.m_DriveTrain.getDriveEncoders() >= distance);
  }
}
