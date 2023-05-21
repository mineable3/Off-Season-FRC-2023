// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMax.IdleMode;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;
import frc.robot.Constants;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Intake extends SubsystemBase {
  /** Creates a new Intake. */
  private CANSparkMax intakeMotor;

  public Intake() {

    //the motor that runs the intake wheels
    intakeMotor = new CANSparkMax(Constants.intakeMotorID, MotorType.kBrushless);
  }

  //primary way to move the intake
  public void setIntake(double speed) {
    intakeMotor.setIdleMode(IdleMode.kCoast);
    intakeMotor.set(speed);
  }

  
  //stopping all intake movement
  public void stopIntake() {
    intakeMotor.set(0);
    intakeMotor.setIdleMode(IdleMode.kBrake);
  }

  public double getIntakeEncoder() {
    return intakeMotor.getEncoder().getPosition();
  }

  public void setIntakeEncoder(double setPosition) {
    intakeMotor.getEncoder().setPosition(setPosition);
  }


  public CANSparkMax getIntakeMotor() {
    return intakeMotor;
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
