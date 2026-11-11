package org.firstinspires.ftc.teamcode.subsystems;

import static org.firstinspires.ftc.robotcore.external.BlocksOpModeCompanion.gamepad1;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.teamcode.constants.DriveBaseConstants;

import com.qualcomm.hardware.gobilda.GoBildaPinpointDriver;

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

    public void setDbMotorPowers(float[] list) {
        driveMotorFL.setPower(list[0]);
        driveMotorFR.setPower(list[1]);
        driveMotorBR.setPower(list[2]);
        driveMotorBL.setPower(list[3]);
    }


    public float[] setMotorListAndNormalize(float strafe, float forward, float rotate) {
        float[] powerVals = new float[4];
        powerVals[0] = (strafe + forward) + rotate; // FL
        powerVals[1] = -1 * ((strafe - forward) - rotate); // FR, need to flip so that rotate works properly
        powerVals[2] = (strafe + forward) - rotate; // BR
        powerVals[3] = -1 * ((strafe - forward) + rotate); // BL, flip for rotation
        powerVals = this.getNormalizationList(powerVals);
        return powerVals;
    }

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
