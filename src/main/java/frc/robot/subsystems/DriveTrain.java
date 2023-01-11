// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;
import frc.robot.Constants;
import frc.robot.commands.ArcadeDrive;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class DriveTrain extends SubsystemBase {
  /** Creates a new DriveTrain. */
  private CANSparkMax leftmotor1, leftmotor2, rightmotor1, rightmotor2;
  private MotorControllerGroup leftTrain, rightTrain;
  private DifferentialDrive differentialDrive;

  public DriveTrain() {

    leftmotor1 = new CANSparkMax(Constants.leftmotorID1, MotorType.kBrushless);
    leftmotor2 = new CANSparkMax(Constants.leftmotorID2, MotorType.kBrushless);
    rightmotor1 = new CANSparkMax(Constants.rightmotorID1, MotorType.kBrushless);
    rightmotor2 = new CANSparkMax(Constants.rightmotorID2, MotorType.kBrushless);

    leftTrain = new MotorControllerGroup(leftmotor1, leftmotor2);
    rightTrain = new MotorControllerGroup(rightmotor1, rightmotor2);

    differentialDrive = new DifferentialDrive(leftTrain, rightTrain);

    rightTrain.setInverted(true);
  }



  public void arcadeDrive(double speed, double rotation) {
    differentialDrive.arcadeDrive(speed, rotation);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
