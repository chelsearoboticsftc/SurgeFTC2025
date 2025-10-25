package org.firstinspires.ftc.teamcode.opmodes.auton;

import com.acmerobotics.roadrunner.Pose2d;
import com.acmerobotics.roadrunner.ftc.Actions;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

import org.firstinspires.ftc.teamcode.MecanumDrive;
import org.firstinspires.ftc.teamcode.subsystems.example.Intake;
import org.firstinspires.ftc.teamcode.subsystems.example.SmartShooter;

@Autonomous
public class SurgeAutonBlueNear extends LinearOpMode {
    @Override
    public void runOpMode() throws InterruptedException {
        MecanumDrive drive = new MecanumDrive(hardwareMap, new Pose2d(0,0,0));
        waitForStart();

        Thread.sleep((2000));

        if (isStopRequested()) return;
        Actions.runBlocking(
                drive.actionBuilder(new Pose2d(  0,  0, 0))
                        .lineToX(120)
                        .build()

        );
        SmartShooter shooter = new SmartShooter(hardwareMap);
        Intake intake = new Intake(hardwareMap);
    }
}