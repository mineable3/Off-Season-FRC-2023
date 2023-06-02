// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix.sensors.Pigeon2;
import com.ctre.phoenix.sensors.Pigeon2.AxisDirection;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;
import frc.robot.Constants;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class DriveTrain extends SubsystemBase {
  /** Creates a new DriveTrain. */

  private CANSparkMax leftmotor1, leftmotor2, leftmotor3, rightmotor1, rightmotor2, rightmotor3;
  private MotorControllerGroup leftTrain, rightTrain;
  private DifferentialDrive differentialDrive;
  private Pigeon2 gyro;

  

  



  public DriveTrain() {

    //drive train motors
    leftmotor1 = new CANSparkMax(Constants.leftmotorID1, MotorType.kBrushless);
    leftmotor2 = new CANSparkMax(Constants.leftmotorID2, MotorType.kBrushless);
    leftmotor2 = new CANSparkMax(Constants.leftmotorID3, MotorType.kBrushless);
    rightmotor1 = new CANSparkMax(Constants.rightmotorID1, MotorType.kBrushless);
    rightmotor2 = new CANSparkMax(Constants.rightmotorID2, MotorType.kBrushless);
    rightmotor3 = new CANSparkMax(Constants.rightmotorID3, MotorType.kBrushless);



    //gryo, motor controller groups and differential drive
    leftTrain = new MotorControllerGroup(leftmotor1, leftmotor2, rightmotor3);
    rightTrain = new MotorControllerGroup(rightmotor1 , rightmotor2, rightmotor3);
    gyro = new Pigeon2(Constants.pigeonID);
    differentialDrive = new DifferentialDrive(leftTrain, rightTrain);


    
    //inverting one side of the robot so we drive straight
    rightTrain.setInverted(true);
    gyro.configMountPose(AxisDirection.NegativeY, AxisDirection.PositiveZ);

  }


  //gryo commands/methods
  public double getYaw() {
    return gyro.getYaw();
  }
  public void resetYaw() {
    gyro.setYaw(0);
  }
  public double getPitch() {
    double pitch = (gyro.getPitch() % 360);
    return pitch;
  }
  public void resetPitch(){
    gyro.configMountPoseRoll(getRoll());
  }
  public double getRoll() {
    return gyro.getRoll();
  }


  //drive train commands/methods
  public double getDriveEncoders(){
    double encoders;

    encoders = leftmotor1.getEncoder().getPosition() +
    leftmotor2.getEncoder().getPosition() +
    leftmotor3.getEncoder().getPosition() +
    rightmotor1.getEncoder().getPosition() +
    rightmotor2.getEncoder().getPosition() +
    rightmotor3.getEncoder().getPosition();

    encoders /= 6;

    return encoders;
  }

  public void resetEncoders(){
    leftmotor1.getEncoder().setPosition(0);
    leftmotor2.getEncoder().setPosition(0);
    rightmotor1.getEncoder().setPosition(0);
    rightmotor2.getEncoder().setPosition(0);
  }
  
  
  //Arcade drive command
  public void arcadeDrive(double speed, double rotation) {
    differentialDrive.arcadeDrive(speed, rotation);
  }
  //tank drive command
  public void tankDrive(double leftSpeed, double rightSpeed) {
    differentialDrive.tankDrive(leftSpeed, rightSpeed);
  }

  public void gtaDrive(double speed, double curveSpeed, boolean turnInPlace) {
    differentialDrive.curvatureDrive(speed, curveSpeed, turnInPlace);
  }

  public CANSparkMax getleftmotor1() {
    return leftmotor1;
  }

  public CANSparkMax getleftmotor2() {
    return leftmotor2;
  }

  public CANSparkMax getleftmotor3() {
    return leftmotor3;
  }

  public CANSparkMax getrightmotor1() {
    return rightmotor1;
  }

  public CANSparkMax getrightmotor2() {
    return rightmotor2;
  }

  public CANSparkMax getrightmotor3() {
    return rightmotor3;
  }
  

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
