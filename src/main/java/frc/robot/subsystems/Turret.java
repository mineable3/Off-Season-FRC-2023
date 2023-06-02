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

public class Turret extends SubsystemBase {
  /** Creates a new Turret. */

  private CANSparkMax turretMotorLeft, turretMotorRight;

  public Turret() {

    //the motor that turn the turret
    turretMotorLeft = new CANSparkMax(Constants.turretmotorLeftID, MotorType.kBrushless);
    turretMotorRight = new CANSparkMax(Constants.turretmotorRightID, MotorType.kBrushless);

    //setting limits
    //CHANGE LIMITS WHEN THE ROBOT IS DONE, THE 10'S ARE JUST PLACE HOLDERS
    turretMotorLeft.setSoftLimit(SoftLimitDirection.kForward, 40);
    turretMotorLeft.setSoftLimit(SoftLimitDirection.kReverse, -40);
    turretMotorLeft.enableSoftLimit(SoftLimitDirection.kForward, true);
    turretMotorLeft.enableSoftLimit(SoftLimitDirection.kReverse, true);

    turretMotorRight.setSoftLimit(SoftLimitDirection.kForward, 40);
    turretMotorRight.setSoftLimit(SoftLimitDirection.kReverse, -40);
    turretMotorRight.enableSoftLimit(SoftLimitDirection.kForward, true);
    turretMotorRight.enableSoftLimit(SoftLimitDirection.kReverse, true);
  }



  //Encoder methods
  public double getTurretEncoder() {
    double averageEncoder = turretMotorLeft.getEncoder().getPosition() + turretMotorRight.getEncoder().getPosition();
    averageEncoder /= 2;
    return averageEncoder;
  }


  public void resetTurretEncoder() {
    turretMotorLeft.getEncoder().setPosition(0);
    turretMotorRight.getEncoder().setPosition(0);
  }

  public CANSparkMax getTurretMotorRight() {
    return turretMotorRight;
  }

  public CANSparkMax getTurretMotorLeft() {
    return turretMotorLeft;
  }





  //a method to move the turret
  public void setTurret(double speed) {

    turretMotorLeft.setIdleMode(IdleMode.kCoast);
    turretMotorRight.setIdleMode(IdleMode.kCoast);

    //if the turret spins one direction then coast one motor and run the other
    if(speed < 0) {
    turretMotorLeft.set(speed);
    //turretMotorRight.set(0);
    }

    //same thing as before, but the opposite motor
    else if (speed > 0) {
    turretMotorRight.set(speed);
    //turretMotorLeft.set(0);

    }
  }



  public void stopTurret() {
    turretMotorLeft.set(0);
    turretMotorRight.set(0);

    turretMotorLeft.setIdleMode(IdleMode.kBrake);
    turretMotorRight.setIdleMode(IdleMode.kBrake);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
    NetworkTableInstance.getDefault()
    .getTable("Shuffleboard")
    .getSubTable("Main")
    .getEntry("Turret encoder")
    .setNumber(Math.round(getTurretEncoder()));

  }
}
