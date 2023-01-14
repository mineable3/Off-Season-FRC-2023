// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;
import frc.robot.RobotContainer;
import frc.robot.Constants.OperatorConstants;

public class ArcadeDrive extends CommandBase {
  /** Creates a new ArcadeDrive. */
  public ArcadeDrive() {
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(RobotContainer.m_DriveTrain);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    RobotContainer.m_DriveTrain.resetEncoders();
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {

    double speed = RobotContainer.m_driverController.getRawAxis(OperatorConstants.driveSpeed);
    double rotation = RobotContainer.m_driverController.getRawAxis(OperatorConstants.driveRotate);

    speed *= Constants.speedMultiplier;
    rotation *= Constants.speedMultiplier;

    RobotContainer.m_DriveTrain.arcadeDrive(speed, rotation);

    
    //Just testing if the method works without making an auto command
    if (RobotContainer.m_driverController.a().getAsBoolean()) {
      System.out.println(RobotContainer.m_DriveTrain.getDriveEncoder());
    }
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
