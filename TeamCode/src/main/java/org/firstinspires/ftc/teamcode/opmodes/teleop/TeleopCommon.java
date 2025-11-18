package org.firstinspires.ftc.teamcode.opmodes.teleop;

import com.acmerobotics.roadrunner.Pose2d;
import com.acmerobotics.roadrunner.PoseVelocity2d;
import com.acmerobotics.roadrunner.Vector2d;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.CRServoImpl;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.Servo;

import org.firstinspires.ftc.teamcode.subsystems.example.SmartShooter;
import org.firstinspires.ftc.teamcode.MecanumDrive;
import org.firstinspires.ftc.teamcode.subsystems.example.Intake;
import org.firstinspires.ftc.teamcode.subsystems.example.limelightVision;

//trust
//Greyson is better than Ben at google baseball

@TeleOp
public class TeleopCommon extends LinearOpMode {

    int tagID = 20;
    int Aim = 0;
    CRServoImpl turret;

    public void setTagID(int tagID) { this.tagID = tagID; }
    @Override
    public void runOpMode() throws InterruptedException {
        MecanumDrive drive = new MecanumDrive(hardwareMap, new Pose2d(0,0,0));
        SmartShooter shooter = new SmartShooter(hardwareMap);
        Intake intake = new Intake(hardwareMap);
        limelightVision limelight = new limelightVision(hardwareMap);
        Pose2d botpose = limelight.getRobotPos();
        waitForStart();

        while(opModeIsActive()) {
            drive.setDrivePowers(

                    new PoseVelocity2d(
                            new Vector2d(gamepad1.left_stick_y,
                                    gamepad1.left_stick_x),
                            -gamepad1.right_stick_x));

            if(gamepad2.rightBumperWasPressed()){
                shooter.setMotorVelocity(4000);
            telemetry.addData("bumperWasPressed","True");
                telemetry.update();
            }
//            if(gamepad2.x){
//                shooter.hoodAngleNear();
//
//            }
//            if(gamepad2.y){
//                shooter.hoodAngleFar();
//            }
            //if(gamepad2.rightBumperWasReleased()){
            //    shooter.setMotorVelocity(0);
            //}
            //intake.setMotorPower(gamepad1.left_trigger);
            if(gamepad1.left_bumper){
                intake.setMotorPower(1.0);
                telemetry.addData("Intake Speed",intake.getMotorPower());
                telemetry.update();
            }
            /*if(!gamepad1.left_bumper){
                intake.setMotorPower(0);
                telemetry.addData("Intake Speed",intake.getMotorPower());
                telemetry.update();
            }*/
            //intake.setMotorPower(-gamepad1.right_trigger);
            else if(gamepad1.right_bumper){
                intake.setMotorPower(-0.5);
                telemetry.addData("Intake Speed",intake.getMotorPower());
                telemetry.update();
            }
            else{
                intake.setMotorPower(0);
            }
            if(gamepad2.bWasPressed()){
                shooter.indexFunction();
                telemetry.addData("bWasPressed","True");
                telemetry.update();
            }

            if(gamepad2.bWasReleased()){
                shooter.indexFunction2();

                telemetry.addData("bWasPressed","False");
                telemetry.update();
            };
            telemetry.addData("servoPosition", shooter.getElevatorPosition());


            telemetry.addData("bumperPosition", gamepad2.right_bumper);


            telemetry.addData("Velocity", shooter.getVelocity());
            if(limelight.getresult() != null){
                if(limelight.getresult().isValid()){


                    telemetry.addData("Pose2d that the limelight gives", botpose);
                    telemetry.addData("tx",limelight.getresult().getTx());
                    telemetry.addData("ty", limelight.getresult().getTy());
                    telemetry.addData("pos",botpose.position);
                    telemetry.addData("heading",botpose.heading);
                    telemetry.update();

                }

            }

            if(gamepad1.bWasPressed()){

                if (limelight.getresult().getTx() < 6.5){
                    while(limelight.getresult().getTx() < 6.5){
                        drive.setDrivePowers( new PoseVelocity2d(
                                new Vector2d(0,
                                        0),
                                0.2));
                        //turret.setPower(0.5);
                    }
                    drive.setDrivePowers( new PoseVelocity2d(
                            new Vector2d(0,
                                    0),
                            0));
                        //turret.setPower(0);

                }
                else if (limelight.getresult().getTx() > 7.5){
                    while(limelight.getresult().getTx() > 7.5){
                        drive.setDrivePowers( new PoseVelocity2d(
                                new Vector2d(0,
                                        0),
                                -0.2));
                        //turret.setPower(-0.5);
                    }
                    drive.setDrivePowers( new PoseVelocity2d(
                            new Vector2d(0,
                                    0),
                            0));
                        //turret.setPower(0);

                }
            }
            if(gamepad2.x){
                shooter.turretLeft();
            }
            if(gamepad2.y){
                shooter.turretRight();
            }
            telemetry.update();
        }
    }
}



           /*
           Put double bob = 0 in init

           if (gamepad2.a) {
                test1.aim();
            } else if (gamepad2.b) {
                test1.aim();
            }
            if(gamepad1.x){
                servo.setPosition(1);
            }
            if(gamepad1.y){
                servo.setPosition(0);
            }
            if (gamepad1.right_trigger > 0) {
                bob = 1;}
                else if (gamepad1.left_trigger > 0) {
                bob = 0;
            }
            test1.setMotorPower(bob);

goofy code: String smth = String.valueOf(98.25);
telemetry.addData("idk",String.valueOf(smth));
telemetry.update();
}           */