/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.InstantCommand;
import frc.robot.subsystems.Climber;


public class DualHandedWinchSpeed extends InstantCommand {
  private double leftHandSpeed = 0.0;
  private double rightHandSpeed = 0.0;
  private final Climber climber;


  /**
   * This command takes in both of the triggers. Each trigger will contribute to half
   * of the winch's speed. Any value under 15% will be ignored and set to 0. This is to
   * have finer control over the winch speed, since the climber needs to move slowly
   * sometimes (example: maximizing the extended height), and faster other times (climbing)
   * 
   * @param leftHandSpeed
   * @param rightHandSpeed
   * @param climber
   */
  public DualHandedWinchSpeed(double leftHandSpeed, double rightHandSpeed, Climber climber) {
    this.leftHandSpeed = leftHandSpeed;
    this.rightHandSpeed = rightHandSpeed;
    this.climber = climber;
    addRequirements(climber);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    double finalSpeed = leftHandSpeed * 0.5 + rightHandSpeed * 0.5; 

    if(finalSpeed < .15) {
      finalSpeed = 0.0;
    }

    climber.setWinchSpeed(finalSpeed);
  }
}
