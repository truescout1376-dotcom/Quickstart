package org.firstinspires.ftc.teamcode.pedro;

import com.pedropathing.algorithm.ForesightConfig;
import com.pedropathing.controllers.Controller;
import com.pedropathing.follower.Follower;
import com.pedropathing.math.Matrix;
import com.pedropathing.math.Vector2D;
import com.pedropathing.revhub.drivetrains.MecanumConfig;
import com.pedropathing.revhub.localizers.PinpointConfig;
import com.qualcomm.hardware.gobilda.GoBildaPinpointDriver;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.robotcore.external.navigation.DistanceUnit;

public class Constants {

    public static MecanumConfig drivetrainConfig = new MecanumConfig(c -> {
        c.frontLeftName.set("motorFL");
        c.frontRightName.set("motorFR");
        c.backLeftName.set("motorBL");
        c.backRightName.set("motorBR");
        c.frontLeftDirection.set(DcMotorSimple.Direction.REVERSE);
        c.frontRightDirection.set(DcMotorSimple.Direction.REVERSE);
        c.backLeftDirection.set(DcMotorSimple.Direction.FORWARD);
        c.backRightDirection.set(DcMotorSimple.Direction.FORWARD);
    });

    public static PinpointConfig localizerConfig = new PinpointConfig(c -> {
        c.name.set("pinpoint");
        c.podType.set(GoBildaPinpointDriver.GoBildaOdometryPods.goBILDA_4_BAR_POD);
        c.xPodOffset.set(6.039195623923475);
        c.yPodOffset.set(-4.640848655400314);
        c.xPodDirection.set(GoBildaPinpointDriver.EncoderDirection.FORWARD);
        c.yPodDirection.set(GoBildaPinpointDriver.EncoderDirection.REVERSED);
        c.globalDistanceUnit.set(DistanceUnit.INCH);
        c.offsetUnits.set(DistanceUnit.INCH);
    });

    public static ForesightConfig foresightConfig = new ForesightConfig(
            c -> {
                Controller primaryTranslationalForward = Controller.proportional(0.20356782717930458);
                Controller secondaryTranslationalForward = Controller.proportional(0.07521287271023136);
                Controller primaryTranslationalLateral = Controller.proportional(0.25661691988158697);
                Controller secondaryTranslationalLateral = Controller.proportional(0.09481309496586124);

                c.forwardTranslational.set(Controller.piecewise(secondaryTranslationalForward).put(2.5, primaryTranslationalForward));
                c.strafeTranslational.set(Controller.piecewise(secondaryTranslationalLateral).put(2.5, primaryTranslationalLateral));

                c.coast.set(Controller.proportionalFeedforward(0.018487824700536126));
                c.brake.set(Controller.proportionalFeedforward(0.015714650995455708));

                c.headingFeedback.set(Controller.proportional(2.697225110244733));
                c.headingBrakeCoefficients.set(Vector2D.cartesian(0.056446633895364806, 0.007561539370117988));

                c.linearBrakeCoefficients.set(Matrix.diag(0.049251898525562054, 0.058208645442899144));
                c.quadraticBrakeCoefficients.set(Matrix.diag(0.002582110142701907, 0.0022948786334530563));

                c.maxAchievableForwardVelocity.set(58.399172143921604);
                c.maxAchievableStrafeVelocity.set(53.43784446359198);
                c.naturalForwardDeceleration.set(34.8572248962807);
                c.naturalStrafeDeceleration.set(52.473894703947956);
            }
    );




    public static Follower create(HardwareMap h) {
        // return new Follower(Drivetrain, Localizer, Foresight);
        return null;
    }


}