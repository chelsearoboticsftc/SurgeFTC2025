package org.firstinspires.ftc.teamcode.opmodes.teleop;

import com.acmerobotics.roadrunner.Pose2d;
import com.acmerobotics.roadrunner.PoseVelocity2d;
import com.acmerobotics.roadrunner.Vector2d;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.Servo;
import org.firstinspires.ftc.teamcode.subsystems.example.SmartShooter;
import org.firstinspires.ftc.teamcode.subsystems.example.Intake;
import com.qualcomm.robotcore.hardware.CRServoImpl;
import org.firstinspires.ftc.teamcode.subsystems.example.Shooter;

import org.firstinspires.ftc.teamcode.MecanumDrive;
import org.firstinspires.ftc.teamcode.subsystems.example.SmartShooterConstants;
//trst
//Greyson is better than Ben at google baseball

@TeleOp
@Disabled
public class BasicTeleopDrive extends LinearOpMode {
    Servo servo;
    @Override
    public void runOpMode() throws InterruptedException {
        MecanumDrive drive = new MecanumDrive(hardwareMap, new Pose2d(0,0,0));

        SmartShooter test1 = new SmartShooter(hardwareMap);
        Intake intakeMotor = new Intake(hardwareMap);

        Intake intake = new Intake(hardwareMap);


//EVIL SERVO >:O

        waitForStart();

        while(opModeIsActive()) {
            drive.setDrivePowers(

                    new PoseVelocity2d(
                            new Vector2d(-gamepad1.left_stick_y,
                                    -gamepad1.left_stick_x),
                            -gamepad1.right_stick_x));
            while(gamepad2.left_trigger > 0){
                intakeMotor.setMotorPower(0.75);


            /* while(gamepad1.left_trigger > 0) {
               intake.IndexBelt(0.75);         */
            }
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

            */
