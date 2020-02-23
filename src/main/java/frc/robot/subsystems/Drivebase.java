/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.SparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Drivebase extends SubsystemBase {
  private final CANSparkMax leftMaster = new CANSparkMax(10, MotorType.kBrushless);
  private final CANSparkMax rightSlave = new CANSparkMax(12, MotorType.kBrushless);
  private final CANSparkMax leftSlave = new CANSparkMax(11, MotorType.kBrushless);
  private final CANSparkMax rightMaster = new CANSparkMax(13, MotorType.kBrushless);
  private final DifferentialDrive drivetrain = new DifferentialDrive(leftMaster, rightMaster);


  // drive train speed, set to 0.x for X% speed
  private final double drivetrainMultiplier = 1.0;

  /**
   * Creates a new Drivebase.
   */
  public Drivebase() {
    leftSlave.follow(leftMaster);
    rightSlave.follow(rightMaster);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

  public void manualControl(double rawAxis, double rawAxis2) {
    drivetrain.tankDrive(rawAxis * drivetrainMultiplier, rawAxis2 * drivetrainMultiplier);
  }

  
}
