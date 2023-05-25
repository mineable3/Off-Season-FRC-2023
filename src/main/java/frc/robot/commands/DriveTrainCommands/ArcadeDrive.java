// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands.DriveTrainCommands;

import edu.wpi.first.networktables.NetworkTableInstance;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;
import frc.robot.RobotContainer;

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
    System.out.println("hello world");
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {

    double speed = RobotContainer.m_ButtonBind.getDriverLeftY();
    double rotation = RobotContainer.m_ButtonBind.getDriverRightX();

    speed *= Constants.driveSpeedMultiplier;
    rotation *= Constants.driveSpeedMultiplier;

    RobotContainer.m_DriveTrain.arcadeDrive(speed, rotation);
    
    //System.out.println("Turret encoder:  " + RobotContainer.m_Turret.getTurretEncoder());
    //System.out.println("Arm Enconder: " + RobotContainer.m_ArmExtend.getArmExtendEncoder());
    //System.out.println("Arm Height: " + RobotContainer.m_ArmLift.getArmHeightEncoder());
    
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
