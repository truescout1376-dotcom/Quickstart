package org.firstinspires.ftc.teamcode.teleop;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.hardware.gobilda.GoBildaPinpointDriver;
import org.firstinspires.ftc.teamcode.subsystems.DriveBaseSub;
import com.qualcomm.robotcore.util.ElapsedTime;


@TeleOp
public class MainDriveBlue extends OpMode {


    DriveBaseSub drive = new DriveBaseSub();
    private float strafe;
    private float forward;
    private float rotate;
    private float motorFlPower;
    private float motorFrPower;
    private float motorBlPower;
    private float motorBrPower;
    private ElapsedTime matchTimer = new ElapsedTime();
    private final double timeLimit = 120.0;


    float[] dbMotorPowerVals = new float[4];
    // 0 is FL, 1 is FR, 2 is BR, 3 is BL

    @Override
    public void init() {
        drive.init(hardwareMap);
    }

    @Override
    public void start() {
        matchTimer.reset();
    }

    @Override
    public void loop() {
        if (matchTimer.seconds() <= timeLimit) {

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

            // Timer
            telemetry.addData("Time Remaining", "%.1f sec", timeLimit - matchTimer.seconds());
            if (gamepad1.a) {
                matchTimer.reset();
            }

        } else {
            drive.stopDriveBase();
            telemetry.addData("Status", "Time is up");
            if (gamepad1.a) {
                matchTimer.reset();
            }
        }


    }
}


