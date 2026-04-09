package org.firstinspires.ftc.teamcode.selfPractice;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;

public class ArmClass {
    private DcMotor armMotor;
    private Servo armClaw;

    public void init(HardwareMap hwMap) {
        armMotor = hwMap.get(DcMotor.class, "arm_motor");
        armClaw = hwMap.get(Servo.class, "arm_claw");

        armMotor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        armMotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        armMotor.setDirection(DcMotor.Direction.FORWARD);
    }

    public void raiseArm(double power) {
        if (power > 1) {
            power = 1;
        }
        else if (power < -1) {
            power = -1;
        }
        armMotor.setPower(power);
    }

    public void closeClaw(boolean clawClosed) {
        if (clawClosed) {
            armClaw.setPosition(1.0);
        }
        else {
            armClaw.setPosition(0);
        }
    }
}
