// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands.MiscellaneousCommands;

import edu.wpi.first.wpilibj.AddressableLED;
import edu.wpi.first.wpilibj.AddressableLEDBuffer;
import edu.wpi.first.wpilibj2.command.CommandBase;

public class LEDColorChange extends CommandBase {
  /** Creates a new LEDColorChange. */

  //makes a new LED strip on the roborio in PWM port 9
  AddressableLED m_led = new AddressableLED(9);
  //makes a led buffer with a length of 60
  AddressableLEDBuffer m_ledBuffer = new AddressableLEDBuffer(60);
  String color;
  public LEDColorChange() {}

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    m_led.setLength(m_ledBuffer.getLength());

    //set the data
    m_led.setData(m_ledBuffer);
    m_led.start();
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    
    if (color == "yellow") {
      //set the color to yellow and sets purple to be next
      for (var i = 0; i < m_ledBuffer.getLength(); i++) {
        m_ledBuffer.setHSV(i, 289, 82, 75);
        color = "purple";
      }
    } 
    else if (color == "purple") {
      //set the color to purple and sets the leds to be off next
      for (var i = 0; i < m_ledBuffer.getLength(); i++) {
        m_ledBuffer.setHSV(i, 56, 97, 95);
        color = "off";
      }
    } else {
      //turns the leds off and sets yellow to be next
      for (var i = 0; i < m_ledBuffer.getLength(); i++) {
        m_ledBuffer.setHSV(i, 0, 0, 0);
        color = "yellow";
      }
    }


    m_led.setData(m_ledBuffer);
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    m_led.stop();
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return true;
  }
}
