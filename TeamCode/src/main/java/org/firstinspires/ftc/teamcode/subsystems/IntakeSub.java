package org.firstinspires.ftc.teamcode.subsystems;

import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.teamcode.constants.IntakeConstants;

public class IntakeSub {

    // This enum may get cut later
    public enum Level {
        RUNNING_FORWARD,
        STOPPED,
        RUNNING_REVERSE
    }

    private CRServo intakeFlipperServo;
    private DcMotor intakeMotor;

    public void init(HardwareMap hardwareMap) {
        // intakeFlipperServo = hardwareMap.get(CRServo.class, IntakeConstants.IN_SERVO);
    }






    // TODO
    // Functions: stop, reverse, start, set RPM or power, init
    // Consider running based off of the trigger button?
}
