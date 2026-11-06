package org.firstinspires.ftc.teamcode.subsystems;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.teamcode.constants.DriveBaseConstants;

public class DriveBaseSetup {
    // TODO

    // this file may not be exclusively for setting up the drive base but also for running it
    // similar to 33748 Decode w/ the subsystems?

    private DcMotor driveMotorFL, driveMotorFR, driveMotorBL, driveMotorBR;


    public void driveBaseMotorInit(HardwareMap hardwareMap) {
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


    }



}
