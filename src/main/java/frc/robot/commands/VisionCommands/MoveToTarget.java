// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands.VisionCommands;

import java.util.concurrent.atomic.AtomicReference;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.RobotContainer;

public class MoveToTarget extends CommandBase {
  /** Creates a new MoveToGamePiece. */

  double verticalDegreeOffset = 0;
  double targetHeightFromFloor = 0;//needs to be same unit as limelightMountHeight
  double limelightMountHeight = 0;//the unit this is measured in will change the unit isFinished() is measured in
  double limelightMountDegree = 0;
  double distanceToTarget;

  public MoveToTarget(AtomicReference<Double> inputVerticalDegreeOffset) {

    verticalDegreeOffset = inputVerticalDegreeOffset.get();

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
    double degreesToTarget = verticalDegreeOffset + limelightMountDegree;
    double radiansToTarget = degreesToTarget * (Math.PI / 180);
    distanceToTarget = (targetHeightFromFloor - limelightMountHeight) / Math.tan(radiansToTarget);
    RobotContainer.m_DriveTrain.arcadeDrive(.5, 0);
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {}

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return (distanceToTarget < 20);
  }
}
