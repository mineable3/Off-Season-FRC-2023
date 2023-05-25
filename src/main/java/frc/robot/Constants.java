// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

/**
 * The Constants class provides a convenient place for teams to hold robot-wide numerical or boolean
 * constants. This class should not be used for any other purpose. All constants should be declared
 * globally (i.e. public static). Do not put anything functional in this class.
 *
 * <p>It is advised to statically import this class (or one of its inner classes) wherever the
 * constants are needed, to reduce verbosity.
 */
public final class Constants {

  public static final int leftmotorID1 = 5;
  public static final int leftmotorID2 = 6;
  public static final int leftmotorID3 = 7;
  public static final int rightmotorID1 = 4;
  public static final int rightmotorID2 = 3;
  public static final int rightmotorID3 = 2;
  public static final int turretmotorRightID = 9;
  public static final int turretmotorLeftID = 8;
  public static final int intakeMotorID = 13;
  public static final int pigeonID = 0;
  public static final int armExtendMotorID = 10;
  public static final int armHeightMotor1ID = 11;
  public static final int armHeightMotor2ID = 12;
  public static final double driveSpeedMultiplier = .8;
  public static final double turretSpeedMultiplier = .2;
  public static final double driveTrainGearRatio = 15.87;
  


  public static class OperatorConstants {

    //joystick axis for arcade drive
    public static final int driveSpeed = 1;
    public static final int driveRotate = 4;

    public static final int driveLeft = 5;
    public static final int driveRight = 1;

    public static final int kDriverControllerPort = 0;
    public static final int kAuxControllerPort = 1;
  }
}
