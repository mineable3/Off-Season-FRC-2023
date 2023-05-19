// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands.ArmCommands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.RobotContainer;

public class ArmEncoderLift extends CommandBase {
  /** Creates a new ArmLifter. */
  double amountToLift;

  public ArmEncoderLift(double inAmountToLift) {
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(RobotContainer.m_ArmLift);

    amountToLift = inAmountToLift;
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {

    if(amountToLift > 0) { 
      RobotContainer.m_ArmLift.setArmHeight(.8);
    } else {
      RobotContainer.m_ArmLift.setArmHeight(-.8);    
    }
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    RobotContainer.m_ArmLift.stopArmHeight();
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {

    if (Math.round(RobotContainer.m_ArmLift.getArmHeightEncoder()) == amountToLift) {
      return true;
    } else {
      return false;
    }
  }
}
