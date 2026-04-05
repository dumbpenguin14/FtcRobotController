package org.firstinspires.ftc.teamcode.Practices.Hardware;

import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;

public class Servos {
    private Servo servoPos;
    private CRServo servoRot;

    public void init(HardwareMap hwMap) {
        servoPos = hwMap.get(Servo.class, "servoName");
        servoRot = hwMap.get(CRServo.class, "CrServoName");
        servoPos.scaleRange(0.25, 0.75);
        servoRot.setDirection(CRServo.Direction.REVERSE);
    }

    public void setServoPos(double angle) {
        servoPos.setPosition(angle);
    }
    public void setServoRot(double power) {
        servoRot.setPower(power);
    }
}
