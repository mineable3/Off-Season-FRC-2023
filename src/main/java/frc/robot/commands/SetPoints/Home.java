// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands.SetPoints;

import edu.wpi.first.wpilibj2.command.ParallelCommandGroup;
import frc.robot.commands.ArmCommands.ArmExtend;
import frc.robot.commands.ArmCommands.ArmLifter;
import frc.robot.commands.TurretCommands.TurretToSetPoint;

// NOTE:  Consider using this command inline, rather than writing a subclass.  For more
// information, see:
// https://docs.wpilib.org/en/stable/docs/software/commandbased/convenience-features.html
public class Home extends ParallelCommandGroup {
  /** Creates a new Home. */
  public Home() {
    // Add your commands in the addCommands() call, e.g.
    // addCommands(new FooCommand(), new BarCommand());
    addCommands(
      new TurretToSetPoint(0), 
      new ArmExtend(0), 
      new ArmLifter(0));
  }
}
