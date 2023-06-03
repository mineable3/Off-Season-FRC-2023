package frc.robot;



import edu.wpi.first.wpilibj2.command.button.CommandGenericHID;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;
import edu.wpi.first.wpilibj2.command.button.Trigger;


public class ButtonBind{


    //controllers
    private final static CommandXboxController driverController = new CommandXboxController(0);
    private final static CommandGenericHID auxController = new CommandGenericHID(1);
    

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
    public final Trigger contollerLeftJoystick = driverController.leftStick();
    public final double leftAxisY = driverController.getLeftY();
    public final double leftAxisX = driverController.getLeftX();
    public final Trigger controllerRightJoystick = driverController.rightStick(); 
    public final double rightAxisY = driverController.getRightY();
    public final double rightAxisX =  driverController.getRightX();


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
    public final double driverLeftTrigger = driverController.getLeftTriggerAxis();
    public final double driverRightTrigger = driverController.getRightTriggerAxis();
    public final Trigger driverRightTriggerButton = driverController.rightTrigger();
    public final Trigger driverLeftTriggerButton = driverController.leftTrigger();


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

    public final Trigger auxAButton = auxController.button(2);//a
    public final Trigger auxBButton = auxController.button(3);//B
    public final Trigger auxXButton = auxController.button(1);//X
    public final Trigger auxYButton = auxController.button(4);//Y
    public final Trigger auxLeftBumper = auxController.button(5);
    public final Trigger auxRightBumper = auxController.button(6);



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


    
    //public final Trigger auxLeftJoystickTrigger = auxController.axisGreaterThan(1, .5);
    public final double auxleftY = auxController.getRawAxis(1);
    public final double auxleftX = auxController.getRawAxis(0);
    public final Trigger auxrightJoystickYup = auxController.axisGreaterThan(1, -.4);
    public final Trigger auxrightJoystickYdown = auxController.axisLessThan(1, .4);
    public final Trigger auxleftJoystickYup = auxController.axisGreaterThan(1, .4);
    public final Trigger auxleftJoystickYdown = auxController.axisLessThan(1, -.4);
    //public final double auxrightY = auxController.getRightY();
    //public final double auxrightX = auxController.getRightX();

    //public boolean getAuxLeftJoystick(){
    //    return auxleftX;
    //}

    public double getAuxLeftX(){
        return auxleftX;
    }
    public double getAuxLeftY(){
        return auxleftY;
    }
    //public boolean getAuxrightJoystick(){
    //    return auxController.rightStick().getAsBoolean();
    //}
    //public double getAuxrightY(){
    //    return auxController.getRightY();
    //}
    //public double getAuxrightX(){
    //    return auxController.getRightX();
    //}

//===================Aux Triggers==========================
/* 
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
    }*/

    public final Trigger buttonOne =  auxController.button(1);
    public final Trigger buttonTwo =  auxController.button(2);
    public final Trigger buttonThree =  auxController.button(3);
    public final Trigger buttonFour =  auxController.button(4);
    public final Trigger buttonFive =  auxController.button(5);
    public final Trigger buttonSix =  auxController.button(6);
    public final Trigger buttonSeven =  auxController.button(7);
    public final Trigger buttonEight =  auxController.button(8);
  
    public final double auxControllerX = auxController.getRawAxis(0);
    public final double auxControllerY = auxController.getRawAxis(1);
    

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


}