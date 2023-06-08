// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands.DriveTrainCommands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.RobotContainer;

public class GTADrive extends CommandBase {
  /** Creates a new GTADrive. */

  double backSpeed, forwardSpeed, netSpeed, curve;
  boolean turnInPlace;

  public GTADrive() {
    // Use addRequirements() here to declare subsystem dependencies.
  
    addRequirements(RobotContainer.m_DriveTrain);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    RobotContainer.m_DriveTrain.getleftmotor1().setOpenLoopRampRate(1);
    RobotContainer.m_DriveTrain.getleftmotor2().setOpenLoopRampRate(1);
    RobotContainer.m_DriveTrain.getleftmotor3().setOpenLoopRampRate(1);
    RobotContainer.m_DriveTrain.getrightmotor1().setOpenLoopRampRate(1);
    RobotContainer.m_DriveTrain.getrightmotor2().setOpenLoopRampRate(1);
    RobotContainer.m_DriveTrain.getrightmotor3().setOpenLoopRampRate(1);
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {


    backSpeed = RobotContainer.m_ButtonBind.driverRightTrigger;
    forwardSpeed = RobotContainer.m_ButtonBind.driverLeftTrigger;
    curve = RobotContainer.m_ButtonBind.leftAxisX;
    turnInPlace = RobotContainer.m_ButtonBind.getDriverRightBumper();

    netSpeed = backSpeed + forwardSpeed;


    RobotContainer.m_DriveTrain.gtaDrive(netSpeed, curve, turnInPlace);
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    RobotContainer.m_DriveTrain.arcadeDrive(0, 0);
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
