package org.firstinspires.ftc.teamcode.teleop;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.subsystems.DriveBaseSub;


@TeleOp
public class MainDriveBlue extends OpMode {


    DriveBaseSub drive = new DriveBaseSub();
    public float axial;
    public float lateral;
    public float yaw;
    public float motorFlPower;
    public float motorFrPower;
    public float motorBlPower;
    public float motorBrPower;

    float[] dbMotorPowerVals = new float[4];
    // 0 is FL, 1 is FR, 2 is BR, 3 is BL

    @Override
    public void init() {
        drive.init(hardwareMap);
    }


    @Override
    public void loop() {

        axial = -gamepad1.left_stick_y;
        lateral = gamepad1.left_stick_x;
        yaw = gamepad1.right_stick_x;

        dbMotorPowerVals[0] = (axial + lateral) + yaw; // FL
        dbMotorPowerVals[1] = (axial - lateral) - yaw; // FR
        dbMotorPowerVals[2] = (axial + lateral) - yaw; // BR
        dbMotorPowerVals[3] = (axial - lateral) + yaw; // BL
        dbMotorPowerVals = drive.getNormalizationList(dbMotorPowerVals);
        drive.setDbMotorPowers(dbMotorPowerVals[0], dbMotorPowerVals[1],
                dbMotorPowerVals[2], dbMotorPowerVals[3]);

    }
}