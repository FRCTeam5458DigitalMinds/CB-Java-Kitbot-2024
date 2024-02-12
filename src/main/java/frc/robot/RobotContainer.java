// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

//Uses libraries from the other "docs?" and wpilib
import frc.robot.Constants.OperatorConstants;
import frc.robot.subsystems.DriveTrain;
import edu.wpi.first.wpilibj2.command.RunCommand;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;
import edu.wpi.first.wpilibj2.command.button.CommandJoystick;
import edu.wpi.first.wpilibj2.command.button.Trigger;


/**
 * This class is where the bulk of the robot should be declared. Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls). Instead, the structure of the robot (including
 * subsystems, commands, and trigger mappings) should be declared here.
 */
public class RobotContainer {
  //Identifies drivetrain from "DriveTrain.java"
  public static final DriveTrain m_drivetrain = new DriveTrain();
  /*Identifies controllers
  *Controllers are on different ports 
  If for somereason it changes, change the port number based on drive station*/
  public final static CommandXboxController m_Xbox =
      new CommandXboxController(OperatorConstants.kDriverControllerPort);
  public final static CommandJoystick m_Stick =
      new CommandJoystick(1);


  /** The container for the robot. Contains subsystems, OI devices, and commands. */
  public RobotContainer() {
    // Configure the trigger bindings
    configureBindings();
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
    //Turns command into default command
    m_drivetrain.setDefaultCommand(
        //Stick: Foward & Back to move;  Left & Right to turn
        //Controller: Left stick to move forward & back; Right stick to turn
        new RunCommand(
            () ->
              //Uses command from "DriveTrain.java"
                m_drivetrain.arcadeDrive(
                  //Change depending on what controller you are using
                    //m_driverController.getLeftY(), m_driverController.getRightX()),
                    m_Stick.getY(), m_Stick.getX()),
            m_drivetrain));
  }
}
