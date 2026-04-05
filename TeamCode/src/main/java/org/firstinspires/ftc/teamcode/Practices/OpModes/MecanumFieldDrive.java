package org.firstinspires.ftc.teamcode.Practices.OpModes;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;

import org.firstinspires.ftc.teamcode.Practices.Hardware.MecanumFieldClass;

public class MecanumFieldDrive extends OpMode {

    MecanumFieldClass drive = new MecanumFieldClass();
    double throttle, spin, strafe;

    @Override
    public void init() {
        drive.init(hardwareMap);
    }

    @Override
    public void loop() {
        throttle = gamepad1.left_stick_y;
        spin = gamepad1.right_stick_x;
        strafe = gamepad1.left_stick_x;

        drive.fieldDrive(throttle, spin, strafe);
    }
}
