/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team3268.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.SampleRobot;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;

/**
 * This is a demo program showing the use of the RobotDrive class. The
 * SampleRobot class is the base of a robot application that will automatically
 * call your Autonomous and OperatorControl methods at the right time as
 * controlled by the switches on the driver station or the field controls.
 *
 * <p>The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the SampleRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the build.properties file in the
 * project.
 *
 * <p>WARNING: While it may look like a good choice to use for your code if
 * you're inexperienced, don't. Unless you know what you are doing, complex code
 * will be much more difficult under this system. Use IterativeRobot or
 * Command-Based instead if you're new.
 */
@SuppressWarnings("deprecation")
public class Robot extends SampleRobot {
	private static final String kDefaultAuto = "Default";
	private static final String kCustomAuto = "My Auto";

	private DifferentialDrive driveTrain;
	private Joystick stick;

	public Robot() {
		Talon driveLeftFront 	= new Talon(RobotMap.PWM_driveLeftFront);
		Talon driveLeftBack 	= new Talon(RobotMap.PWM_driveLeftBack);
		Talon driveRightFront	= new Talon(RobotMap.PWM_driveRightFront);
		Talon driveRightBack 	= new Talon(RobotMap.PWM_driveRightBack);
		SpeedControllerGroup driveLeft	= new SpeedControllerGroup(driveLeftFront, driveLeftBack);
		SpeedControllerGroup driveRight	= new SpeedControllerGroup(driveRightFront, driveRightBack);
		driveLeft.setInverted(true);
		driveRight.setInverted(true);
		driveTrain = new DifferentialDrive(driveLeft, driveRight);
		stick = new Joystick(0);
	}
	public void operatorControl() {
		driveTrain.setSafetyEnabled(true);
		while (isOperatorControl() && isEnabled()) {
			// Drive arcade style
			driveTrain.arcadeDrive(-stick.getY(), stick.getX());

			// The motors will be updated every 5ms
			Timer.delay(0.005);
		}
	}

	/**
	 * Runs during test mode.
	 */
	@Override
	public void test() {
	}
}
