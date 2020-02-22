/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;


import edu.wpi.first.wpilibj2.command.SubsystemBase;

import com.ctre.phoenix.motorcontrol.TalonSRXControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

public class Intake extends SubsystemBase {
  private final TalonSRX intakeMotor = new TalonSRX(21);
  /**
   * Creates a new Intake.
   */
  public Intake() {

  }

  public void turnOnIntake() {
    intakeMotor.set(TalonSRXControlMode.PercentOutput, -1.0);
  }

  public void turnOffIntake(){
    intakeMotor.set(TalonSRXControlMode.PercentOutput, 0);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
