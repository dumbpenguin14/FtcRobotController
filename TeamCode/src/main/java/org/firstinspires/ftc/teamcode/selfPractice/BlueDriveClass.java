package org.firstinspires.ftc.teamcode.selfPractice;

import com.qualcomm.hardware.rev.RevHubOrientationOnRobot;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.IMU;

import org.firstinspires.ftc.robotcore.external.navigation.AngleUnit;

public class BlueDriveClass {
    private DcMotor rightDrive, leftDrive;
    IMU imu;

    public void init(HardwareMap hwMap) {
        rightDrive = hwMap.get(DcMotor.class, "right_drive");
        leftDrive = hwMap.get(DcMotor.class, "left_drive");

        rightDrive.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        leftDrive.setMode(DcMotor.RunMode.RUN_USING_ENCODER);

        rightDrive.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        leftDrive.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);

        rightDrive.setDirection(DcMotor.Direction.REVERSE);

        imu = hwMap.get(IMU.class, "imu");
        RevHubOrientationOnRobot revOrientation = new RevHubOrientationOnRobot(
                RevHubOrientationOnRobot.LogoFacingDirection.RIGHT,
                RevHubOrientationOnRobot.UsbFacingDirection.UP
        );
        imu.initialize(new IMU.Parameters(revOrientation));

    }

    public double getHeading() {
        double angle = imu.getRobotYawPitchRollAngles().getYaw(AngleUnit.DEGREES);
        if (angle > 180) {
            angle -= 360;
        }
        else if (angle <= -180) {
            angle += 360;
        }

        return angle;
    }

    public void TankDrive(double throttle, double rotate) {
        double rightPower = throttle + rotate;
        double leftPower = throttle - rotate;
        double largest = Math.max(Math.abs(leftPower), Math.abs(rightPower));
        if (largest > 1) {
            rightPower /= largest;
            leftPower /= largest;
        }

        rightDrive.setPower(rightPower);
        leftDrive.setPower(leftPower);

    }
}
