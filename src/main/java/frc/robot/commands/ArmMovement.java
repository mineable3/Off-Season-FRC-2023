// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import com.revrobotics.CANSparkMax;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj2.command.CommandBase;

import frc.robot.RobotContainer;

public class ArmMovement extends CommandBase {

  /** Creates a new ArmMovement. */
  public ArmMovement() {
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(RobotContainer.m_arm);

  }
 
  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
  RobotContainer.m_arm.resetArmEncoder();
  
  }
 
  


       
  // Called every time the scheduler runs while the command is scheduled.
  @Override

  
  
  public void execute() {

double speed = RobotContainer.m_driverController.getRightX();

RobotContainer.m_arm.setArm(speed);



  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    RobotContainer.m_arm.setArm(0);
  
  }


//limit switch code 
DigitalInput topLimitSwitch = new DigitalInput(0);
DigitalInput bottomLimitSwitch = new DigitalInput(1);
CANSparkMax motor = new CANSparkMax(0, null);


//This piece is for if the limitswitch were to go up/ if tripped while going up 
public void LimitMotorUp(double speed) {
  if (speed > 0){
    if (topLimitSwitch.get()){
      motor.set(0);
      //basically sayings switch is tripped leading to the motor stopping
    

      }
      else {
        motor.set(speed);
        // if switch is not tripped

      }
  
      

      
    }
  }
  //this part of the code is if the limit switch were to go down/tripped while going down
public void LimitMotorDown(double speed){
  if (speed > 0){
    if (bottomLimitSwitch.get()){
      motor.set(0);
    }
    else{
    motor.set(0);
    //if switch is not tripped
    }
  }
}


 






  public void setArmSpeed(){

  }


  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
