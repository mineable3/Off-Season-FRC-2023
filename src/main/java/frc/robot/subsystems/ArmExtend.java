// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMax.IdleMode;
import com.revrobotics.CANSparkMax.SoftLimitDirection;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.networktables.NetworkTableInstance;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class ArmExtend extends SubsystemBase {
  /** Creates a new ArmExtend. */

  public CANSparkMax armExtendMotor;

  public ArmExtend() {
    armExtendMotor = new CANSparkMax(Constants.armExtendMotorID, MotorType.kBrushless);

    armExtendMotor.setSoftLimit(SoftLimitDirection.kForward, 100);
    armExtendMotor.setSoftLimit(SoftLimitDirection.kReverse, 0);
    armExtendMotor.enableSoftLimit(SoftLimitDirection.kForward,true);
    armExtendMotor.enableSoftLimit(SoftLimitDirection.kReverse, true);
 
  }

  public void setArmLength(double speed) {
    armExtendMotor.setIdleMode(IdleMode.kCoast);
    armExtendMotor.set(speed);
  }

  public void stopArmExtend() {
    armExtendMotor.setIdleMode(IdleMode.kBrake);
    armExtendMotor.set(0);
  }

  public CANSparkMax getArmExtendMotor() {
    return armExtendMotor;
  }

  public double getArmExtendEncoder() {
    return armExtendMotor.getEncoder().getPosition();
  }

  public void setArmExtendEncoder(double newPos) {
    armExtendMotor.getEncoder().setPosition(newPos);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run

    NetworkTableInstance.getDefault()
    .getTable("Shuffleboard")
    .getSubTable("Main")
    .getEntry("Arm Extend encoder")
    .setNumber(Math.round(getArmExtendEncoder()));

  }
}
