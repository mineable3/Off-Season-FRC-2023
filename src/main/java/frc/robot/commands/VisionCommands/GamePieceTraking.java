// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands.VisionCommands;

import java.util.concurrent.atomic.AtomicReference;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.RobotContainer;

public class GamePieceTraking extends CommandBase {
  /** Creates a new GamePieceTraking. */

  AtomicReference<Double> offSet;

  public GamePieceTraking(AtomicReference<Double> inOffSet) {
    // Use addRequirements() here to declare subsystem dependencies.
    offSet = inOffSet;
    addRequirements(RobotContainer.m_Turret);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    RobotContainer.m_Turret.resetTurretEncoder();
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {

    System.out.println(offSet);


    //offSet is out of -29.8 to 29.8
    if (Math.abs(offSet.get()) >= 3){

      if(offSet.get() > 0) {
        RobotContainer.m_Turret.setTurret(.3);
      }
      else if(offSet.get() < 0) {
        RobotContainer.m_Turret.setTurret(-.3);
      }
      else {
        RobotContainer.m_Turret.setTurret(0);
      }
    }
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    RobotContainer.m_Turret.stopTurret();
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
