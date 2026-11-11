package org.firstinspires.ftc.teamcode.constants;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.hardware.gobilda.GoBildaPinpointDriver;
import org.firstinspires.ftc.teamcode.pedro.procedures.PinpointTuner;

public class DriveBaseConstants {

    // maybe make some of this enums?

    // names like "motor3" and others will be defined on the robot


    public final static String DB_MOTOR_FL = "motorFL";
    public final static String DB_MOTOR_FR = "motorFR";
    public final static String DB_MOTOR_BL = "motorBL";
    public final static String DB_MOTOR_BR = "motorBR";

    public final static String DB_PINPOINT = "pinpoint";

    // directions for strafer db
    public final static DcMotor.Direction LEFT_DIR = DcMotor.Direction.FORWARD;
    public final static DcMotor.Direction RIGHT_DIR = DcMotor.Direction.REVERSE;

}
