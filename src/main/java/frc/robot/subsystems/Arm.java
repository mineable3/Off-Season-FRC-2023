// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMax.IdleMode;
import com.revrobotics.CANSparkMax.SoftLimitDirection;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;


import frc.robot.Constants;
import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Arm extends SubsystemBase {

 private CANSparkMax armExtendMotor, armHeightMotor1, armHeightMotor2;
 private MotorControllerGroup armHeight;

  /** Creates a new Arm. */
  
  public Arm() {
    
   armExtendMotor = new CANSparkMax(Constants.armExtendMotorID, MotorType.kBrushless);
   armHeightMotor1 = new CANSparkMax(Constants.armHeightMotor1ID, MotorType.kBrushless);
   armHeightMotor2 = new CANSparkMax(Constants.armHeightMotor2ID, MotorType.kBrushless);

   armHeight = new MotorControllerGroup(armHeightMotor1, armHeightMotor2);

   //the arm motor number limit will be a place holder for the time being
   armExtendMotor.setSoftLimit(SoftLimitDirection.kForward, 25);
   armExtendMotor.setSoftLimit(SoftLimitDirection.kReverse, 0);
   armExtendMotor.enableSoftLimit(SoftLimitDirection.kForward,true);
   armExtendMotor.enableSoftLimit(SoftLimitDirection.kReverse, true);

   armHeightMotor1.setSoftLimit(SoftLimitDirection.kForward, 25);
   armHeightMotor1.setSoftLimit(SoftLimitDirection.kReverse, 0);
   armHeightMotor1.enableSoftLimit(SoftLimitDirection.kForward,true);
   armHeightMotor1.enableSoftLimit(SoftLimitDirection.kReverse, true);

   armHeightMotor2.setSoftLimit(SoftLimitDirection.kForward, 25);
   armHeightMotor2.setSoftLimit(SoftLimitDirection.kReverse, 0);
   armHeightMotor2.enableSoftLimit(SoftLimitDirection.kForward,true);
   armHeightMotor2.enableSoftLimit(SoftLimitDirection.kReverse, true);

   resetArmHeightEncoders();
   resetArmExtendEncoders();
  }





  public void setArmHeight(double inSpeed) {
    armHeightMotor1.setIdleMode(IdleMode.kCoast);
    armHeightMotor2.setIdleMode(IdleMode.kCoast);
    armHeight.set(inSpeed);
  }

  public void setArmLength(double speed) {
    armExtendMotor.setIdleMode(IdleMode.kCoast);
    armExtendMotor.set(speed);
  }





  //Encoder reset commands
  public void resetArmExtendEncoder() {
    armExtendMotor.getEncoder().setPosition(0);
  }

  public void resetArmHeightEncoders() {
    armHeightMotor1.getEncoder().setPosition(0);
    armHeightMotor2.getEncoder().setPosition(0);
  }

  public void resetArmExtendEncoders() {
    armExtendMotor.getEncoder().setPosition(0);
  }





  public double getArmExtendEncoder() {
    return armExtendMotor.getEncoder().getPosition();
  }

  public double getArmHeightEncoder() {
    double averageEncoder = (armHeightMotor1.getEncoder().getPosition() + armHeightMotor2.getEncoder().getPosition()) / 2;
    return averageEncoder;
  }

public CANSparkMax getArmHeightMotor1() {
  return armHeightMotor1;
}

public CANSparkMax getArmHeightMotor2() {
  return armHeightMotor1;
}

public CANSparkMax getArmExtendMotor() {
  return armExtendMotor;
}





  public void stopArmHeight() {
    armHeight.set(0);
    armHeightMotor1.setIdleMode(IdleMode.kBrake);
    armHeightMotor2.setIdleMode(IdleMode.kBrake);
  }

  public void stopArmExtend() {
    armExtendMotor.set(0);
    armExtendMotor.setIdleMode(IdleMode.kBrake);
  }

}