package org.firstinspires.ftc.teamcode.teleop;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.subsystems.DriveBaseSub;


@TeleOp
public class MainDriveBlue extends OpMode {


    DriveBaseSub drive = new DriveBaseSub();
    public float strafe;
    public float forward;
    public float rotate;
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

        strafe = gamepad1.left_stick_y;
        forward = -gamepad1.left_stick_x;
        rotate = -gamepad1.right_stick_x;

        dbMotorPowerVals[0] = (strafe + forward) + rotate; // FL
        dbMotorPowerVals[1] = (strafe - forward) - rotate; // FR
        dbMotorPowerVals[2] = (strafe + forward) - rotate; // BR
        dbMotorPowerVals[3] = (strafe - forward) + rotate; // BL
        dbMotorPowerVals = drive.getNormalizationList(dbMotorPowerVals);
        drive.setDbMotorPowers(dbMotorPowerVals[0], // FL
                                -dbMotorPowerVals[1], // FR
                                dbMotorPowerVals[2],  // BR
                                -dbMotorPowerVals[3]); // BL

        // Left: left motors ccw, right motors cw
        // Right: left motor cw, right motor ccw


    }
}


