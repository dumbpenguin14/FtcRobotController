package org.firstinspires.ftc.teamcode.Practices.Hardware;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;

public class ArcadeDriveClass {
    private DcMotor frontLeft, rearLeft, frontRight, rearRight;

    public void init(HardwareMap hwMap) {
        frontLeft = hwMap.get(DcMotor.class, "motorName"); // all names must be same as
        frontRight = hwMap.get(DcMotor.class, "motorName"); // configured
        rearLeft = hwMap.get(DcMotor.class, "motorName");
        rearRight = hwMap.get(DcMotor.class, "motorName");

        frontLeft.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        frontRight.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        rearLeft.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        rearRight.setMode(DcMotor.RunMode.RUN_USING_ENCODER);

        frontLeft.setDirection(DcMotor.Direction.REVERSE);
        rearLeft.setDirection(DcMotor.Direction.REVERSE);
    }

    public void drive(double throttle, double spin) {
        double leftPower = throttle + spin;
        double rightPower = throttle + spin;
        double largest = Math.max(Math.abs(leftPower), Math.abs(rightPower));
        if (largest > 1) {
            leftPower /= largest;
            rightPower /= largest;
        }

        frontLeft.setPower(leftPower);
        rearLeft.setPower(leftPower);

        frontRight.setPower(rightPower);
        rearRight.setPower(rightPower);
    }
}
