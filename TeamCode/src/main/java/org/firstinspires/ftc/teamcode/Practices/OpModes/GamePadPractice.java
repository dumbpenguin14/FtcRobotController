package org.firstinspires.ftc.teamcode.Practices.OpModes;

import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

@TeleOp
@Disabled
public class GamePadPractice  extends OpMode {
    @Override
    public void init() {

    }

    @Override
    public void loop() {
        telemetry.addData("lx", gamepad1.left_stick_x);
        telemetry.addData("ly", gamepad1.left_stick_y);
        telemetry.addData("a", gamepad1.a);
    }
}
