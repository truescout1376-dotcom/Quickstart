package org.firstinspires.ftc.teamcode.teleop;

import static org.firstinspires.ftc.robotcore.external.BlocksOpModeCompanion.gamepad1;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.subsystems.DriveBaseSub;

@TeleOp
public abstract class MainDriveBlue extends OpMode {

    DriveBaseSub drive = new DriveBaseSub();


    @Override
    public void init() {
        drive.init(hardwareMap);
    }

    @Override
    public void start() {
        // TODO
    }

    @Override
    public void loop() {
        drive.setMotorSpeed(0.1);

        // reset buttons
        boolean gamepadAHeld = gamepad1.a;
        boolean gamepadBHeld = gamepad1.b;
        boolean gamepadXHeld = gamepad1.x;
        boolean gamepadYHeld = gamepad1.y;

        double forwardStick = gamepad1.left_stick_y;
        double strafeStick = gamepad1.left_stick_x;
        double turnStick = gamepad1.right_stick_x;


    }
}