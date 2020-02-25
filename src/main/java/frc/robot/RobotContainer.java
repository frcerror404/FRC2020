/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.GenericHID.Hand;

import frc.robot.commands.ExampleCommand;
import frc.robot.commands.SetDrivetrainSpeedCommand;
import frc.robot.commands.TurnOffIndexer;
import frc.robot.commands.TurnOffIntakeCommand;
import frc.robot.commands.TurnOffShooterCommand;
import frc.robot.commands.TurnOnIndexer;
import frc.robot.commands.TurnOnIntakeCommand;
import frc.robot.commands.TurnOnShooterCommand;
import frc.robot.commands.TurnOffShooterCommand;

import frc.robot.subsystems.Drivebase;
import frc.robot.subsystems.ExampleSubsystem;
import frc.robot.subsystems.Intake;
import frc.robot.subsystems.Shooter;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.button.Button;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import edu.wpi.first.wpilibj.XboxController.*;

/**
 * This class is where the bulk of the robot should be declared.  Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls).  Instead, the structure of the robot
 * (including subsystems, commands, and button mappings) should be declared here.
 */
public class RobotContainer {
  // The robot's subsystems and commands are defined here...
  private final Intake m_intake = new Intake();
  private final Shooter m_shooter = new Shooter();
  private final Drivebase m_Drivebase = new Drivebase();

  //private final ExampleCommand m_autoCommand = new ExampleCommand(m_exampleSubsystem);
  private final XboxController joy0 = new XboxController(0);
  private final XboxController joy1 = new XboxController(1);




  /**
   * The container for the robot.  Contains subsystems, OI devices, and commands.
   */
  public RobotContainer() {
    // Configure the button bindings
    configureButtonBindings();
  }

  /**
   * Use this method to define your button->command mappings.  Buttons can be created by
   * instantiating a {@link GenericHID} or one of its subclasses ({@link
   * edu.wpi.first.wpilibj.Joystick} or {@link XboxController}), and then passing it to a
   * {@link edu.wpi.first.wpilibj2.command.button.JoystickButton}.
   */
  private void configureButtonBindings() {
    JoystickButton rightBumper = new JoystickButton(joy1, 6);
    JoystickButton leftBumper = new JoystickButton(joy1, 5);
    JoystickButton aButton = new JoystickButton(joy1, 1);

    rightBumper
      .whenPressed(new TurnOnIntakeCommand(m_intake))
      .whenReleased(new TurnOffIntakeCommand(m_intake));

    leftBumper
      .whenPressed(new TurnOnShooterCommand(m_shooter))
      .whenReleased(new TurnOffShooterCommand(m_shooter));

    aButton
      .whenPressed(new TurnOnIndexer(m_shooter))
      .whenReleased(new TurnOffIndexer(m_shooter));


      

    m_Drivebase.setDefaultCommand(
      new SetDrivetrainSpeedCommand(
        () -> joy0.getY(Hand.kLeft),
        () -> joy0.getY(Hand.kRight),
         m_Drivebase)
    );
  }

 


  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */
  // public Command getAutonomousCommand() {
  //   // An ExampleCommand will run in autonomous
  //   return m_autoCommand;
  // }
}
