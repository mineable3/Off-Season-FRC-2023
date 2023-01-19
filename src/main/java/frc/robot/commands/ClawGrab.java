// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import edu.wpi.first.wpilibj2.command.WaitCommand;
import frc.robot.RobotContainer;

public class ClawGrab extends CommandBase {
  /** Creates a new ClawGrab. */
  boolean isOpen;
  public ClawGrab() {
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(RobotContainer.m_Claw);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    isOpen = true;
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {


    // is the B button pressed
    if (RobotContainer.m_auxController.b().getAsBoolean()){

    //if the claw is open the close it and change the isOpen variable
    if(isOpen) {
      RobotContainer.m_Claw.moveClaw(.5);
      isOpen = false;

    //if the claw is closed then open it and change the isOpen variable
    } else {
      RobotContainer.m_Claw.moveClaw(-.5);
      isOpen = true;
    }
    //waiting for the claw to finish opening or closing
    new WaitCommand(1);

    //stops the claw in place
    RobotContainer.m_Claw.moveClaw(0);
    }
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {}

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return true;
  }
}
