// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands.ClawCommands;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.RobotContainer;
public class ClawTurretMovement extends CommandBase {
  /** Creates a new ClawTurret. */
  public ClawTurretMovement() {
    // Use addRequirements() here to declar subsystem dependencies.
  addRequirements(RobotContainer.m_ClawTurret);
  }

  

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    RobotContainer.m_ClawTurret.resetClawTurretEncoder();
  }

  
  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {

   //double speed = RobotContainer.rightJoystick();

   //RobotContainer.m_ClawTurret.setclawTurret(speed);
  }

  private double rightJoystick() {
    return 0;
  }

  
  // Called once the command ends or is interrupted.
 

  @Override
  public void end(boolean interrupted) {
    double speed = RobotContainer.m_clawTurretMovement.rightJoystick();
    RobotContainer.m_ClawTurret.setclawTurret(speed);
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
