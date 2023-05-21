// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands.Autonomous;

import edu.wpi.first.wpilibj2.command.ParallelCommandGroup;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.commands.DriveTrainCommands.MoveForDistance;
import frc.robot.commands.IntakeCommands.ManualIntake;
import frc.robot.commands.SetPoints.DropMid;
import frc.robot.commands.SetPoints.GroundPickup;
import frc.robot.commands.SetPoints.Home;

// NOTE:  Consider using this command inline, rather than writing a subclass.  For more
// information, see:
// https://docs.wpilib.org/en/stable/docs/software/commandbased/convenience-features.html
public class TwoCubeScoring extends SequentialCommandGroup {
  /** Creates a new TwoCubeScoring. */
  public TwoCubeScoring() {
    // Add your commands in the addCommands() call, e.g.
    // addCommands(new FooCommand(), new BarCommand());
    addCommands(

      new TopCubeScore(),//one cube scored high
      new GroundPickup(),//position to get another gamepiece

      //running into a cube with the intake running
      new ParallelCommandGroup(
        new ManualIntake(false),
        new MoveForDistance(7)).withTimeout(2),
      
      new MoveForDistance(-7),
      new DropMid(),//only middle because we already have a gamepiece in the top shelf
      new ManualIntake(true).withTimeout(.3),//dropping the gamepiece
      new Home());//for the start of teleop
  }
}
