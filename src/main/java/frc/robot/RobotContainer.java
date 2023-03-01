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
import frc.robot.Constants.OperatorConstants;
import frc.robot.commands.Autos;
import frc.robot.commands.ClawGrab;
import frc.robot.commands.ExampleCommand;
import frc.robot.commands.LEDColorChange;
import frc.robot.commands.TurretSpin;
import frc.robot.commands.DriveTrainCommands.ArcadeDrive;
import frc.robot.commands.DriveTrainCommands.PIDChargingStation;
import frc.robot.commands.DriveTrainCommands.TurnToAngle;
import frc.robot.commands.VisionCommands.GamePieceTraking;
import frc.robot.subsystems.Claw;
import frc.robot.subsystems.DriveTrain;
import frc.robot.subsystems.ExampleSubsystem;
import frc.robot.subsystems.Turret;

/**
 * This class is where the bulk of the robot should be declared. Since Command-based is a
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

  private AtomicReference<Double> tx = new AtomicReference<Double>();
  private DoubleTopic dlbTopic_tx;
  public double txHandle;
  
  public static final CommandXboxController m_driverController =
      new CommandXboxController(OperatorConstants.kDriverControllerPort);
  public static final CommandXboxController m_auxController =
      new CommandXboxController(OperatorConstants.kAuxControllerPort);



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
    //m_DriveTrain.setDefaultCommand(new TankDrive());
    m_driverController.b().whileTrue(new TurnToAngle(0));
    m_driverController.a().whileTrue(new PIDChargingStation());
    

    /*aux will also 
    rightJoystick: arm
    leftJoystick: claw turret
    */
    m_auxController.rightTrigger().onTrue(new TurretSpin(m_driverController.getRightTriggerAxis()));
    m_auxController.leftTrigger().onTrue(new TurretSpin(m_driverController.getLeftTriggerAxis()));
    m_auxController.x().onTrue(new LEDColorChange());
    m_auxController.a().onTrue(new ClawGrab());
    m_auxController.y().whileTrue(new GamePieceTraking(tx));
  }




  private void configureNetworkTables(){
    NetworkTableInstance defaultNTinst = NetworkTableInstance.getDefault();
    NetworkTable lime = defaultNTinst.getTable("limelight");

    //NetworkTable lime = NetworkTableInstance.getDefault().getTable("limelight");
    //NetworkTableEntry tx = lime.getEntry("tx");

    dlbTopic_tx = lime.getDoubleTopic("tx");

    txHandle = defaultNTinst.addListener(
      dlbTopic_tx, 
      EnumSet.of(NetworkTableEvent.Kind.kValueAll), 
      event -> {
        tx.set(event.valueData.value.getDouble());
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
