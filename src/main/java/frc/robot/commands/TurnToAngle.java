// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.math.controller.PIDController;
import edu.wpi.first.wpilibj2.command.PIDCommand;
import frc.robot.RobotContainer;

// NOTE:  Consider using this command inline, rather than writing a subclass.  For more
// information, see:
// https://docs.wpilib.org/en/stable/docs/software/commandbased/convenience-features.html
public class TurnToAngle extends PIDCommand {
  /** Creates a new TurnToAngle. */
  public TurnToAngle(double targetDegree) {
    super(
        // The controller that the command will use
        new PIDController(.2, 0, 0),
        // This should return the measurement
        () -> RobotContainer.m_DriveTrain.getYaw(),
        // This should return the setpoint (can also be a constant)
        targetDegree,
        // This uses the output
        output -> {RobotContainer.m_DriveTrain.arcadeDrive(0, (output * .5));
          // Use the output here
        });
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(RobotContainer.m_DriveTrain);
    // Configure additional PID options by calling `getController` here.
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return getController().atSetpoint();
  }
}
