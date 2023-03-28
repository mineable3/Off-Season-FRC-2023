// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands.MiscellaneousCommands;

import com.revrobotics.CANSparkMax.IdleMode;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.RobotContainer;

public class FullBrakeMode extends CommandBase {
  /** Creates a new FullBrakeMode. */
  public FullBrakeMode() {
    // Use addRequirements() here to declare subsystem dependencies.
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    RobotContainer.m_ArmExtend.stopArmExtend();
    RobotContainer.m_ArmLift.stopArmHeight();
    RobotContainer.m_Claw.stopClaw();
    RobotContainer.m_Turret.stopTurret();

    RobotContainer.m_ArmExtend.getArmExtendMotor().setIdleMode(IdleMode.kBrake);
    RobotContainer.m_ArmLift.getArmHeightMotor1().setIdleMode(IdleMode.kBrake);
    RobotContainer.m_ArmLift.getArmHeightMotor2().setIdleMode(IdleMode.kBrake);
    RobotContainer.m_Claw.getClawMotor().setIdleMode(IdleMode.kBrake);
    RobotContainer.m_Turret.getTurretMotorLeft().setIdleMode(IdleMode.kBrake);
    RobotContainer.m_Turret.getTurretMotorRight().setIdleMode(IdleMode.kBrake);
    RobotContainer.m_DriveTrain.getleftmotor1().setIdleMode(IdleMode.kBrake);
    RobotContainer.m_DriveTrain.getleftmotor2().setIdleMode(IdleMode.kBrake);
    RobotContainer.m_DriveTrain.getleftmotor3().setIdleMode(IdleMode.kBrake);
    RobotContainer.m_DriveTrain.getrightmotor1().setIdleMode(IdleMode.kBrake);
    RobotContainer.m_DriveTrain.getrightmotor2().setIdleMode(IdleMode.kBrake);
    RobotContainer.m_DriveTrain.getrightmotor3().setIdleMode(IdleMode.kBrake);
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    Timer.delay(5);
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    RobotContainer.m_ArmExtend.getArmExtendMotor().setIdleMode(IdleMode.kCoast);
    RobotContainer.m_ArmLift.getArmHeightMotor1().setIdleMode(IdleMode.kCoast);
    RobotContainer.m_ArmLift.getArmHeightMotor2().setIdleMode(IdleMode.kCoast);
    RobotContainer.m_Claw.getClawMotor().setIdleMode(IdleMode.kCoast);
    RobotContainer.m_Turret.getTurretMotorLeft().setIdleMode(IdleMode.kCoast);
    RobotContainer.m_Turret.getTurretMotorRight().setIdleMode(IdleMode.kCoast);
    RobotContainer.m_DriveTrain.getleftmotor1().setIdleMode(IdleMode.kCoast);
    RobotContainer.m_DriveTrain.getleftmotor2().setIdleMode(IdleMode.kCoast);
    RobotContainer.m_DriveTrain.getleftmotor3().setIdleMode(IdleMode.kCoast);
    RobotContainer.m_DriveTrain.getrightmotor1().setIdleMode(IdleMode.kCoast);
    RobotContainer.m_DriveTrain.getrightmotor2().setIdleMode(IdleMode.kCoast);
    RobotContainer.m_DriveTrain.getrightmotor3().setIdleMode(IdleMode.kCoast);
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return true;
  }
}
