// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands.ArmCommands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.RobotContainer;

public class ArmExtend extends CommandBase {

  double amountToExtend;

  /** Creates a new ArmExtend. */
  public ArmExtend(double inAmountToExtend) {
    amountToExtend = inAmountToExtend;

    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(RobotContainer.m_Arm);

  }
 
  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}
 
  
  // Called every time the scheduler runs while the command is scheduled.
  @Override  
  public void execute() {

    if(amountToExtend > 0) {
      RobotContainer.m_Arm.setArmLength(.5);
    } else {
      RobotContainer.m_Arm.setArmLength(-.5);
    }
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    RobotContainer.m_Arm.stopArmExtend();
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {

    if ((Math.round(RobotContainer.m_Arm.getArmExtendEncoder()) == amountToExtend)) {
      return true;
    } else {
      return false;
    }
  }
}
