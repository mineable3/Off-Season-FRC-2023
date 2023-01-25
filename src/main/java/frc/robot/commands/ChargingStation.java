// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import com.revrobotics.CANSparkMax.IdleMode;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.RobotContainer;

public class ChargingStation extends CommandBase {
  /** Creates a new ChargingStation. */
  public ChargingStation() {
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(RobotContainer.m_DriveTrain);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    RobotContainer.m_DriveTrain.resetPitch();
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {

    System.out.println("running ChargingStation command");

    while (RobotContainer.m_DriveTrain.getPitch() > 5){
      System.out.println("inside while loop");
        RobotContainer.m_DriveTrain.arcadeDrive(.1, 0);
       
    }
      while ((RobotContainer.m_DriveTrain.getPitch() < -5)) {
        System.out.println("inside other while loop");
        RobotContainer.m_DriveTrain.arcadeDrive(-.1, 0);
      }
  }
  

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    RobotContainer.m_DriveTrain.arcadeDrive(0, 0);
    RobotContainer.m_DriveTrain.leftmotor1.setIdleMode(IdleMode.kBrake);
    RobotContainer.m_DriveTrain.leftmotor2.setIdleMode(IdleMode.kBrake);
    RobotContainer.m_DriveTrain.rightmotor1.setIdleMode(IdleMode.kBrake);
    RobotContainer.m_DriveTrain.rightmotor2.setIdleMode(IdleMode.kBrake);
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return true;
  }
}
