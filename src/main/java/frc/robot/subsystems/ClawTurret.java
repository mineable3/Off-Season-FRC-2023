// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;
import com.revrobotics.CANSparkMax.IdleMode;
import com.revrobotics.CANSparkMax.SoftLimitDirection;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class ClawTurret extends SubsystemBase {
  /** Creates a new ClawTurrent. */

  private CANSparkMax clawTurretMotor;
  
  public ClawTurret() {
    clawTurretMotor = new CANSparkMax(Constants.clawTurretID, MotorType.kBrushless);

    clawTurretMotor.setSoftLimit(SoftLimitDirection.kForward, 26);
    clawTurretMotor.setSoftLimit(SoftLimitDirection.kReverse, 24);
    clawTurretMotor.enableSoftLimit(SoftLimitDirection.kForward, true);
    clawTurretMotor.enableSoftLimit(SoftLimitDirection.kReverse, true);

    
  }

  //getting claw turret position
  public double getClawTurretEncoder(){
    return clawTurretMotor.getEncoder().getPosition();
  }

  //resetting position
  public void resetClawTurretEncoder(){
    clawTurretMotor.getEncoder().setPosition(0);
  }

  public void setclawTurret(double speed){
    clawTurretMotor.setIdleMode(IdleMode.kCoast);
    clawTurretMotor.set(speed);
  }

  public void stopClawTurret() {
    clawTurretMotor.set(0);
    clawTurretMotor.setIdleMode(IdleMode.kBrake);
  }


  public CANSparkMax getClawTurretMotor() {
    return clawTurretMotor;
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
