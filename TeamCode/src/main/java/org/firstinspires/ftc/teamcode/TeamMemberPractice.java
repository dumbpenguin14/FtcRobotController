package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

@TeleOp
public class TeamMemberPractice extends OpMode {

    public void init() {

    }

    public double squareWithSign(double input) {
        double output = input * input;

        if (input < 0) {
            output += -1;
        }

        return output;
    }

    public void loop() {
        double yAxis = gamepad1.left_stick_y;
        telemetry.addData("Y axis", yAxis);
        telemetry.addData("Y axis squared", squareWithSign(yAxis));
    }
}
