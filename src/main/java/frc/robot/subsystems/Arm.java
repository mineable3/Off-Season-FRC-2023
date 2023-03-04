// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMax.SoftLimitDirection;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;


import frc.robot.Constants;
import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Arm extends SubsystemBase {

 public CANSparkMax armExtendMotor, armHeightMotor1, armHeightMotor2;
 public MotorControllerGroup armHeight;

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

   resetAllArmEncoders();
  }


  //Set speed methods for movement

  public void setArmExtend(double speed) {
    armExtendMotor.set(speed);
  }

  public void setArmHeight(double speed) {
    armHeight.set(speed);
  }





  //get encoder position methods

  public double getArmExtendPosition() {
    return armExtendMotor.getEncoder().getPosition();
  }

  public double getArmHeightPosition() {

    double sumOfEncoders = 
    armHeightMotor1.getEncoder().getPosition() + armHeightMotor2.getEncoder().getPosition();

    double averagePosition = (sumOfEncoders / 2);

    return averagePosition;
  }





  //Encoder reset commands

  public void resetArmExtendEncoder() {
    armExtendMotor.getEncoder().setPosition(0);
  }

  public void resetArmHeightEncoders() {
    armHeightMotor1.getEncoder().setPosition(0);
    armHeightMotor2.getEncoder().setPosition(0);
  }

  public void resetAllArmEncoders() {
    armHeightMotor1.getEncoder().setPosition(0);
    armHeightMotor2.getEncoder().setPosition(0);
    armExtendMotor.getEncoder().setPosition(0);
  }




  //stops all movement on the arm
  public void stopArm(){
    armExtendMotor.set(0);
    armHeight.set(0);
  }

}