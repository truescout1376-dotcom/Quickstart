package org.firstinspires.ftc.teamcode.teleop;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;

import org.firstinspires.ftc.teamcode.subsystems.DriveBaseSub;

public class MainDriveBlue extends OpMode {

    DriveBaseSub drive = new DriveBaseSub();



    boolean gamepadAHeld = gamepad1.a;

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
    }
}