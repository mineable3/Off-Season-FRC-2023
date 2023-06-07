// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands.VisionCommands;

import edu.wpi.first.networktables.NetworkTable;
import edu.wpi.first.networktables.NetworkTableInstance;
import edu.wpi.first.wpilibj2.command.CommandBase;

public class PipelineSwitch extends CommandBase {
  /** Creates a new PipelineSwitch. */
  private NetworkTable aimmingNT, gamePieceNT;
  private double cargoPiplineNum, aimPipelineNum;
  public PipelineSwitch(double cargoPipeline, double aimPipeline) {
    // Use addRequirements() here to declare subsystem dependencies.
    aimmingNT = NetworkTableInstance.getDefault().getTable("limelight-aimming");
    cargoPiplineNum = cargoPipeline;
    aimPipelineNum = aimPipeline;
    gamePieceNT = NetworkTableInstance.getDefault().getTable("limelight-cargo");
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    NetworkTableInstance.getDefault()
    .getTable("Shuffleboard")
    .getSubTable("Main")
    .getEntry("Pipeline Default?")
    .setBoolean(false);
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
      aimmingNT.getEntry("pipeline").setNumber(cargoPiplineNum);
      gamePieceNT.getEntry("pipeline").setNumber(aimPipelineNum);

    
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    aimmingNT.getEntry("pipeline").setNumber(0);
    gamePieceNT.getEntry("pipeline").setNumber(0);
    NetworkTableInstance.getDefault()
    .getTable("Shuffleboard")
    .getSubTable("Main")
    .getEntry("Pipeline Default?")
    .setBoolean(true);
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}