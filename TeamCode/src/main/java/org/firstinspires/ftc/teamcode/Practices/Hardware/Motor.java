package org.firstinspires.ftc.teamcode.Practices.Hardware;

import static org.firstinspires.ftc.robotcore.external.BlocksOpModeCompanion.gamepad1;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.HardwareMap;

public class Motor {
    private DcMotor motor;
    private double ticksPerRev; //#Ticks per revolution
    public void init(HardwareMap hwMap) {
        //other code

        //motor code
        motor = hwMap.get(DcMotor.class, "motorName"); //motor name must be exactly
                                                                  // what it is in config
        motor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        ticksPerRev = motor.getMotorType().getTicksPerRev();
        motor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        motor.setDirection(DcMotor.Direction.FORWARD);

    }

    public void setMotorSpeed(double motorSpeed) {
        motor.setPower(motorSpeed);
    }

    public double getMotorRevs() {
        return motor.getCurrentPosition() / ticksPerRev;
    }

    public void changeZeroPowerBehavior(DcMotor.ZeroPowerBehavior zeroBehavior) {
        motor.setZeroPowerBehavior(zeroBehavior);
    }

    public void changeDirection(DcMotorSimple.Direction motorDirection) {
        motor.setDirection(motorDirection);
    }
}
