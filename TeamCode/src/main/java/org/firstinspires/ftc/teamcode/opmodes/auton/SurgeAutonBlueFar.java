package org.firstinspires.ftc.teamcode.opmodes.auton;

import com.acmerobotics.roadrunner.Pose2d;
import com.acmerobotics.roadrunner.ftc.Actions;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

import org.firstinspires.ftc.teamcode.MecanumDrive;
import org.firstinspires.ftc.teamcode.subsystems.example.Intake;
import org.firstinspires.ftc.teamcode.subsystems.example.SmartShooter;

@Autonomous
public class SurgeAutonBlueFar extends LinearOpMode {
    @Override
    public void runOpMode() throws InterruptedException {
        MecanumDrive drive = new MecanumDrive(hardwareMap, new Pose2d(0,0,0));
        SmartShooter shooter = new SmartShooter(hardwareMap);
        Intake intake = new Intake(hardwareMap);
        waitForStart();
//        intake.setMotorPower(0.5);
//        shooter.shoot(6000);
//        Thread.sleep(7000);
//        double setMotorVelocity = 0;
//
//        Thread.sleep((2000));

        if (isStopRequested()) return;
        shooter.setMotorVelocity(2500);
       // shooter.hoodAngleNear();
        Thread.sleep(3000);
        shooter.indexFunction();
        Thread.sleep(1500);
        shooter.indexFunction2();
        Thread.sleep(1500);
        intake.setMotorPower(1);
        Thread.sleep(1500);
        intake.setMotorPower(-0.5);
        Thread.sleep(300);
        intake.setMotorPower(0);
        shooter.indexFunction();
        Thread.sleep(1500);
        shooter.indexFunction2();
        Thread.sleep(1000);
        intake.setMotorPower(1);
        Thread.sleep(1500);
        intake.setMotorPower(0);
        Thread.sleep(1500);
        shooter.indexFunction();
        Thread.sleep(1500);
        shooter.indexFunction2();



shooter.setMotorVelocity(0);

        Actions.runBlocking(
                drive.actionBuilder(new Pose2d(  0,  0, 0))
                        .turnTo(-0.523)
                        .lineToX(-28)
                        .build());
 //                       intake.setMotorPower(1);
        Actions.runBlocking(
                drive.actionBuilder(new Pose2d(  0,  0, 0))
                        .lineToX(22)
                        .build());

        Actions.runBlocking(
                drive.actionBuilder(new Pose2d(  0,  0, 0))
                        .turnTo(-1.57)
                        .build());
        if(isStopRequested())return;
        intake.setMotorPower(1);

        drive.actionBuilder(new Pose2d(  0,  0, 0))
                .lineToX(18)
                .build();





//        drive.actionBuilder(new Pose2d(  0,  0, 0))
//                .lineToX(-34)
//                .build();


    }
}