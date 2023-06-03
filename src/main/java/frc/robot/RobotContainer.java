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
import edu.wpi.first.wpilibj.shuffleboard.Shuffleboard;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;
import edu.wpi.first.wpilibj2.command.button.Trigger;
import frc.robot.commands.ExampleCommand;
import frc.robot.commands.ArmCommands.ManualArmExtend;
import frc.robot.commands.ArmCommands.ManualArmLift;
import frc.robot.commands.Autonomous.LevelingSystem;
import frc.robot.commands.Autonomous.TopCubeScore;
import frc.robot.commands.Autonomous.TwoCubeScoring;
import frc.robot.commands.DriveTrainCommands.GTADrive;
import frc.robot.commands.DriveTrainCommands.MoveForDistance;
import frc.robot.commands.IntakeCommands.ManualIntake;
import frc.robot.commands.SetPoints.Home;
import frc.robot.commands.TurretCommands.ManualTurretSpin;
import frc.robot.commands.VisionCommands.TurnToTarget;
import frc.robot.subsystems.ArmExtend;
import frc.robot.subsystems.ArmLift;
import frc.robot.subsystems.Intake;
import frc.robot.subsystems.DriveTrain;
import frc.robot.subsystems.ExampleSubsystem;
import frc.robot.subsystems.Turret;

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
  public final static Intake m_Intake = new Intake();
  public final static ArmLift m_ArmLift = new ArmLift();
  public final static ArmExtend m_ArmExtend = new ArmExtend();
  public final static ButtonBind m_ButtonBind = new ButtonBind();

  public static AtomicReference<Double> tv = new AtomicReference<Double>();
  public static AtomicReference<Double> tx = new AtomicReference<Double>();
  public static AtomicReference<Double> ty = new AtomicReference<Double>();
  public static AtomicReference<Double> tid = new AtomicReference<Double>();

  private DoubleTopic dlbTopic_tv;
  private DoubleTopic dlbTopic_tx;
  private DoubleTopic dlbTopic_ty;
  private DoubleTopic dlbTopic_tid;


  public double tvHandle; //Whether the limelight has any valid targets (0 or 1)
  public double txHandle; //Horizontal Offset From Crosshair To Target (LL1: -27 degrees to 27 degrees | LL2: -29.8 to 29.8 degrees)
  public double tyHandle; //Vertical Offset From Crosshair To Target (LL1: -20.5 degrees to 20.5 degrees | LL2: -24.85 to 24.85 degrees)
  public double tidHandle; //ID of the primary in-view AprilTag

  public static AtomicReference<Double> intaketv = new AtomicReference<Double>();
  public static AtomicReference<Double> intaketx = new AtomicReference<Double>();
  public static AtomicReference<Double> intakety = new AtomicReference<Double>();
  public static AtomicReference<Double> intaketid = new AtomicReference<Double>();

  private DoubleTopic intakeDlbTopic_tv;
  private DoubleTopic intakeDlbTopic_tx;
  private DoubleTopic intakeDlbTopic_ty;
  private DoubleTopic intakeDlbTopic_tid;


  public double intakeTvHandle; //Whether the limelight has any valid targets (0 or 1)
  public double intakeTxHandle; //Horizontal Offset From Crosshair To Target (LL1: -27 degrees to 27 degrees | LL2: -29.8 to 29.8 degrees)
  public double intakeTyHandle; //Vertical Offset From Crosshair To Target (LL1: -20.5 degrees to 20.5 degrees | LL2: -24.85 to 24.85 degrees)
  public double intakeTidHandle; //ID of the primary in-view AprilTag

  SendableChooser<Command> autoChooser;



  /** The container for the robot. Contains subsystems, OI devices, and commands. */
  public RobotContainer() {
    // Configure the trigger bindings    
    configureBindings();
    configureNetworkTables();
    configureShuffleBoard();
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

    m_DriveTrain.setDefaultCommand(new GTADrive());
    

    //turret
    m_ButtonBind.auxRightBumper.whileTrue(new ManualTurretSpin(.3));
    m_ButtonBind.auxLeftBumper.whileTrue(new ManualTurretSpin(-.3));

    //claw
    m_ButtonBind.auxBButton.whileTrue(new ManualIntake(true));
    m_ButtonBind.auxAButton.whileTrue(new ManualIntake(false));

    //setpoints
    m_ButtonBind.buttonSeven.onTrue(new Home());

    //vision
    //m_ButtonBind.auxYButton.whileTrue(new TurnToTarget(.3));

    //arm lift
    m_ButtonBind.auxleftJoystickYdown.whileTrue(new ManualArmLift(-.3));
    m_ButtonBind.auxleftJoystickYup.whileTrue(new ManualArmLift(.3));
    
    //arm extend
    
    m_ButtonBind.auxXButton.whileTrue(new ManualArmExtend(.6));
    m_ButtonBind.auxYButton.whileTrue(new ManualArmExtend(-.6));
    
  }


//===============================Shuffle board=====================================

    private void configureShuffleBoard() {
      autoChooser = new SendableChooser<Command>();

      autoChooser.setDefaultOption("One cube", new TopCubeScore());

      autoChooser.addOption("Two Cube", new TwoCubeScoring());
      autoChooser.addOption("Charging station", new LevelingSystem());
      autoChooser.addOption("Only move", new MoveForDistance(4));

      Shuffleboard.getTab("Main").add(autoChooser);
    }




//==========================Network tables===================================



  private void configureNetworkTables(){
    NetworkTableInstance defaultNTinst = NetworkTableInstance.getDefault();
    NetworkTable lime = defaultNTinst.getTable("limelight-aimming");

    NetworkTable limeIntake = defaultNTinst.getTable("limelight-cargo");
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

     dlbTopic_tid = lime.getDoubleTopic("tid");

     tidHandle = defaultNTinst.addListener(
      dlbTopic_tid,
      EnumSet.of(NetworkTableEvent.Kind.kValueAll), 
      event -> {
        tid.set(event.valueData.value.getDouble());
      }
     );



     intakeDlbTopic_tv = limeIntake.getDoubleTopic("tv");

     intakeTvHandle = defaultNTinst.addListener(
      intakeDlbTopic_tv,
      EnumSet.of(NetworkTableEvent.Kind.kValueAll), 
      event -> {
        intaketv.set(event.valueData.value.getDouble());
      }
     );

    intakeDlbTopic_tx = limeIntake.getDoubleTopic("tx");

    intakeTxHandle = defaultNTinst.addListener(
      intakeDlbTopic_tx,
      EnumSet.of(NetworkTableEvent.Kind.kValueAll), 
      event -> {
        intaketx.set(event.valueData.value.getDouble());
      }
    );


     intakeDlbTopic_ty = limeIntake.getDoubleTopic("ty");

     intakeTyHandle = defaultNTinst.addListener(
      intakeDlbTopic_ty,
      EnumSet.of(NetworkTableEvent.Kind.kValueAll), 
      event -> {
        intakety.set(event.valueData.value.getDouble());
      }
     );

     intakeDlbTopic_tid = limeIntake.getDoubleTopic("tid");

     intakeTidHandle = defaultNTinst.addListener(
      intakeDlbTopic_tid,
      EnumSet.of(NetworkTableEvent.Kind.kValueAll), 
      event -> {
        intaketid.set(event.valueData.value.getDouble());
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
    return autoChooser.getSelected();
  }
}
