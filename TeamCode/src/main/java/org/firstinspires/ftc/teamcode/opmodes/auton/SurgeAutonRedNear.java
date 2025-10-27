package org.firstinspires.ftc.teamcode.opmodes.auton;

import com.acmerobotics.roadrunner.Pose2d;
import com.acmerobotics.roadrunner.Vector2d;
import com.acmerobotics.roadrunner.ftc.Actions;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;


import org.firstinspires.ftc.teamcode.MecanumDrive;
import org.firstinspires.ftc.teamcode.subsystems.example.Intake;
import org.firstinspires.ftc.teamcode.subsystems.example.SmartShooter;


@Autonomous
public class SurgeAutonRedNear extends LinearOpMode {
    @Override
    public void runOpMode() throws InterruptedException {
        MecanumDrive drive = new MecanumDrive(hardwareMap, new Pose2d(0,0,0));
        SmartShooter shooter = new SmartShooter(hardwareMap);
        Intake intake = new Intake(hardwareMap);
        waitForStart();
        intake.setMotorPower(0.5);
        Actions.runBlocking(
                drive.actionBuilder(new Pose2d(  0,  0, 0))
                        .turnTo(-0.5)
                        .lineToX(-12)
                        .build()

        );
        Thread.sleep(4000);
        shooter.shoot(10);

        Thread.sleep((2000));
        shooter.shoot(0);

        if (isStopRequested()) return;


    }
}