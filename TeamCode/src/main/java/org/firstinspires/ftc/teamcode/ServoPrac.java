package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.teamcode.Hardware.Servos;

public class ServoPrac extends OpMode{
    Servos servos = new Servos();

    @Override
    public void init() {
        servos.init(hardwareMap);
    }

    @Override
    public void loop() {
        if (gamepad1.a) {
            servos.setServoPos(1);
        }
        else {
            servos.setServoPos(0);
        }

        if (gamepad1.b) {
            servos.setServoRot(1);
        }
        else {
            servos.setServoRot(0);
        }
    }
}
