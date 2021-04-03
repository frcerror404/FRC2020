/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.TalonSRXControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Indexer extends SubsystemBase {
  private final TalonSRX indexerWheel = new TalonSRX(55);
  /**
   * Creates a new Indexer.
   */
  public Indexer() {

  }

  public void setIndexerWheelSpeed(double indexerWheelSpeed) {
    indexerWheel.set(TalonSRXControlMode.PercentOutput, indexerWheelSpeed);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
