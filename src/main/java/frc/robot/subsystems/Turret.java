// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMax.SoftLimitDirection;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class Turret extends SubsystemBase {
  /** Creates a new Turret. */

  CANSparkMax turretMotor;

  public Turret() {

    //the motor that turn the turret
    turretMotor = new CANSparkMax(Constants.turretmotorID, MotorType.kBrushless);

    //setting limits
    //CHANGE LIMITS WHEN THE ROBOT IS DONE, THE 10'S ARE JUST PLACE HOLDERS
    turretMotor.setSoftLimit(SoftLimitDirection.kForward, 10);
    turretMotor.setSoftLimit(SoftLimitDirection.kReverse, -10);
    turretMotor.enableSoftLimit(SoftLimitDirection.kForward, true);
    turretMotor.enableSoftLimit(SoftLimitDirection.kReverse, true);
  }



  //Encoder methods
  public double getTurretEncoder() {
    return turretMotor.getEncoder().getPosition();
  }
  public void resetTurretEncoder() {
    turretMotor.getEncoder().getPosition();
  }

  //a method to move the turret
  public void turnTurret(double speed) {
    turretMotor.set(speed);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
