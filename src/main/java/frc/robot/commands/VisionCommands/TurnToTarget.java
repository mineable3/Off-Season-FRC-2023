// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands.VisionCommands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.RobotContainer;

public class TurnToTarget extends CommandBase {

  private double speed;

  /** Creates a new TurnToTarget. 
   * @param setSpeed the speed should always be positive and dictates how fast the robot will turn
   * 
  */
  public TurnToTarget(double setSpeed) {

    speed = setSpeed;

    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(RobotContainer.m_DriveTrain);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {

    if(RobotContainer.tx.get() < -3) {
      RobotContainer.m_DriveTrain.arcadeDrive(0, speed);
    }

    else if(RobotContainer.tx.get() > 3) {
      RobotContainer.m_DriveTrain.arcadeDrive(0, -speed);
    }

  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {}

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {

    if(Math.abs(RobotContainer.tx.get()) <= 3) {
      return true;
    } else {
      return false;
    }
  }
}