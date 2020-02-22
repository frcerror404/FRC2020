/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import java.util.function.DoubleSupplier;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Drivebase;

// NOTE:  Consider using this command inline, rather than writing a subclass.  For more
// information, see:
// https://docs.wpilib.org/en/latest/docs/software/commandbased/convenience-features.html
public class SetDrivetrainSpeedCommand extends CommandBase {
  private final Drivebase m_Drivebase;
  private final DoubleSupplier m_leftAxis;
  private final DoubleSupplier m_rightAxis;

  public SetDrivetrainSpeedCommand(DoubleSupplier leftAxis, DoubleSupplier rightAxis, Drivebase drivebase) {
    m_Drivebase = drivebase;
    m_leftAxis = leftAxis;
    m_rightAxis = rightAxis;
    addRequirements(drivebase);
  }

  @Override
  public void execute() {
    m_Drivebase.manualControl(-m_leftAxis.getAsDouble(), -m_rightAxis.getAsDouble());
  }

   // Make this return true when this Command no longer needs to run execute()
   @Override
   public boolean isFinished() {
     return false; // Runs until interrupted
   }
}