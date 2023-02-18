// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;

import frc.robot.RobotContainer;

public class ArmMovement extends CommandBase {

  /** Creates a new ArmMovement. */
  public ArmMovement() {
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(RobotContainer.m_arm);

  }
 
  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
  RobotContainer.m_arm.resetArmEncoder();
  
  }
 
  


       
  // Called every time the scheduler runs while the command is scheduled.
  @Override

  
  
  public void execute() {

double speed = RobotContainer.m_driverController.getRightX();

RobotContainer.m_arm.setArm(speed);



  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    RobotContainer.m_arm.setArm(0);
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
