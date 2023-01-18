// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class Turret extends SubsystemBase {
  /** Creates a new Turret. */

  CANSparkMax turny;

  public Turret() {

    //the motor that turn the turret
    turny = new CANSparkMax(Constants.turretmotorID, MotorType.kBrushless);

  }

  //a method to move the turret
  public void turnTurret(double speed) {

    //checks we are inside the turrets thresholds
    if((turny.getEncoder().getPosition() < Constants.turretUpperThreshold) &&
      (turny.getEncoder().getPosition() > Constants.turretLowerThreshold)) {
      turny.set(speed);
    }

      //checks if we past the lower threshold and if so are we correcting that 
    else if((turny.getEncoder().getPosition() > Constants.turretLowerThreshold) && (speed > 0)){
      turny.set(speed);
    }

      //check if we past the upper threshold and if so are we correcting that
    else if ((turny.getEncoder().getPosition() < Constants.turretUpperThreshold) && (speed < 0)) {
      turny.set(speed);
    }

      //stops the motor because we past a threshold and we're not trying to correct it
    else {
      turny.set(0);
    }
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
