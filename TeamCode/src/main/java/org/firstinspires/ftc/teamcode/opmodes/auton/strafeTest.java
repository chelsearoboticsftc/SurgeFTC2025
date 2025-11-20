
package org.firstinspires.ftc.teamcode.opmodes.auton;

import com.acmerobotics.roadrunner.PoseVelocity2d;
import com.acmerobotics.roadrunner.Vector2d;
import com.acmerobotics.roadrunner.ftc.Actions;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.acmerobotics.roadrunner.Pose2d;

import org.firstinspires.ftc.teamcode.MecanumDrive;
import org.firstinspires.ftc.teamcode.subsystems.example.Intake;
import org.firstinspires.ftc.teamcode.subsystems.example.SmartShooter;
import org.firstinspires.ftc.teamcode.subsystems.example.limelightVision;


@Autonomous
public class strafeTest extends LinearOpMode{
    @Override
    public void runOpMode() throws InterruptedException{
        MecanumDrive drive = new MecanumDrive(hardwareMap, new Pose2d(0,0,0));
        waitForStart();
        if (isStopRequested()) return;
        Actions.runBlocking(
                drive.actionBuilder(new Pose2d(  0,  0, 0))
                        .lineToX(-34)
                        .strafeTo(new Vector2d(-34, -22))
                        .build());

        //shoot
        Thread.sleep(3000);

        Actions.runBlocking(
                drive.actionBuilder(new Pose2d(  0,  0, 0))
                        .lineToX(34)
                        .build());

        Thread.sleep(7000);

        Actions.runBlocking(
                drive.actionBuilder(new Pose2d(  0,  0, 0))
                        .lineToX(-30)
                        .strafeTo(new Vector2d(-30, 22))
                        .build());
        Thread.sleep(3000);
//        Actions.runBlocking(
//                drive.actionBuilder(new Pose2d(  0,  0, 0))
//
//                                .build());


        //shoot

//        Thread.sleep(3000);
//        Actions.runBlocking(
//                drive.actionBuilder(new Pose2d(  0,  0, 0))
//                        .strafeTo(new Vector2d(30, -42))
//                        .build());





    }




    }

