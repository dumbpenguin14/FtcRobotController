package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

@TeleOp
@Disabled
public class VarPractice extends OpMode {

    @Override
    public void init() {
        int teamNumber = 27253;
        double flywheelPower = 0.95;
        boolean intakeActive = true;
        String TeamName = "May Contain Small Parts";

        telemetry.addData("Team #", teamNumber);
        telemetry.addData("Flywheel pwr", flywheelPower);
        telemetry.addData("Intaking", intakeActive);
        telemetry.addData("Team Name", TeamName);


    }

    @Override
    public void loop() {

    }
}
