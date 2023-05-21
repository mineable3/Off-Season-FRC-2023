// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands.IntakeCommands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.RobotContainer;

public class ManualIntake extends CommandBase {
  /** Creates a new ManualIntake. */

  boolean setRollOut;

  public ManualIntake(boolean rollOut) {
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(RobotContainer.m_Intake);

    setRollOut = rollOut;
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    if(setRollOut) {
      RobotContainer.m_Intake.setIntake(.8);
    } else {
      RobotContainer.m_Intake.setIntake(-.8);
    }
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    RobotContainer.m_Intake.stopIntake();
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
