package org.firstinspires.ftc.teamcode.subsystems;

import static org.firstinspires.ftc.robotcore.external.BlocksOpModeCompanion.telemetry;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.teamcode.constants.DriveBaseConstants;
import org.firstinspires.ftc.teamcode.pedro.procedures.PinpointTuner;
import org.firstinspires.ftc.teamcode.teleop.MainDriveBlue; // maybe not necessary
import com.qualcomm.hardware.gobilda.GoBildaPinpointDriver;
import org.firstinspires.ftc.teamcode.pedro.procedures.PinpointTuner;
public class DriveBaseSub {
    // TODO

    // this file may not be exclusively for setting up the drive base but also for running it
    // similar to 33748 Decode w/ the subsystems?

    private DcMotor driveMotorFL, driveMotorFR, driveMotorBL, driveMotorBR;
    private GoBildaPinpointDriver pinpoint;

    public void init(HardwareMap hardwareMap) {
        // hardware mapping
        driveMotorFL = hardwareMap.get(DcMotor.class, DriveBaseConstants.DB_MOTOR_FL);
        driveMotorFR = hardwareMap.get(DcMotor.class, DriveBaseConstants.DB_MOTOR_FR);
        driveMotorBL = hardwareMap.get(DcMotor.class, DriveBaseConstants.DB_MOTOR_BL);
        driveMotorBR = hardwareMap.get(DcMotor.class, DriveBaseConstants.DB_MOTOR_BR);

        // direction setting
        driveMotorFL.setDirection(DriveBaseConstants.LEFT_DIR);
        driveMotorBL.setDirection(DriveBaseConstants.LEFT_DIR);
        driveMotorFR.setDirection(DriveBaseConstants.RIGHT_DIR);
        driveMotorBR.setDirection(DriveBaseConstants.RIGHT_DIR);

        // Brake mode
        driveMotorFL.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        driveMotorFR.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        driveMotorBR.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        driveMotorBL.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);

        // Pinpoint/odometry
        pinpoint = hardwareMap.get(GoBildaPinpointDriver.class, DriveBaseConstants.DB_PINPOINT);

    }

    public void stopDriveBase() {
        driveMotorFL.setPower(0);
        driveMotorFR.setPower(0);
        driveMotorBL.setPower(0);
        driveMotorBR.setPower(0);
    }

    public void driveForward(double speed) {
        driveMotorFL.setPower(-speed); // ccw
        driveMotorBL.setPower(speed); // ccw
        driveMotorFR.setPower(speed); // cw
        driveMotorBR.setPower(-speed); // cw
    }

    public void setDbMotorPowers(float FL, float FR, float BR, float BL) {
        driveMotorFL.setPower(FL);
        driveMotorFR.setPower(FR);
        driveMotorBR.setPower(BR);
        driveMotorBL.setPower(BL);
    }

    /**
     This normalization thing is because the way we calculate the motor power is based on 4 equations
     that can be greater than 1 or -1. Values beyond that get clipped down to 1 or -1 and screw up
     the motion that the driver desires. Normalization proportionally puts those down to one
     */
    public float[] getNormalizationList(float[] list) {
        float maximum = listMax(list);
        if (maximum > 1) {
            for (int i = 0; i <= 3; i++) {
                list[i] = list[i] / maximum;
            }
        }
        // This will give you an array of normalized speeds for the motors, i.e. GIGA USEFUL
        return list;
    }

    public static float listMax(float[] list) {
        float maximum = 0;
        for (int i = 0; i <= 3; i++) {
            if (Math.abs(list[i]) > maximum) {
                maximum = Math.abs(list[i]);
            }
        }
        return maximum;
    }


}
