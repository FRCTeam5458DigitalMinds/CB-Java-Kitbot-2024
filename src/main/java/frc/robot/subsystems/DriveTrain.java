// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.Command;
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
    
    
    m_Frontdrive = new DifferentialDrive(LeftFront, RightFront);
    m_Backdrive = new DifferentialDrive(LeftBack, RightBack);

    }
    public void arcadeDrive(double moveSpeed, double rotateSpeed) {
      m_Frontdrive.arcadeDrive(moveSpeed, rotateSpeed);
      m_Backdrive.arcadeDrive(moveSpeed, rotateSpeed);
    }
    /**
     * Example command factory method.
     *
     * @return a command
     */
    public Command exampleMethodCommand() {
      // Inline construction of command goes here.
      // Subsystem::RunOnce implicitly requires `this` subsystem.
      return runOnce(
          () -> {
            /* one-time action goes here */
          });
    }

    /**
     * An example method querying a boolean state of the subsystem (for example, a digital sensor).
     *
     * @return value of some boolean subsystem state, such as a digital sensor.
     */
    public boolean exampleCondition() {
      // Query some boolean state, such as a digital sensor.
      return false;
    }

    @Override
    public void periodic() {
      // This method will be called once per scheduler run
    }

    @Override
    public void simulationPeriodic() {
      // This method will be called once per scheduler run during simulation
    }
}
