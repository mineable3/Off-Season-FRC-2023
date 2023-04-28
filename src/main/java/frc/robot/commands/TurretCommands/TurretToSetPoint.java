// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands.TurretCommands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.RobotContainer;

public class TurretToSetPoint extends CommandBase {
  /** Creates a new TurretToSetPoint. */

  double amountToTurnTo;

  public TurretToSetPoint(double inAmountToTurn) {
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(RobotContainer.m_Turret);

    amountToTurnTo = inAmountToTurn;
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    
    if(amountToTurnTo > 0) {
      RobotContainer.m_Turret.setTurret(.5);
    } else {
      RobotContainer.m_Turret.setTurret(-.5);
    }
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {}

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {

    if (Math.round(RobotContainer.m_Turret.getTurretEncoder()) == amountToTurnTo) {
      return true;
    } else {
      return false;
    }
  }
}
