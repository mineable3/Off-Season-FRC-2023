// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import java.util.*;
import java.util.concurrent.atomic.AtomicReference;

import edu.wpi.first.networktables.DoubleTopic;
import edu.wpi.first.networktables.NetworkTable;
import edu.wpi.first.networktables.NetworkTableEvent;
import edu.wpi.first.networktables.NetworkTableInstance;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;
import edu.wpi.first.wpilibj2.command.button.Trigger;
import frc.robot.commands.Autos;
import frc.robot.commands.ExampleCommand;
import frc.robot.commands.LEDColorChange;
import frc.robot.commands.ClawCommands.ClawToSetPoint;
import frc.robot.commands.ClawCommands.ClawOpen;
import frc.robot.commands.ClawCommands.ClawTurretMovement;
import frc.robot.commands.DriveTrainCommands.ArcadeDrive;
import frc.robot.commands.DriveTrainCommands.PIDChargingStation;
import frc.robot.commands.DriveTrainCommands.TurnToAngle;
import frc.robot.commands.TurretCommands.ManualTurretSpin;
import frc.robot.commands.VisionCommands.GamePieceTraking;
import frc.robot.subsystems.Arm;
import frc.robot.subsystems.Claw;
import frc.robot.subsystems.DriveTrain;
import frc.robot.subsystems.ExampleSubsystem;
import frc.robot.subsystems.Turret;
import frc.robot.subsystems.ClawTurret;

/**
 * This class is where he bulk of the robot should be declared. Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls). Instead, the structure of the robot (including
 * subsystems, commands, and trigger mappings) should be declared here.
 */
public class RobotContainer {
  // The robot's subsystems and commands are defined here...
  private final ExampleSubsystem m_exampleSubsystem = new ExampleSubsystem();
  public final static DriveTrain m_DriveTrain = new DriveTrain();
  public final static Turret m_Turret = new Turret();
  public final static Claw m_Claw = new Claw();
  public final static ClawTurretMovement m_clawTurretMovement = new ClawTurretMovement();
  public final static Arm m_Arm = new Arm();
  public final static ClawTurret m_ClawTurret = new ClawTurret();
  public final static ButtonBind m_ButtonBind = new ButtonBind();

  private AtomicReference<Double> tv = new AtomicReference<Double>();
  private AtomicReference<Double> tx = new AtomicReference<Double>();
  private AtomicReference<Double> ty = new AtomicReference<Double>();
  private AtomicReference<Double> ta = new AtomicReference<Double>();
  private AtomicReference<Double> tl = new AtomicReference<Double>();
  private AtomicReference<Double> cl = new AtomicReference<Double>();
  private AtomicReference<Double> tshort = new AtomicReference<Double>();
  private AtomicReference<Double> tlong = new AtomicReference<Double>();
  private AtomicReference<Double> thor = new AtomicReference<Double>();
  private AtomicReference<Double> tvert = new AtomicReference<Double>();
  private AtomicReference<Double> tid = new AtomicReference<Double>();

  private DoubleTopic dlbTopic_tv;
  private DoubleTopic dlbTopic_tx;
  private DoubleTopic dlbTopic_ty;
  private DoubleTopic dlbTopic_ta;
  private DoubleTopic dlbTopic_tl;
  private DoubleTopic dlbTopic_cl;
  private DoubleTopic dlbTopic_tshort;
  private DoubleTopic dlbTopic_tlong;
  private DoubleTopic dlbTopic_thor;
  private DoubleTopic dlbTopic_tvert;
  private DoubleTopic dlbTopic_tid;


  public double tvHandle; //Whether the limelight has any valid targets (0 or 1)
  public double txHandle; //Horizontal Offset From Crosshair To Target (LL1: -27 degrees to 27 degrees | LL2: -29.8 to 29.8 degrees)
  public double tyHandle; //Vertical Offset From Crosshair To Target (LL1: -20.5 degrees to 20.5 degrees | LL2: -24.85 to 24.85 degrees)
  public double taHandle; //Target Area (0% of image to 100% of image)
  public double tlHandle; //The pipeline’s latency contribution (ms). Add to “cl” to get total latency.
  public double clHandle; //Capture pipeline latency (ms). Time between the end of the exposure of the middle row of the sensor to the beginning of the tracking pipeline.
  public double tshortHandle; //Sidelength of shortest side of the fitted bounding box (pixels)
  public double tlongHandle; //Sidelength of longest side of the fitted bounding box (pixels)
  public double thorHandle; //Horizontal sidelength of the rough bounding box (0 - 320 pixels)
  public double tvertHandle; //Vertical sidelength of the rough bounding box (0 - 320 pixels)
  public double tidHandle; //ID of the primary in-view AprilTag





  /** The container for the robot. Contains subsystems, OI devices, and commands. */
  public RobotContainer() {
    // Configure the trigger bindings    
    configureBindings();
    configureNetworkTables();
  }






  /**
   * Use this method to define your trigger->command mappings. Triggers can be created via the
   * {@link Trigger#Trigger(java.util.function.BooleanSupplier)} constructor with an arbitrary
   * predicate, or via the named factories in {@link
   * edu.wpi.first.wpilibj2.command.button.CommandGenericHID}'s subclasses for {@link
   * CommandXboxController Xbox}/{@link edu.wpi.first.wpilibj2.command.button.CommandPS4Controller
   * PS4} controllers or {@link edu.wpi.first.wpilibj2.command.button.CommandJoystick Flight
   * joysticks}.
   */
  private void configureBindings() {
    // Schedule `ExampleCommand` when `exampleCondition` changes to `true`
    new Trigger(m_exampleSubsystem::exampleCondition)
        .onTrue(new ExampleCommand(m_exampleSubsystem));

    m_DriveTrain.setDefaultCommand(new ArcadeDrive());

    
    m_ButtonBind.driverBButton.whileTrue(new TurnToAngle(0));
    m_ButtonBind.driverAButton.whileTrue(new PIDChargingStation());
    

    /*aux will also 
    rightJoystick: arm
    leftJoystick: claw turret
    */
    m_ButtonBind.auxRightBumper.whileTrue(new ManualTurretSpin(.8));
    m_ButtonBind.auxLeftBumper.whileTrue(new ManualTurretSpin(-.8));
    m_ButtonBind.auxXButton.onTrue(new LEDColorChange());
    m_ButtonBind.auxAButton.onTrue(new ClawToSetPoint(.5));
    m_ButtonBind.auxBButton.onTrue(new ClawOpen());
    m_ButtonBind.auxYButton.whileTrue(new GamePieceTraking(tx));
    
  }




//==========================Network tables===================================



  private void configureNetworkTables(){
    NetworkTableInstance defaultNTinst = NetworkTableInstance.getDefault();
    NetworkTable lime = defaultNTinst.getTable("limelight");

    //NetworkTable lime = NetworkTableInstance.getDefault().getTable("limelight");
    //NetworkTableEntry tx = lime.getEntry("tx");



    dlbTopic_tv = lime.getDoubleTopic("tv");

     tvHandle = defaultNTinst.addListener(
      dlbTopic_tv,
      EnumSet.of(NetworkTableEvent.Kind.kValueAll), 
      event -> {
        tv.set(event.valueData.value.getDouble());
      }
     );

    dlbTopic_tx = lime.getDoubleTopic("tx");

    txHandle = defaultNTinst.addListener(
      dlbTopic_tx,
      EnumSet.of(NetworkTableEvent.Kind.kValueAll), 
      event -> {
        tx.set(event.valueData.value.getDouble());
      }
    );


     dlbTopic_ty = lime.getDoubleTopic("ty");

     tyHandle = defaultNTinst.addListener(
      dlbTopic_ty,
      EnumSet.of(NetworkTableEvent.Kind.kValueAll), 
      event -> {
        ty.set(event.valueData.value.getDouble());
      }
     );

     dlbTopic_ta = lime.getDoubleTopic("ta");

     taHandle = defaultNTinst.addListener(
      dlbTopic_ta,
      EnumSet.of(NetworkTableEvent.Kind.kValueAll), 
      event -> {
        ta.set(event.valueData.value.getDouble());
      }
     );

     dlbTopic_tl = lime.getDoubleTopic("tl");

     tlHandle = defaultNTinst.addListener(
      dlbTopic_tl,
      EnumSet.of(NetworkTableEvent.Kind.kValueAll), 
      event -> {
        tl.set(event.valueData.value.getDouble());
      }
     );

     dlbTopic_cl = lime.getDoubleTopic("cl");

     clHandle = defaultNTinst.addListener(
      dlbTopic_cl,
      EnumSet.of(NetworkTableEvent.Kind.kValueAll), 
      event -> {
        cl.set(event.valueData.value.getDouble());
      }
     );

     dlbTopic_tshort = lime.getDoubleTopic("tshort");

     tshortHandle = defaultNTinst.addListener(
      dlbTopic_tshort,
      EnumSet.of(NetworkTableEvent.Kind.kValueAll), 
      event -> {
        tshort.set(event.valueData.value.getDouble());
      }
     );

     dlbTopic_tlong = lime.getDoubleTopic("tlong");

     tlongHandle = defaultNTinst.addListener(
      dlbTopic_tlong,
      EnumSet.of(NetworkTableEvent.Kind.kValueAll), 
      event -> {
        tlong.set(event.valueData.value.getDouble());
      }
     );

     dlbTopic_thor = lime.getDoubleTopic("thor");

     thorHandle = defaultNTinst.addListener(
      dlbTopic_thor,
      EnumSet.of(NetworkTableEvent.Kind.kValueAll), 
      event -> {
        thor.set(event.valueData.value.getDouble());
      }
     );

     dlbTopic_tvert = lime.getDoubleTopic("tvert");

     tvertHandle = defaultNTinst.addListener(
      dlbTopic_tvert,
      EnumSet.of(NetworkTableEvent.Kind.kValueAll), 
      event -> {
        tvert.set(event.valueData.value.getDouble());
      }
     );

     dlbTopic_tid = lime.getDoubleTopic("tid");

     tidHandle = defaultNTinst.addListener(
      dlbTopic_tid,
      EnumSet.of(NetworkTableEvent.Kind.kValueAll), 
      event -> {
        tid.set(event.valueData.value.getDouble());
      }
     );


  }





  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */
  public Command getAutonomousCommand() {
    // An example command will be run in autonomous
    return Autos.exampleAuto(m_exampleSubsystem);
  }
}
