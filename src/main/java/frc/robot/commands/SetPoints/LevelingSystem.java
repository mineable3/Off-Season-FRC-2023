// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands.SetPoints;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.commands.ArmCommands.ArmEncoderExtend;
import frc.robot.commands.ArmCommands.ArmEncoderLift;
import frc.robot.commands.IntakeCommands.IntakeToSetPoint;
import frc.robot.commands.DriveTrainCommands.MoveForDistance;
import frc.robot.commands.TurretCommands.TurretToSetPoint;

// NOTE:  Consider using this command inline, rather than writing a subclass.  For more
// information, see:
// https://docs.wpilib.org/en/stable/docs/software/commandbased/convenience-features.html
public class LevelingSystem extends SequentialCommandGroup {
  /** Creates a new LevelingSystem. */
  public LevelingSystem() {
    // Add your commands in the addCommands() call, e.g.
    // addCommands(new FooCommand(), new BarCommand());

    addCommands(
     new ArmEncoderExtend(0),
     new IntakeToSetPoint(0),
     new TurretToSetPoint(0),
     new ArmEncoderLift(0),
     new MoveForDistance(13),
     new MoveForDistance(-13));

  }
}