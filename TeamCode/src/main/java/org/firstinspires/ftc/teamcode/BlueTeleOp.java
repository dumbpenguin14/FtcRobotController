package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.selfPractice.ArmClass;
import org.firstinspires.ftc.teamcode.selfPractice.BlueDriveClass;

@TeleOp
public class BlueTeleOp extends OpMode {
    ArmClass arm = new ArmClass();
    BlueDriveClass drive = new BlueDriveClass();

    @Override
    public void init() {
        arm.init(hardwareMap);
        drive.init(hardwareMap);
    }

    @Override
    public void loop() {
        drive.TankDrive(-gamepad1.left_stick_y, gamepad1.right_stick_x);
        boolean claw;
        arm.raiseArm(gamepad1.right_trigger);
        if (gamepad1.right_bumper) {
            claw = true;
        }
        else {
            claw = false;
        }
        arm.closeClaw(claw);
        telemetry.addData("Heading", drive.getHeading());
        telemetry.addData("ClawOpen", claw);
        telemetry.addData("Forward", gamepad1.left_stick_y);
        telemetry.addData("Rotation", gamepad1.right_stick_x);
    }
}
