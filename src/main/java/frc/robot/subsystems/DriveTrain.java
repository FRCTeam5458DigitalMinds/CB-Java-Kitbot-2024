// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.motorcontrol.VictorSP;


public class DriveTrain extends SubsystemBase {
  /** Creates a new ExampleSubsystem. */
  DifferentialDrive m_Frontdrive;
  DifferentialDrive m_Backdrive;
  public DriveTrain() {
    final VictorSP LeftFront = new VictorSP(0);
    final VictorSP LeftBack = new VictorSP(1);

    final VictorSP RightBack = new VictorSP(3);
    final VictorSP RightFront = new VictorSP(2);
    
    
    m_Frontdrive = new DifferentialDrive(LeftFront::set, RightFront::set);
    m_Backdrive  = new DifferentialDrive(LeftBack::set, RightBack::set);
    RightFront.setInverted(true);
    RightBack.setInverted(true);
    
  }
  public void arcadeDrive(double moveSpeed, double rotateSpeed) {
    m_Frontdrive.arcadeDrive(moveSpeed, rotateSpeed);
    m_Backdrive.arcadeDrive(moveSpeed, rotateSpeed);
  }
}
