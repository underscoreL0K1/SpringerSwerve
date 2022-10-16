// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.InstantCommand;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;

import frc.robot.commands.*;
import frc.robot.subsystems.*;

/**
 * This class is where the bulk of the robot should be declared. Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls). Instead, the structure of the robot (including
 * subsystems, commands, and button mappings) should be declared here.
 */
public class RobotContainer {

  private final XboxController driver = new XboxController(0);

  private final int translationAxis = XboxController.Axis.kLeftY.value;
  private final int strafeAxis = XboxController.Axis.kLeftX.value;
  private final int rotationAxis = XboxController.Axis.kRightX.value;
  private final JoystickButton zeroGyro = new JoystickButton(driver, XboxController.Button.kY.value);

  private final Swerve s_Swerve = new Swerve();


  /** The container for the robot. Contains subsystems, OI devices, and commands. */
  public RobotContainer() {
    boolean fieldRelative = true;
    boolean openLoop = false;
    s_Swerve.setDefaultCommand(new Drive(s_Swerve, driver, translationAxis, strafeAxis, rotationAxis, fieldRelative, openLoop));

    configureButtonBindings();
  }

  private void configureButtonBindings() {
    /* Driver Buttons */
    zeroGyro.whenPressed(new InstantCommand(() -> s_Swerve.zeroGyro()));
  }

  public Command getAutonomousCommand() {
    return null;
  }

}
