// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands.Autonomous;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.commands.DriveTrainCommands.MoveForDistance;
import frc.robot.commands.IntakeCommands.ManualIntake;
import frc.robot.commands.SetPoints.DropHigh;
import frc.robot.commands.SetPoints.Home;

// NOTE:  Consider using this command inline, rather than writing a subclass.  For more
// information, see:
// https://docs.wpilib.org/en/stable/docs/software/commandbased/convenience-features.html
public class TopCubeScore extends SequentialCommandGroup {
  /** Creates a new TopCubeScore. */
  public TopCubeScore() {
    // Add your commands in the addCommands() call, e.g.
    // addCommands(new FooCommand(), new BarCommand());
    
    addCommands(
      new DropHigh(),
      new ManualIntake(true).withTimeout(.5),//spit the gamepiece out
      new Home(),//return to the original position for the start of teleop
      new MoveForDistance(5));
  }
}
