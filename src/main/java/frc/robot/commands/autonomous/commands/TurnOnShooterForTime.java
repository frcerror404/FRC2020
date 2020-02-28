/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands.autonomous.commands;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Shooter;

public class TurnOnShooterForTime extends CommandBase {
  private final Shooter shooter;
  private final double durationS, shooterSpeed;
  private double startTime;

  /**
   * Creates a new TurnOnShooterForTime.
   */
  public TurnOnShooterForTime(double shooterSpeed, double durationS, Shooter shooter) {
    this.shooter = shooter;
    this.durationS = durationS;
    this.shooterSpeed = shooterSpeed;

    addRequirements(shooter);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    startTime = Timer.getFPGATimestamp();
    shooter.setShooterSpeed(shooterSpeed);
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    shooter.setShooterSpeed(0.0);
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return Timer.getFPGATimestamp() - startTime >= durationS;
  }
}
