package frc.robot;


import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;
import edu.wpi.first.wpilibj2.command.button.Trigger;


public class ButtonBind{


    //controllers
    private final static CommandXboxController driverController = new CommandXboxController(0);
    private final static CommandXboxController auxController = new CommandXboxController(1);
    

    //Constructor method
    public ButtonBind() {}


    //driver bindings

    
//==========================Driver buttons and bumpers=============

    public final Trigger driverAButton = driverController.a();
    public final Trigger driverBButton = driverController.b();
    public final Trigger driverXButton = driverController.x();
    public final Trigger driverYButton = driverController.y();
    public final Trigger driverLeftBumper =  driverController.leftBumper();
    public final Trigger driverRightBumper = driverController.rightBumper();

    public Trigger getDriverB(){
        return driverBButton;
    }

    public Trigger getDriverA(){
        return driverAButton;

    }
    public Trigger getDriverX(){
        return driverXButton;
    }
    public Trigger getDriverY(){
        return driverYButton;
    }
    public boolean getDriverLeftBumper(){
        return driverLeftBumper.getAsBoolean();
    }
    public boolean getDriverRightBumper(){
        return driverRightBumper.getAsBoolean();
    } 


//=============================Driver Joysticks====================
    public final Trigger ContollerLeftJoystick = driverController.leftStick();
    public final double LeftaxisY = driverController.getLeftY();
    public final double LeftaxisX = driverController.getLeftX();
    public final Trigger ControllerRightJoystick = driverController.rightStick(); 
    public final double RightaxisY = driverController.getRightY();
    public final double RightaxisX =  driverController.getRightX();


    public boolean getDriverLeftJoystick(){
        return driverController.leftStick().getAsBoolean();
    }

    public double getDriverLeftY(){
        return driverController.getLeftY();
    }

    public double getDriverLeftX(){
        return driverController.getLeftX();
    }

    public boolean getDriverRightJoystick(){
        return driverController.rightStick().getAsBoolean();
    }

    public double getDriverRightX(){
        return driverController.getRightX();
    }

    public double getDriverRightY(){
        return driverController.getRightY();
    }


    //===================Driver Triggers==========================
    public final double driverLeftTrigger = auxController.getLeftTriggerAxis();
    public final double driverRightTrigger = auxController.getRightTriggerAxis();
    public final Trigger driverRightTriggerButton = auxController.rightTrigger();
    public final Trigger driverLeftTriggerButton = auxController.leftTrigger();


    public double getDriverLeftTrigger(){
        return driverController.getLeftTriggerAxis();
    }
    public double getDriverRightTrigger(){
        return driverController.getRightTriggerAxis();
    }
    public Trigger getDriverRightTriggerButton(){
        return driverRightTriggerButton;
    }
    public Trigger getDriverLeftTriggerButton(){
        return driverLeftTriggerButton;
    }


//=======================Driver DPad=======================

    public final Trigger DPadUp = driverController.povUp();
    public final Trigger DPadDown = driverController.povDown();
    public final Trigger DPadLeft = driverController.povLeft();
    public final Trigger DPadRight = driverController.povRight();

    public Trigger getDriverDPadUp(){
        return driverController.povUp();
    }
    public Trigger getDriverDPadDown(){   
        return driverController.povDown();
    }
    public Trigger getDriverDPadLeft(){
        return driverController.povLeft();
    }
    public Trigger getDriverDPadRight(){
        return driverController.povRight();
    }



//=============================Aux buttons and bumpers========================

    public final Trigger auxAButton = auxController.a();
    public final Trigger auxBButton = auxController.b();
    public final Trigger auxXButton = auxController.x();
    public final Trigger auxYButton = auxController.y();
    public final Trigger auxLeftBumper = auxController.leftBumper();
    public final Trigger auxRightBumper = auxController.rightBumper();



    public boolean getAuxA(){
        return auxAButton.getAsBoolean();
    }
    public boolean getAuxB(){
        return auxBButton.getAsBoolean();
    }
    public boolean getAuxX(){
        return auxXButton.getAsBoolean();
    }
    public boolean getAuxY(){
        return auxYButton.getAsBoolean();
    }
    public boolean getAuxLeftBumper(){
        return auxLeftBumper.getAsBoolean();
    }
    public boolean getAuxRightBumper(){
        return auxRightBumper.getAsBoolean();
    }

//==========================Aux Joysticks==============================

    public final Trigger auxLeftJoystick = auxController.leftStick();
    public final double auxleftY = auxController.getLeftY();
    public final double auxleftX = auxController.getLeftX();
    public final Trigger auxrightJoystick = auxController.rightStick();
    public final double auxrightY = auxController.getRightY();
    public final double auxrightX = auxController.getRightX();

    public boolean auxLeftJoystick(){
        return auxController.leftStick().getAsBoolean();
    }

    public double auxLeftX(){
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

//===================Aux Triggers==========================
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
    public Trigger getAuxRightTriggerButton(){
        return auxRightTriggerButton;
    }
    public Trigger getAuxLeftTriggerButton(){
        return auxLeftTriggerButton;
    }


//=======================Aux DPad============================

    public final Trigger AuxDPadUp = auxController.povUp();
    public final Trigger AuxDPadDown = auxController.povDown();
    public final Trigger AuxDPadLeft = auxController.povLeft();
    public final Trigger AuxDPadRight = auxController.povRight();



    public Trigger auxDPadUp(){
        return AuxDPadUp;
    }
    public Trigger auxDPadDown(){
        return AuxDPadDown;
    }
    public Trigger auxDPadLeft(){
        return AuxDPadLeft;
    }
    public Trigger auxDPadRight(){
        return AuxDPadRight;
    }



//=====================Limit Switches=========================







}