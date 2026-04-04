package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.robotcore.external.navigation.AngleUnit;
import org.firstinspires.ftc.teamcode.Hardware.IMUs;

@TeleOp
public class ImuPractice extends OpMode{
    IMUs imu = new IMUs();
    double heading = imu.getHeading(AngleUnit.DEGREES);

    @Override
    public void init() {
        imu.init(hardwareMap);
    }

    @Override
    public void loop() {
        telemetry.addData("Heading", imu.getHeading(AngleUnit.DEGREES));
    }
}
