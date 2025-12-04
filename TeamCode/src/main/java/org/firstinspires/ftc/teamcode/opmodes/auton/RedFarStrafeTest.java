
package org.firstinspires.ftc.teamcode.opmodes.auton;

import com.acmerobotics.roadrunner.Vector2d;
import com.acmerobotics.roadrunner.ftc.Actions;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.acmerobotics.roadrunner.Pose2d;
import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.util.ElapsedTime;

import org.firstinspires.ftc.teamcode.MecanumDrive;
import org.firstinspires.ftc.teamcode.subsystems.example.Intake;
import org.firstinspires.ftc.teamcode.subsystems.example.SmartShooter;
import org.firstinspires.ftc.teamcode.subsystems.example.limelightVision;


@Autonomous
public class RedFarStrafeTest extends LinearOpMode{
    int tagID = 20;
    int Aim = 0;
    CRServo turret ;
    double error;
    public void setTagID(int tagID) {
        this.tagID = tagID;
    }
    @Override
    public void runOpMode() throws InterruptedException{
        MecanumDrive drive = new MecanumDrive(hardwareMap, new Pose2d(0, 0, 0));
        SmartShooter shooter = new SmartShooter(hardwareMap);
        Intake intake = new Intake(hardwareMap);
        limelightVision limelight = new limelightVision(hardwareMap);
        Pose2d botpose = limelight.getRobotPos();
        ElapsedTime myTimer = new ElapsedTime();
        ElapsedTime shootTimer = new ElapsedTime();

        double start;
        double ET;
        waitForStart();
        if (isStopRequested()) return;


        //shoot

        shooter.moveTurret(-limelight.getresult().getTx());

        shooter.shoot(limelight.getresult().getBotposeAvgDist());
        Thread.sleep(2000);
        shooter.setIndexPower(0.75);
        Thread.sleep(500);
        intake.setMotorPower(-1);
        Thread.sleep(500);
        shooter.setIndexPower(0);
        Thread.sleep(500);
        shooter.setIndexPower(0.75);
        Thread.sleep(1500);
        shooter.setIndexPower(0);


        shooter.setMotorVelocity(0);
        intake.setMotorPower(0);
        shooter.setIndexPower(0);


        Actions.runBlocking(
                drive.actionBuilder(new Pose2d(  0,  0, 0))
                        .lineToX(26)
                        .turnTo(Math.toRadians(-90))
                        .build());

        Thread.sleep(1000);

        intake.setMotorPower(-1);

        Actions.runBlocking(
                drive.actionBuilder(new Pose2d(  26,  0, Math.toRadians(-90)))
                        .lineToY(-33)
                        .build());

                intake.setMotorPower(0);

                Thread.sleep(1000);

        Actions.runBlocking(
                drive.actionBuilder(new Pose2d(  26,  -33, Math.toRadians(-90)))
                        .lineToY(0)
                        .build());

        Thread.sleep(1000);


        Actions.runBlocking(
                drive.actionBuilder(new Pose2d(  26,  0, Math.toRadians(-90)))
                        .turnTo(Math.toRadians(90))
                        .lineToX(0)
                        .build());



        if(limelight.getresult().isValid()){
            telemetry.addData("Current Pos", shooter.getTurretPos());
            telemetry.update();
            shooter.moveTurret(-limelight.getresult().getTx());
        }
        shooter.setTurretPower(0);
        shooter.shoot(limelight.getresult().getBotposeAvgDist());
        Thread.sleep(2000);
        shooter.setIndexPower(0.75);
        Thread.sleep(500);
        intake.setMotorPower(-1);
        Thread.sleep(500);
        shooter.setIndexPower(0);
        Thread.sleep(500);
        shooter.setIndexPower(0.75);
        Thread.sleep(1500);
        shooter.setIndexPower(0);


        shooter.setMotorVelocity(0);
        intake.setMotorPower(0);
        shooter.setIndexPower(0);



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
