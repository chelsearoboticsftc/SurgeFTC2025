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

//trst
//Greyson is better than Ben at google baseball

@TeleOp
public class TeleopCommon extends LinearOpMode {

    int tagID = 20;
    int Aim = 0;

    public void setTagID(int tagID) { this.tagID = tagID; }
    @Override
    public void runOpMode() throws InterruptedException {
        MecanumDrive drive = new MecanumDrive(hardwareMap, new Pose2d(0,0,0));
        SmartShooter shooter = new SmartShooter(hardwareMap);
        Intake intake = new Intake(hardwareMap);
        waitForStart();

        while(opModeIsActive()) {
            drive.setDrivePowers(

                    new PoseVelocity2d(
                            new Vector2d(gamepad1.left_stick_y,
                                    gamepad1.left_stick_x),
                            -gamepad1.right_stick_x));

            if(gamepad2.rightBumperWasPressed()){
                shooter.setMotorVelocity(5000);
            telemetry.addData("bumperWasPressed","True");
                telemetry.update();
            }
            if(gamepad2.x){
                shooter.hoodAngleNear();

            }
            if(gamepad2.y){
                shooter.hoodAngleFar();
            }
            //if(gamepad2.rightBumperWasReleased()){
            //    shooter.setMotorVelocity(0);
            //}
            //intake.setMotorPower(gamepad1.left_trigger);
            if(gamepad1.left_bumper){
                intake.setMotorPower(1.0);
                telemetry.addData("Intake Speed",intake.getMotorPower());
                telemetry.update();
            }
            if(!gamepad1.left_bumper){
                intake.setMotorPower(0);
                telemetry.addData("Intake Speed",intake.getMotorPower());
                telemetry.update();
            }
            //intake.setMotorPower(-gamepad1.right_trigger);
            if(gamepad1.right_bumper){
                intake.setMotorPower(-1.0);
                telemetry.addData("Intake Speed",intake.getMotorPower());
                telemetry.update();
            }
            if(!gamepad1.right_bumper){
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
            telemetry.update();

            telemetry.addData("bumperPosition", gamepad2.right_bumper);
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