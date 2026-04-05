package org.firstinspires.ftc.teamcode.Practices.OpModes;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;

import org.firstinspires.ftc.teamcode.Practices.Hardware.Motor;

@TeleOp
public class DCMotorPractice extends OpMode {

    Motor motor = new Motor();

    @Override
    public void init() {
        motor.init(hardwareMap);
    }

    @Override
    public void loop() {
        motor.setMotorSpeed(gamepad1.left_stick_y);
        if (gamepad1.a) {
            motor.changeZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        }
        else if (gamepad1.b) {
            motor.changeZeroPowerBehavior(DcMotor.ZeroPowerBehavior.FLOAT);
        }

        if (gamepad1.x) {
            motor.changeDirection(DcMotor.Direction.FORWARD);
        }
        else if (gamepad1.y) {
            motor.changeDirection(DcMotor.Direction.REVERSE);
        }

        telemetry.addData("Motor revs", motor.getMotorRevs());
    }
}

