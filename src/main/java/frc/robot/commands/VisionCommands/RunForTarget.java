// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands.VisionCommands;

import java.util.concurrent.atomic.AtomicReference;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;
import frc.robot.RobotContainer;

public class RunForTarget extends CommandBase {
  /** Creates a new RunForTag. */

  private double steerScale = Constants.visionConstant;
  private double adjustSteer = 0;
  private double speedSet, xSteer; 
  private AtomicReference<Double> xSteerSup;


  public RunForTarget(double speed, AtomicReference <Double> xSteering) {

    addRequirements(RobotContainer.m_DriveTrain);
    speedSet = speed;
    xSteerSup = xSteering;
    xSteer = xSteerSup.get();
    }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {

    xSteer = xSteerSup.get();
    
    if(xSteer > 0.2){
      adjustSteer = xSteer * 0.015;
      adjustSteer = adjustSteer * steerScale;
    }else if(xSteer < -0.2){
      adjustSteer = xSteer * 0.015;
      adjustSteer = adjustSteer * steerScale;
    }else{
      adjustSteer = 0;
    }
    RobotContainer.m_DriveTrain.arcadeDrive(speedSet, adjustSteer * -1000 * 1.65);
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {}

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    // if(areaOfTargetSup >= 1.35){
    //   return true;
    // }else{
    //   return false;
    // }
    return false;
  }
}
