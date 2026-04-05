package org.firstinspires.ftc.teamcode.Practices.Hardware;

import com.qualcomm.hardware.rev.RevHubOrientationOnRobot;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.IMU;

import org.firstinspires.ftc.robotcore.external.navigation.AngleUnit;

public class MecanumFieldClass {
    private DcMotor frontLeft, frontRight, rearLeft, rearRight;
    IMU imu;

    public void init(HardwareMap hwMap) {
        frontLeft = hwMap.get(DcMotor.class, "motorName"); // name must be same as
        rearLeft = hwMap.get(DcMotor.class, "motorName"); // configured
        frontRight = hwMap.get(DcMotor.class, "motorName");
        rearRight = hwMap.get(DcMotor.class, "motorName");

        frontLeft.setDirection(DcMotor.Direction.REVERSE);
        rearLeft.setDirection(DcMotor.Direction.REVERSE);

        frontRight.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        rearRight.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        frontLeft.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        rearLeft.setMode(DcMotor.RunMode.RUN_USING_ENCODER);

        imu = hwMap.get(IMU.class, "imu");
        RevHubOrientationOnRobot revOrientation = new RevHubOrientationOnRobot(
                RevHubOrientationOnRobot.LogoFacingDirection.UP,
                RevHubOrientationOnRobot.UsbFacingDirection.FORWARD
        );
        imu.initialize(new IMU.Parameters(revOrientation));
    }

    public void drive(double throttle, double spin, double strafe) {
        double frontLeftPwr = throttle + strafe + spin;
        double backLeftPwr = throttle - strafe + spin;
        double frontRightPwr = throttle - strafe - spin;
        double backRightPwr = throttle + strafe - spin;
        double maxPwr = 1.0;
        double maxSpeed = 1.0;

        maxPwr = Math.max(maxPwr, Math.abs(frontLeftPwr));
        maxPwr = Math.max(maxPwr, Math.abs(backLeftPwr));
        maxPwr = Math.max(maxPwr, Math.abs(frontRightPwr));
        maxPwr = Math.max(maxPwr, Math.abs(backRightPwr));

        frontLeft.setPower(maxSpeed * (frontLeftPwr / maxPwr));
        rearLeft.setPower(maxSpeed * (backLeftPwr / maxPwr));
        frontRight.setPower(maxSpeed * (frontRightPwr / maxPwr));
        rearLeft.setPower(maxSpeed * (backRightPwr / maxPwr));
    }

    public void fieldDrive(double throttle, double spin, double strafe) {
        double theta = Math.atan2(throttle, strafe);
        double r = Math.hypot(strafe, throttle);

        theta = AngleUnit.normalizeRadians(theta -
                imu.getRobotYawPitchRollAngles().getYaw(AngleUnit.RADIANS));

        double newThrottle = r * Math.sin(theta);
        double newStrafe = r * Math.cos(theta);

        this.drive(newThrottle, newStrafe, spin);
    }
}
