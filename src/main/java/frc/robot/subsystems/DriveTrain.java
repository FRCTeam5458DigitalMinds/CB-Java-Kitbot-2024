// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

//Import libraries to use certain functions
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.motorcontrol.VictorSP;


public class DriveTrain extends SubsystemBase {
  // Sets drivetrain to Differential Drive (Allows it to be controlled by either arcade or tank drive)
  DifferentialDrive m_Frontdrive;
  DifferentialDrive m_Backdrive;
  public DriveTrain() {
    
    //Identifies the 4 motors depending on what motor controller ( Currently: Victor Sp)
    //@SuppressWarnings({ "resource" }) used to ignore the warning
    @SuppressWarnings({ "resource" })
    final VictorSP LeftFront = new VictorSP(0);
    
    @SuppressWarnings({ "resource" })
    final VictorSP LeftBack = new VictorSP(1);
    
    @SuppressWarnings({ "resource" })
    final VictorSP RightBack = new VictorSP(3);
    
    @SuppressWarnings({ "resource" })
    final VictorSP RightFront = new VictorSP(2);
    
    //Set what motors are going to be left or right (Used twice for both back and front)
    m_Frontdrive = new DifferentialDrive(LeftFront::set, RightFront::set);
    m_Backdrive  = new DifferentialDrive(LeftBack::set, RightBack::set);
    
    //Inverts the right side so the driving doesn't get screwed up
    RightFront.setInverted(true);
    RightBack.setInverted(true);
    
  }
  //Creates arcadeDrive method (Controls are on "RobotContainer.java")
  //uses arcade Drive method from the library, Differntail Drive, to make the motors move
  public void arcadeDrive(double moveSpeed, double rotateSpeed) {
    m_Frontdrive.arcadeDrive(moveSpeed, rotateSpeed);
    m_Backdrive.arcadeDrive(moveSpeed, rotateSpeed);
  }
}
