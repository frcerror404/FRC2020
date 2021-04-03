/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;


import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

import com.ctre.phoenix.motorcontrol.InvertType;
import com.ctre.phoenix.motorcontrol.TalonSRXControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

public class Elevator extends SubsystemBase {
  private final TalonSRX m_Motor1 = new TalonSRX(Constants.kElevator1);
  private final TalonSRX m_Motor2 = new TalonSRX(Constants.kElevator2);
  /**
   * Creates a new Elevator.
   */
  public Elevator() {
    m_Motor2.follow(this.m_Motor1);
  } 

  public void turnOnElevator() {
    m_Motor1.set(TalonSRXControlMode.PercentOutput, -1);
  }

  public void reverseElevator() {
    m_Motor1.set(TalonSRXControlMode.PercentOutput, 0.5);
  }

  public void turnOffElevator(){
    m_Motor1.set(TalonSRXControlMode.PercentOutput, 0.0);

  }

  public void setElevatorSpeed(double speed) {
    m_Motor1.set(TalonSRXControlMode.PercentOutput, speed);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
