// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands.ClawCommands;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.RobotContainer;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.button.Trigger;
public class ClawTurret extends CommandBase {
  /** Creates a new ClawTurret. */
  public ClawTurret() {
    // Use addRequirements() here to declare subsystem dependencies.
   addRequirements(RobotContainer.m_clawTurret);
  }

  private void addRequirements(ClawTurret mClawturret) {
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    RobotContainer.m_clawTurret.resetclawTurret();
  }

  private void resetclawTurret() {
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {

   double speed = RobotContainer.m_clawTurret.rightJoystick();

   RobotContainer.m_clawTurret.setclawTurret(speed);
  }

  private double rightJoystick() {
    return 0;
  }

  private void setclawTurret(double speed) {
  }

  // Called once the command ends or is interrupted.
 

  @Override
  public void end(boolean interrupted) {
    double speed = RobotContainer.m_clawTurret.rightJoystick();
    RobotContainer.m_clawTurret.setclawTurret(speed);
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
