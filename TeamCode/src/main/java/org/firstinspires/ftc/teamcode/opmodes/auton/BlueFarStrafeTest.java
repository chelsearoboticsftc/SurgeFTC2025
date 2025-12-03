package org.firstinspires.ftc.teamcode.opmodes.auton;

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
public class BlueFarStrafeTest extends LinearOpMode{
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

        if(isStopRequested())return;

        myTimer.reset();
        start = getRuntime();

        //ET = 0;

        while (Math.abs(limelight.getresult().getTx()) > 2 && myTimer.seconds() < 2) {
            error = limelight.getresult().getTx();
            shooter.setTurretPower(-Math.signum(error)*Math.max(Math.abs(error * 0.008),0.07));
            limelight.getresult().getBotposeAvgDist();
            //ET = getRuntime() - start
            myTimer.seconds();

            telemetry.addData("turning",limelight.getresult().getTx());
        }
        shooter.setTurretPower(0);
        shooter.shoot(limelight.getresult().getBotposeAvgDist());
        Thread.sleep(2000);
        shooter.setIndexPower(0.75);
        Thread.sleep(500);
        intake.setMotorPower(-1);
        Thread.sleep(3000);
        if(isStopRequested())return;

        myTimer.reset();
        start = getRuntime();

        //ET = 0;

        while (Math.abs(limelight.getresult().getTx()) > 2 && myTimer.seconds() < 2) {
            error = limelight.getresult().getTx();
            shooter.setTurretPower(-Math.signum(error)*Math.max(Math.abs(error * 0.008),0.07));
            limelight.getresult().getBotposeAvgDist();
            //ET = getRuntime() - start
            myTimer.seconds();

            telemetry.addData("turning",limelight.getresult().getTx());
        }
        shooter.setTurretPower(0);
        shooter.shoot(limelight.getresult().getBotposeAvgDist());
        Thread.sleep(2000);
        shooter.setIndexPower(0.75);
        Thread.sleep(500);
        intake.setMotorPower(-1);
        Thread.sleep(3000);
        if(isStopRequested())return;

        myTimer.reset();
        start = getRuntime();

        //ET = 0;

        while (Math.abs(limelight.getresult().getTx()) > 2 && myTimer.seconds() < 2) {
            error = limelight.getresult().getTx();
            shooter.setTurretPower(-Math.signum(error)*Math.max(Math.abs(error * 0.008),0.07));
            limelight.getresult().getBotposeAvgDist();
            //ET = getRuntime() - start
            myTimer.seconds();

            telemetry.addData("turning",limelight.getresult().getTx());
        }
        shooter.setTurretPower(0);
        shooter.shoot(limelight.getresult().getBotposeAvgDist());
        Thread.sleep(2000);
        shooter.setIndexPower(0.75);
        Thread.sleep(500);
        intake.setMotorPower(-1);
        Thread.sleep(3000);

        shooter.setMotorVelocity(0);
        intake.setMotorPower(0);
        shooter.setIndexPower(0);


        Actions.runBlocking(
                drive.actionBuilder(new Pose2d(  0,  0, 0))
                        .lineToX(-22)
//                        .turnTo(-1.57)
//                        .build());
//
//        Actions.runBlocking(
//                drive.actionBuilder(new Pose2d(  0,  0, 0))
//                        .lineToX(-26)
                .build());

















    }
}