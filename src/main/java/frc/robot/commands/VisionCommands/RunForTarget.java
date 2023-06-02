// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands.VisionCommands;

import java.util.concurrent.atomic.AtomicReference;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.RobotContainer;

public class RunForTarget extends CommandBase {

  AtomicReference<Double> horizontalOffset;
  double forwardSpeed, xSteer, xOffset;


  /** Creates a new RunForTarget. */
  public RunForTarget(AtomicReference<Double> inTx, double inForwardSpeed) {
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(RobotContainer.m_DriveTrain);

    horizontalOffset = inTx;
    forwardSpeed = inForwardSpeed;
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {

    xOffset = horizontalOffset.get();

    if(Math.abs(horizontalOffset.get()) > 0.2) {
      xOffset *= 0.015;
      xOffset *= 0.0015;
    }
    


    RobotContainer.m_DriveTrain.arcadeDrive(forwardSpeed, xSteer * -1000 * 1.65);

  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {}

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
