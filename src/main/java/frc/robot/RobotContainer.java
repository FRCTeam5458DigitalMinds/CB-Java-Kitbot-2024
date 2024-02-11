// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import frc.robot.Constants.OperatorConstants;
import frc.robot.subsystems.DriveTrain;
import edu.wpi.first.wpilibj2.command.Commands;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj2.command.button.Trigger;

/**
 * This class is where the bulk of the robot should be declared. Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls). Instead, the structure of the robot (including
 * subsystems, commands, and trigger mappings) should be declared here.
 */
public class RobotContainer {
  // The robot's subsystems and commands are defined here...
  public static final DriveTrain m_drivetrain = new DriveTrain();
  // Replace with CommandPS4Controller or CommandJoystick if needed
  public final static CommandXboxController m_Xbox =
      new CommandXboxController(OperatorConstants.kDriverControllerPort);
  public final static Joystick m_Stick =
      new Joystick(1);


  /** The container for the robot. Contains subsystems, OI devices, and commands. */
  public RobotContainer() {
    // Configure the trigger bindings
    configureBindings();

    m_drivetrain.setDefaultCommand(
        // A split-stick arcade command, with forward/backward controlled by the left
        // hand, and turning controlled by the right.
        Commands.run(
            () ->
                m_drivetrain.arcadeDrive(
                    //m_driverController.getLeftY(), m_driverController.getRightX()),
                    m_Stick.getY(), m_Stick.getX()),
            m_drivetrain));
  }
  /**
   * Use this method to define your trigger->command mappings. Triggers can be created via the
   * {@link Trigger#Trigger(java.util.function.BooleanSupplier)} constructor with an arbitrary
   * predicate, or via the named factories in {@link
   * edu.wpi.first.wpilibj2.command.button.CommandGenericHID}'s subclasses for {@link
   * CommandXboxController Xbox}/{@link edu.wpi.first.wpilibj2.command.button.CommandPS4Controller
   * PS4} controllers or {@link edu.wpi.first.wpilibj2.command.button.CommandJoystick Flight
   * joysticks}.
   */
  
  private void configureBindings() {
  // Schedule `ExampleCommand` when `exampleCondition` changes to `true`
     
       // A split-stick arcade command, with forward/backward controlled by the left
       // hand, and turning controlled by the right.
  }
}
