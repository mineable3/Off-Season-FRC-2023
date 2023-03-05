// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands.ClawCommands;

import com.revrobotics.CANSparkMax.IdleMode;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.RobotContainer;

public class ClawOpen extends CommandBase {
  /** Creates a new ClawOpen. */
  public ClawOpen() {
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(RobotContainer.m_Claw);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    RobotContainer.m_Claw.moveClaw(-.8);
  }



  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {

    RobotContainer.m_Claw.stopClaw();
    RobotContainer.m_Claw.clawMotor.setIdleMode(IdleMode.kBrake);
    RobotContainer.m_Claw.resetEncoder();
  }




  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    //replace true with the commented out code when OI is done
    return true/*OperatingInterface.clawLimitSwitch.getAsBoolean == false*/;
  }
}
