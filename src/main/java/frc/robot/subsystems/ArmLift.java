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

public class ArmLift extends SubsystemBase {

 private CANSparkMax armHeightMotor1, armHeightMotor2;
 private MotorControllerGroup armHeight;

  /** Creates a new Arm. */
  
  public ArmLift() {
    
   armHeightMotor1 = new CANSparkMax(Constants.armHeightMotor1ID, MotorType.kBrushless);
   armHeightMotor2 = new CANSparkMax(Constants.armHeightMotor2ID, MotorType.kBrushless);

   armHeight = new MotorControllerGroup(armHeightMotor1, armHeightMotor2);

   //the arm motor number limit will be a place holder for the time being
   armHeightMotor1.setSoftLimit(SoftLimitDirection.kForward, 25);
   armHeightMotor1.setSoftLimit(SoftLimitDirection.kReverse, 0);
   armHeightMotor1.enableSoftLimit(SoftLimitDirection.kForward,true);
   armHeightMotor1.enableSoftLimit(SoftLimitDirection.kReverse, true);

   armHeightMotor2.setSoftLimit(SoftLimitDirection.kForward, 25);
   armHeightMotor2.setSoftLimit(SoftLimitDirection.kReverse, 0);
   armHeightMotor2.enableSoftLimit(SoftLimitDirection.kForward,true);
   armHeightMotor2.enableSoftLimit(SoftLimitDirection.kReverse, true);

   resetArmHeightEncoders();
  }





  public void setArmHeight(double inSpeed) {
    armHeightMotor1.setIdleMode(IdleMode.kCoast);
    armHeightMotor2.setIdleMode(IdleMode.kCoast);
    armHeight.set(inSpeed);
  }






  //Encoder reset commands

  public void resetArmHeightEncoders() {
    armHeightMotor1.getEncoder().setPosition(0);
    armHeightMotor2.getEncoder().setPosition(0);
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





  public void stopArmHeight() {
    armHeight.set(0);
    armHeightMotor1.setIdleMode(IdleMode.kBrake);
    armHeightMotor2.setIdleMode(IdleMode.kBrake);
  }


}