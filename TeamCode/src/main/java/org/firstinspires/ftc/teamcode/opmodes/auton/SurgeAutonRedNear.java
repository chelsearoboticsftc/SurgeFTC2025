package org.firstinspires.ftc.teamcode.opmodes.auton;

import com.acmerobotics.roadrunner.Pose2d;
import com.acmerobotics.roadrunner.PoseVelocity2d;
import com.acmerobotics.roadrunner.Vector2d;
import com.acmerobotics.roadrunner.ftc.Actions;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

import org.firstinspires.ftc.teamcode.MecanumDrive;
import org.firstinspires.ftc.teamcode.subsystems.example.Intake;
import org.firstinspires.ftc.teamcode.subsystems.example.SmartShooter;
import org.firstinspires.ftc.teamcode.subsystems.example.limelightVision;

@Autonomous
public class SurgeAutonRedNear extends LinearOpMode {
    @Override
    public void runOpMode() throws InterruptedException {
        MecanumDrive drive = new MecanumDrive(hardwareMap, new Pose2d(0, 0, 0));
        SmartShooter shooter = new SmartShooter(hardwareMap);
        limelightVision limelight = new limelightVision(hardwareMap);
        Pose2d botpose = limelight.getRobotPos();
        Intake intake = new Intake(hardwareMap);
        waitForStart();

        Actions.runBlocking(
                drive.actionBuilder(new Pose2d(0, 0, 0))
                        .lineToX(-45)
                        .build());

        if (isStopRequested()) return;
        shooter.setMotorVelocity(2500);
        if (limelight.getresult().getTx() < 6.5) {
            while (limelight.getresult().getTx() < 6.5) {
                drive.setDrivePowers(new PoseVelocity2d(
                        new Vector2d(0,
                                0),
                        0.2));
            }
            drive.setDrivePowers(new PoseVelocity2d(
                    new Vector2d(0,
                            0),
                    0));


        } else if (limelight.getresult().getTx() > 7.5) {
            while (limelight.getresult().getTx() > 7.5) {
                drive.setDrivePowers(new PoseVelocity2d(
                        new Vector2d(0,
                                0),
                        -0.2));
            }
            drive.setDrivePowers(new PoseVelocity2d(
                    new Vector2d(0,
                            0),
                    0));


        }
        // shooter.hoodAngleNear();
//        Thread.sleep(3000);
//        shooter.indexFunction();
//        Thread.sleep(1500);
//        intake.setMotorPower(-0.5);
//        Thread.sleep(300);
//        intake.setMotorPower(0);
//        shooter.indexFunction2();
//        Thread.sleep(1500);
//        intake.setMotorPower(1);
//        Thread.sleep(1500);
//        intake.setMotorPower(-0.5);
//        Thread.sleep(300);
//        intake.setMotorPower(0);
//        shooter.indexFunction();
//        Thread.sleep(1500);
//        shooter.indexFunction2();
//        Thread.sleep(1000);
//        intake.setMotorPower(1);
//        Thread.sleep(1500);
//        intake.setMotorPower(0);
//        Thread.sleep(1500);
//        shooter.indexFunction();
//        Thread.sleep(1500);
//        shooter.indexFunction2();


        Actions.runBlocking(
                drive.actionBuilder(new Pose2d(0, 0, 0))
                        .strafeTo(new Vector2d(6, 32))
                        .build());





    }
}