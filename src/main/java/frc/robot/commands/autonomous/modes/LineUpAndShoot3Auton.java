/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands.autonomous.modes;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import edu.wpi.first.wpilibj2.command.WaitCommand;
import frc.robot.commands.TurnOffShooterCommand;
import frc.robot.commands.TurnOnShooterCommand;
import frc.robot.commands.autonomous.commands.SetDrivetrainSpeedForTime;
import frc.robot.commands.autonomous.commands.TurnOnIndexerForTime;
import frc.robot.subsystems.Drivebase;
import frc.robot.subsystems.Indexer;
import frc.robot.subsystems.Elevator;
import frc.robot.subsystems.Shooter;

// NOTE:  Consider using this command inline, rather than writing a subclass.  For more
// information, see:
// https://docs.wpilib.org/en/latest/docs/software/commandbased/convenience-features.html
public class LineUpAndShoot3Auton extends SequentialCommandGroup {
  private static double shooterWarmUpTime = 3.0,
                        timeBetweenShots = 1.0,
                        elevatorOnTime = 1.5,
                        elevatorSpeed = -0.65;
  /**
   * Creates a new LineUpAndShoot3.
   */
  public LineUpAndShoot3Auton(Drivebase drivebase, Shooter shooter, Indexer indexer, Elevator intake ) {
    // Drive, then shoot 3
    super(
      // drive up
      new SetDrivetrainSpeedForTime(.6, .6, 2.0, drivebase)
      // turn on shooter
      // new TurnOnShooterCommand(shooter),

      // 1st shot
      // new WaitCommand(shooterWarmUpTime),
      // new TurnOnIndexerForTime(indexerSpeed, indexerOnTime, indexer),

      // // 2nd shot
      // new SetElevatorSpeedForTime(elevatorSpeed, elevatorOnTime, intake),
      // new WaitCommand(timeBetweenShots),
      // new TurnOnIndexerForTime(indexerSpeed, indexerOnTime, indexer),

      // // 3rd shot
      // new SetElevatorSpeedForTime(elevatorSpeed, elevatorOnTime, intake),
      // new WaitCommand(timeBetweenShots),
      // new TurnOnIndexerForTime(indexerSpeed, indexerOnTime, indexer),

      // // turn off shooter
      // new TurnOffShooterCommand(shooter)
    );

    addRequirements(drivebase, shooter, indexer, intake);
  }
}
