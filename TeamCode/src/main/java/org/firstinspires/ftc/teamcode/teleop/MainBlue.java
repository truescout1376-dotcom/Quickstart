package org.firstinspires.ftc.teamcode.teleop;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.subsystems.DriveBaseSub;
import com.qualcomm.robotcore.util.ElapsedTime;


@TeleOp
public class MainBlue extends OpMode {
    DriveBaseSub drive = new DriveBaseSub();
    private float strafe;
    private float forward;
    private float rotate;
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

            dbMotorPowerVals = drive.setMotorListAndNormalize(strafe, forward, rotate);
            drive.setDbMotorPowers(dbMotorPowerVals);

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


