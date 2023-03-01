// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import com.revrobotics.CANSparkMax.IdleMode;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.RobotContainer;


public class ClawGrab extends CommandBase {
  /** Creates a new ClawGrab. */
  boolean isOpen = true;;

  public ClawGrab() {
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(RobotContainer.m_Claw);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {

  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {


    //if the claw is open the close it
    if(isOpen) {
      RobotContainer.m_Claw.moveClaw(.5);


    //if the claw is closed then open it
    } else {
      RobotContainer.m_Claw.moveClaw(-.5);
    }

    //waiting for the claw to finish opening or closing
    Timer.delay(0.3);

    //stops the claw in place
    RobotContainer.m_Claw.moveClaw(0);
    }
  

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {

    RobotContainer.m_Claw.moveClaw(0);

    RobotContainer.m_Claw.clawMotor.setIdleMode(IdleMode.kBrake);
    
    if(isOpen) {
      isOpen = false;
    }

    else {
      isOpen = true;
    }
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return true;
  }
}
