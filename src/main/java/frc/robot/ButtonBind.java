package frc.robot;


import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.GenericHID.RumbleType;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;
import edu.wpi.first.wpilibj2.command.button.Trigger;


public class ButtonBind{
//controllers
public final static CommandXboxController driverController = new CommandXboxController(0);
public final static CommandXboxController auxController = new CommandXboxController(1);

//driver bindings
//bindings for controller 


public final Trigger ButtonA = driverController.a();
public final Trigger ButtonB = driverController.b();
public final Trigger ButtonX = driverController.x();
public final Trigger ButtonY = driverController.y();
public final Trigger LeftTrigger =  driverController.leftBumper();
public final Trigger RightTrigger = driverController.rightBumper();

public boolean getDriveB(){
    return driverController.b().getAsBoolean();
}

public boolean getdriveA(){
    return driverController.a().getAsBoolean();

}
public boolean getDriveX(){
    return driverController.x().getAsBoolean();
}
public boolean getButtonY(){
    return driverController.y().getAsBoolean();
}
public boolean LeftTrigger(){
    return driverController.leftTrigger().getAsBoolean();
}
public boolean RightTrigger(){
    return driverController.rightTrigger().getAsBoolean();
} 
//binds for controller but joystick
public final Trigger ContollerLeftJoystick = driverController.leftStick();
public final double LeftaxisY = driverController.getLeftY();
public final double LeftaxisX = driverController.getLeftX();
public final Trigger ControllerRightJoystick = driverController.rightStick(); 
public final double RightaxisY = driverController.getRightY();
public final double RightaxisX =  driverController.getRightX();


public boolean getLeftJoystick(){
    return driverController.leftStick().getAsBoolean();

}
public double getLeftY(){
    return driverController.getLeftY();

}
public double getLeftX(){
    return driverController.getLeftX();

}
public boolean getRightJoystick(){
    return driverController.rightStick().getAsBoolean();
}
public double getRightX(){
    return driverController.getRightX();
}
public double getRightY(){
    return driverController.getRightY();
}




public final Trigger DPadUp = driverController.povUp();
public final Trigger DPadDown = driverController.povDown();
public final Trigger DPadLeft = driverController.povLeft();
public final Trigger DPadRight = driverController.povRight();

public Trigger getDPadUp(){
    return driverController.povUp();
}
public Trigger getDPadDown(){   
    return driverController.povDown();
}
public Trigger getDPadLeft(){
    return driverController.povLeft();
}
public Trigger getDPadRight(){
    return driverController.povRight();
}

//aux bindings

public final Trigger auxAButton = auxController.a();
public final Trigger auxBButton = auxController.b();
public final Trigger auxXButton = auxController.x();
public final Trigger auxYButton = auxController.y();
public final Trigger auxLeftBumper = auxController.leftBumper();
public final Trigger auxRightBumper = auxController.rightBumper();



public boolean getAuxA(){
    return auxController.a().getAsBoolean();
}
public boolean getAuxB(){
    return auxController.b().getAsBoolean();
}
public boolean getAuxX(){
    return auxController.x().getAsBoolean();
}
public boolean getAuxY(){
    return auxController.y().getAsBoolean();
}
public boolean getLeftBumper(){
    return auxController.leftBumper().getAsBoolean();
}
public boolean getRightBumper(){
    return auxController.rightBumper().getAsBoolean();
}

//bindings for aux but for the joysticks

public final Trigger auxLeftJoystick = auxController.leftStick();
public final double auxleftY = auxController.getLeftY();
public final double auxleftX = auxController.getLeftX();
public Trigger auxrightJoystick = auxController.rightStick();
public final double auxrightY = auxController.getRightY();
public final double auxrightX = auxController.getRightX();

public boolean auxLeftJoystick(){
    return auxController.leftStick().getAsBoolean();
}

public double  auxLeftX(){
    return auxController.getLeftX();
}
public double auxLeftY(){
    return auxController.getLeftY();
}
public boolean auxrightJoystick(){
    return auxController.rightStick().getAsBoolean();
}
public double auxrightY(){
    return auxController.getRightY();
}
public double auxrightX(){
    return auxController.getRightX();
}

//binding for triggers 
public final double auxLeftTrigger = auxController.getLeftTriggerAxis();
public final double auxRightTrigger = auxController.getRightTriggerAxis();
public final Trigger auxRightTriggerButton = auxController.rightTrigger();
public final Trigger auxLeftTriggerButton = auxController.leftTrigger();


public double getAuxLeftTrigger(){
    return auxController.getLeftTriggerAxis();
}
public double getAuxRightTrigger(){
    return auxController.getRightTriggerAxis();
}
public Trigger getRightTriggerButton(){
    return auxRightTriggerButton;
}
public Trigger getLeftTriggerButton(){
    return auxLeftTriggerButton;
}

public final Trigger AuxDPadUp = auxController.povUp();
public final Trigger AuxDPadDown = auxController.povDown();
public final Trigger AuxDPadLeft = auxController.povLeft();
public final Trigger AuxDPadRight = auxController.povRight();



public Trigger auxDPadUp(){
return auxController.povUp();
}
public Trigger auxDPadDown(){
    return auxController.povDown();
}
public Trigger auxDPadLeft(){
    return auxController.povLeft();
}
public Trigger auxDPadRight(){
    return auxController.povRight();
}
}