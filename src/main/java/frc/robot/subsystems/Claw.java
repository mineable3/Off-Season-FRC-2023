// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMax.SoftLimitDirection;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;
import frc.robot.Constants;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Claw extends SubsystemBase {
  /** Creates a new Claw. */
  public CANSparkMax clawMotor;

  public Claw() {

    //the motor that opens and shuts the claw
    clawMotor = new CANSparkMax(Constants.clawMotorID, MotorType.kBrushless);

    //CHANGE LIMITS WHEN THE ROBOT IS DONE, THE 10'S ARE JUST PLACE HOLDERS
    clawMotor.setSoftLimit(SoftLimitDirection.kForward, 10);
    clawMotor.setSoftLimit(SoftLimitDirection.kReverse, 10);
    clawMotor.enableSoftLimit(SoftLimitDirection.kForward, true);
    clawMotor.enableSoftLimit(SoftLimitDirection.kReverse, true);

    resetEncoder();
  }

  public void moveClaw(double speed) {
    clawMotor.set(speed);
  }


  //Encoder methods
  public double getEncoderPosition(){
    return clawMotor.getEncoder().getPosition();
  }
  public void resetEncoder() {
    clawMotor.getEncoder().setPosition(0);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
