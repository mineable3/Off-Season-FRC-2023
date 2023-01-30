// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix.sensors.Pigeon2;
import com.ctre.phoenix.sensors.Pigeon2.AxisDirection;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMax.IdleMode;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;
import frc.robot.Constants;
import edu.wpi.first.math.controller.PIDController;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class DriveTrain extends SubsystemBase {
  /** Creates a new DriveTrain. */

  public CANSparkMax leftmotor1, leftmotor2, rightmotor1, rightmotor2;
  private MotorControllerGroup leftTrain, rightTrain;
  private DifferentialDrive differentialDrive;
  private Pigeon2 gyro;
  private PIDController pidController;

  public DriveTrain() {

    //drive train motors
    leftmotor1 = new CANSparkMax(Constants.leftmotorID1, MotorType.kBrushless);
    //leftmotor2 = new CANSparkMax(Constants.leftmotorID2, MotorType.kBrushless);
    rightmotor1 = new CANSparkMax(Constants.rightmotorID1, MotorType.kBrushless);
    //rightmotor2 = new CANSparkMax(Constants.rightmotorID2, MotorType.kBrushless);

    //gryo, motor controller groups and differential drive
    leftTrain = new MotorControllerGroup(leftmotor1/*, leftmotor2*/);
    rightTrain = new MotorControllerGroup(rightmotor1/* , rightmotor2*/);
    gyro = new Pigeon2(Constants.pigeonID);
    differentialDrive = new DifferentialDrive(leftTrain, rightTrain);
    pidController = new PIDController(0.5, 0, 0);
    pidController.calculate(getDriveEncoder());

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
    return gyro.getPitch();
  }
  public void resetPitch() {
    
  }
  public double getRoll() {
    return gyro.getRoll();
  }


  //drive train commands/methods
  public double getDriveEncoder(){
    return leftmotor1.getEncoder().getPosition();
  }
  public void resetEncoders(){
    leftmotor1.getEncoder().setPosition(0);
    //leftmotor2.getEncoder().setPosition(0);
    rightmotor1.getEncoder().setPosition(0);
    //rightmotor2.getEncoder().setPosition(0);
  }
  
  
  //Arcade drive command
  public void arcadeDrive(double speed, double rotation) {
    //leftmotor1.setIdleMode(IdleMode.kCoast);
    //leftmotor2.setIdleMode(IdleMode.kCoast);
    //rightmotor1.setIdleMode(IdleMode.kCoast);
    //rightmotor2.setIdleMode(IdleMode.kCoast);

    differentialDrive.arcadeDrive(speed, rotation);
  }
  //tank drive command
  public void tankDrive(double leftSpeed, double rightSpeed) {
    differentialDrive.tankDrive(leftSpeed, rightSpeed);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
