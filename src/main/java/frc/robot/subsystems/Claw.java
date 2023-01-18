// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import frc.robot.Constants;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.wpilibj2.command.WaitCommand;

public class Claw extends SubsystemBase {
  /** Creates a new Claw. */
  CANSparkMax grabbyMotor;

  public Claw() {

    grabbyMotor = new CANSparkMax(Constants.grabbymotorID, MotorType.kBrushless);

  }

  public void changeClawSate(boolean change) {
    grabbyMotor.set(.5);
    new WaitCommand(.5);
    grabbyMotor.set(0);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
