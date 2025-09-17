package org.firstinspires.ftc.teamcode.opmodes.teleop;

import com.acmerobotics.dashboard.FtcDashboard;
import com.acmerobotics.roadrunner.Pose2d;
import com.acmerobotics.roadrunner.PoseVelocity2d;
import com.acmerobotics.roadrunner.Vector2d;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.robotcore.external.Telemetry;
import org.firstinspires.ftc.teamcode.MecanumDrive;


@TeleOp
public class BasicTeleopDrive extends LinearOpMode {
    @Override
    public void runOpMode() throws InterruptedException {
        Telemetry tel = FtcDashboard.getInstance().getTelemetry();
        waitForStart();
        tel.addData("Foo", "Bar");
        tel.update();
        tel.addData("HardwareMap", hardwareMap);
//        hardwareMap.get

        int i = 0;
        while(opModeIsActive()) {
            tel.addData("Count", i);
            tel.update();
            i += 1;
        }

//        MecanumDrive drive = new MecanumDrive(hardwareMap, new Pose2d(0,0,0));

//        waitForStart();

//        while(opModeIsActive()){
//            drive.setDrivePowers(
//                    new PoseVelocity2d(
//                            new Vector2d(-gamepad1.left_stick_y,
//                                         -gamepad1.left_stick_x),
//                            -gamepad1.left_stick_x));
//        }
//    }
    }
}
