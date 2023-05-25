// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands.Autonomous;

import edu.wpi.first.wpilibj2.command.ParallelCommandGroup;
import edu.wpi.first.wpilibj2.command.ParallelDeadlineGroup;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.commands.ArmCommands.ArmEncoderExtend;
import frc.robot.commands.ArmCommands.ArmEncoderLift;
import frc.robot.commands.DriveTrainCommands.MoveForDistance;
import frc.robot.commands.IntakeCommands.ManualIntake;
import frc.robot.commands.SetPoints.GroundPickup;
import frc.robot.commands.SetPoints.Home;
import frc.robot.commands.TurretCommands.TurretToSetPoint;

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
      new ParallelDeadlineGroup(
        new MoveForDistance(7),//find values
        new ManualIntake(false)),
      
      new ParallelCommandGroup(
        new MoveForDistance(-7),//find values

        new TurretToSetPoint(180),//find values
        new ArmEncoderLift(5),//find values
        new ArmEncoderExtend(5)//find values
      ),

      new ManualIntake(true).withTimeout(.3),//dropping the gamepiece
      new Home());//for the start of teleop
  }
}
