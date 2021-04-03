/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMax.IdleMode;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class Drivebase extends SubsystemBase {
  private final CANSparkMax leftMaster = new CANSparkMax(Constants.klDT1, MotorType.kBrushless);
  private final CANSparkMax leftSlave = new CANSparkMax(Constants.klDT2, MotorType.kBrushless);

  private final CANSparkMax rightMaster = new CANSparkMax(Constants.krDT3, MotorType.kBrushless);
  private final CANSparkMax rightSlave = new CANSparkMax(Constants.krDT4, MotorType.kBrushless);
  private final DifferentialDrive drivetrain = new DifferentialDrive(leftMaster, rightMaster);

  // drive train speed, set to 0.x for X% speed
  private final double drivetrainMultiplier = 1.0;

  /**
   * Creates a new Drivebase.
   */
  public Drivebase() {
    leftMaster.setIdleMode(IdleMode.kBrake);
    leftSlave.setIdleMode(IdleMode.kBrake);
    rightMaster.setIdleMode(IdleMode.kBrake);
    rightSlave.setIdleMode(IdleMode.kBrake);

    double rampRate = .5;
    rightMaster.setOpenLoopRampRate(rampRate);
    rightSlave.setOpenLoopRampRate(rampRate);
    leftMaster.setOpenLoopRampRate(rampRate);
    leftSlave.setOpenLoopRampRate(rampRate);

    drivetrain.setMaxOutput(drivetrainMultiplier);

    drivetrain.setRightSideInverted(false);
    
    leftSlave.follow(leftMaster);
    rightSlave.follow(rightMaster);

    rightMaster.setInverted(true);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

  public void manualControl(double rawAxis, double rawAxis2) {
    System.out.println(String.format("Drivetrain raw: X %.2f Y %.2f", rawAxis, rawAxis2));
    System.out.println(String.format("RightMaster: %.2f, LeftMaster: %.2f", rightMaster.getAppliedOutput(), leftMaster.getAppliedOutput()));
    
    //leftMaster.set(rawAxis * drivetrainMultiplier);
    //rightMaster.set(rawAxis2 * drivetrainMultiplier);
    
    if(Constants.isCurvatureDrive) {
      drivetrain.curvatureDrive(rawAxis, rawAxis2, false);
    } else {
      drivetrain.tankDrive(rawAxis * drivetrainMultiplier, rawAxis2);
    }
    
  }

  
}
