package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

@TeleOp
public class LogicPrac extends OpMode {
    public void init() {

    }

    public void loop() {
        boolean aButton = gamepad1.a;
        double lx = gamepad1.left_stick_x;

        if (aButton) {
            telemetry.addData("A Button", "Pressed");
        }

        if (lx >= 0 ) {
            telemetry.addData("Left stick", ">=0");
        }
    }
}

/*
AND = &&  if(a > b && b > c) {--code--}
OR = ||  if(a > b || b > c) {--code--}
NOT = !  if (a != b) {--code--}
         if (!c) {--code--}
 */