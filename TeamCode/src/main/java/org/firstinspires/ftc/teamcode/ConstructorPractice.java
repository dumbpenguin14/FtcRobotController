package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

@TeleOp
public class ConstructorPractice extends OpMode {
    ConstructorClass constructorClass = new ConstructorClass(0);

    @Override
    public void init() {
        constructorClass.setAngle(0);
    }

    @Override
    public void loop() {
        if (gamepad1.a) {
            constructorClass.changeAngle(+0.1);
        }
        else if (gamepad1.b) {
            constructorClass.changeAngle(-0.1);
        }
        else if (gamepad1.x); {
            constructorClass.resetAngle();
        }

        telemetry.addData("Angle", constructorClass.getHeading());

    }
}
