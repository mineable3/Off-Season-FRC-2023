// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands.ClawCommands;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.RobotContainer;

public class SpinForTime extends CommandBase {
  /** Creates a new SpinForTime. */

  double time;
  double startTime;
  boolean grabDirection;
  Timer timey = new Timer();


  public SpinForTime(double inTime, boolean directionIn) {

    time = inTime;
    grabDirection = directionIn;
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(RobotContainer.m_Claw);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    startTime = Timer.getFPGATimestamp();
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    if(grabDirection) {
      RobotContainer.m_Claw.setClaw(.8);
    } else {
      RobotContainer.m_Claw.setClaw(-.8);
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
    return ((startTime + time) <= (Timer.getFPGATimestamp()));
  }
}
