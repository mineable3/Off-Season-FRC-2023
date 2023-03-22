// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands.ClawCommands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.RobotContainer;


public class ClawToSetPoint extends CommandBase {
  /** Creates a new ClawGrab. */
  double amountToClose;

  public ClawToSetPoint(double inAmountToClose) {
  
    amountToClose = inAmountToClose;

    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(RobotContainer.m_Claw);
  }


  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}





  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {

    if (amountToClose > 0) {
      RobotContainer.m_Claw.moveClaw(.8);
    } else {
      RobotContainer.m_Claw.moveClaw(-.8);   
    }
  }
  

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    RobotContainer.m_Claw.stopClaw();
  }




  // Returns true when the command should end.
  @Override
  public boolean isFinished() {

    if (Math.round(RobotContainer.m_Claw.getclawTurretEncoder()) == amountToClose) {
      return true;
    } else {
      return false;
    }
  } 
}
