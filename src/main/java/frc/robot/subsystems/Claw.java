// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMax.IdleMode;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;
import frc.robot.Constants;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Claw extends SubsystemBase {
  /** Creates a new Claw. */
  private CANSparkMax clawMotor;

  public Claw() {

    //the motor that runs the intake wheels
    clawMotor = new CANSparkMax(Constants.clawMotorID, MotorType.kBrushless);

    resetclawTurretEncoder();
  }

  //primary way to move the claw
  public void setClaw(double speed) {
    clawMotor.setIdleMode(IdleMode.kCoast);
    clawMotor.set(speed);
  }

  
  //stopping all claw movement
  public void stopClaw() {
    clawMotor.set(0);
    clawMotor.setIdleMode(IdleMode.kBrake);
  }


  //Encoder methods
  public double getclawTurretEncoder(){
    return clawMotor.getEncoder().getPosition();
  }

  public void resetclawTurretEncoder() {
    clawMotor.getEncoder().setPosition(0);
  }


  public CANSparkMax getClawMotor() {
    return clawMotor;
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
