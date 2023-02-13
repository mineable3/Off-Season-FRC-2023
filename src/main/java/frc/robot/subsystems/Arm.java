// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;
import com.revrobotics.CANSparkMax;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Arm extends SubsystemBase {
 public final CANSparkMax armMotor;

  /** Creates a new Arm. */
  
  public Arm() {
   armMotor = new CANSparkMax (Constants.armMotor,MotorType.kBrushless);
   resetarmEncoder();
   //the arm motor number limit will be a place holder for the time being
   armMotor.setSoftLimit(SoftLimitDirection.kForward, 25);
   armMotor.setSoftLimit(SoftLimitDirection.kReverse, 0);
   armMotor.enableSoftLimit(SoftLimitDirection.kForward,true);
   armMotor.enableSoftLimit(SoftLimitDirection.kReverse, true);
   
  }
public void setArm (double speed){
  armMotor.set(speed);
}
public double getArmPosition(){
  armMotor.getEncoder().setPosition();
}
public void resetArmEncoder(){
  return armMotor.getEncoder().setPositon(0);
}
public void stopArm(){
  armMotor.set(0);
}
}