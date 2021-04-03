/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

import frc.robot.Constants;


public class Shooter extends SubsystemBase {
  /**
   * Creates a new shooter.
   */
  private final CANSparkMax shooterMotor = new CANSparkMax(Constants.kShooter, MotorType.kBrushless);
  

  public Shooter() {

  }
  
  /**
   * @param ShooterSpeed the speed 0-1
   */
  public void setShooterSpeed(double shooterSpeed) {
    shooterMotor.set(shooterSpeed);
  }
  
  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
