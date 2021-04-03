/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.GenericHID.Hand;
import frc.robot.commands.DualHandedWinchSpeed;
import frc.robot.commands.ReverseElevator;
import frc.robot.commands.RewindWinch;
import frc.robot.commands.SetDrivetrainSpeedCommand;
import frc.robot.commands.TurnOffIntake;
import frc.robot.commands.TurnOffIntakeCommand;
import frc.robot.commands.TurnOffShooterCommand;
import frc.robot.commands.TurnOnIntake;
import frc.robot.commands.TurnOnElevatorCommand;
import frc.robot.commands.TurnOnShooterCommand;
import frc.robot.subsystems.Climber;
import frc.robot.subsystems.Drivebase;
import frc.robot.subsystems.Indexer;
import frc.robot.subsystems.Intake;
import frc.robot.subsystems.Elevator;
import frc.robot.subsystems.Shooter;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;

/**
 * This class is where the bulk of the robot should be declared. Since
 * Command-based is a "declarative" paradigm, very little robot logic should
 * actually be handled in the {@link Robot} periodic methods (other than the
 * scheduler calls). Instead, the structure of the robot (including subsystems,
 * commands, and button mappings) should be declared here.
 */
public class RobotContainer {
  // The robot's subsystems and commands are defined here...
  public final Elevator elevator = new Elevator();
  public final Shooter shooter = new Shooter();
  public final Drivebase drivebase = new Drivebase();
  //private final Climber m_climber = new Climber();
  public final Intake intake = new Intake();


  // private final ExampleCommand m_autoCommand = new
  // ExampleCommand(m_exampleSubsystem);
  private final XboxController joy0 = new XboxController(0);
  private final XboxController joy1 = new XboxController(1);

  /**
   * The container for the robot. Contains subsystems, OI devices, and commands.
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
    JoystickButton P1_rightBumper = new JoystickButton(joy1, XboxController.Button.kBumperRight.value);
    JoystickButton P1_leftBumper = new JoystickButton(joy1, XboxController.Button.kBumperLeft.value);
    JoystickButton P1_aButton = new JoystickButton(joy1, XboxController.Button.kA.value);
    JoystickButton P1_yButton = new JoystickButton(joy1, XboxController.Button.kY.value);
    JoystickButton P0_rightBumper = new JoystickButton(joy0, XboxController.Button.kBumperRight.value);
    
    
    /**
     * Press Start and Back on both controllers to reset
    */  
    // new JoystickButton(joy1, XboxController.Button.kStart.value)
    // .and(new JoystickButton(joy1, XboxController.Button.kBack.value))
    // .and(new JoystickButton(joy0, XboxController.Button.kStart.value))
    // .and(new JoystickButton(joy0, XboxController.Button.kBack.value))
    // .whileActiveContinuous(new RewindWinch(m_climber));
    



    P1_rightBumper
      .whenPressed(new TurnOnElevatorCommand(elevator))
      .whenReleased(new TurnOffIntakeCommand(elevator));

    P1_leftBumper
      .whenPressed(new TurnOnShooterCommand(shooter))
      .whenReleased(new TurnOffShooterCommand(shooter));

    P1_aButton
      .whenPressed(new TurnOnIntake(intake))
      .whenReleased(new TurnOffIntake(intake));

    P1_yButton
      .whenPressed(new ReverseElevator(elevator))
      .whenReleased(new TurnOffIntakeCommand(elevator));

    


      

    if(Constants.isCurvatureDrive) {
      drivebase.setDefaultCommand(
        new SetDrivetrainSpeedCommand(
          () -> joy0.getY(Hand.kLeft),
          () -> joy0.getX(Hand.kRight),
          () -> P0_rightBumper.get(),
          drivebase));
  
    } else {
      drivebase.setDefaultCommand(
        new SetDrivetrainSpeedCommand(
          () -> joy0.getY(Hand.kLeft),
          () -> joy0.getY(Hand.kRight),
          () -> P0_rightBumper.get(),
          drivebase));
  
    }


      // m_climber.setDefaultCommand(
      // new DualHandedWinchSpeed(
      //   () -> joy0.getTriggerAxis(Hand.kLeft), 
      //   () -> joy0.getTriggerAxis(Hand.kRight),
      //   m_climber));

  
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
