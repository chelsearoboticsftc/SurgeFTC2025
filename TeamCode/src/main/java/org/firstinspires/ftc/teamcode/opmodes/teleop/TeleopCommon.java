package org.firstinspires.ftc.teamcode.opmodes.teleop;

import com.acmerobotics.roadrunner.Pose2d;
import com.acmerobotics.roadrunner.PoseVelocity2d;
import com.acmerobotics.roadrunner.Vector2d;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.CRServoImpl;
import com.qualcomm.robotcore.hardware.DcMotorEx;

import org.firstinspires.ftc.teamcode.subsystems.example.Shooter;
import org.firstinspires.ftc.teamcode.MecanumDrive;
import org.firstinspires.ftc.teamcode.subsystems.example.Intake;

//trst
//Greyson is better than Ben at google baseball

@TeleOp
public class TeleopCommon extends LinearOpMode {
    CRServoImpl servo;
    DcMotorEx shooter1;
    DcMotorEx shooter2;
    DcMotorEx intake;
    int tagID = 20;
    int Aim = 0;

    public void setTagID(int tagID) { this.tagID = tagID; }
    @Override
    public void runOpMode() throws InterruptedException {
        MecanumDrive drive = new MecanumDrive(hardwareMap, new Pose2d(0,0,0));
        Shooter test1 = new Shooter(hardwareMap);
        Intake test2 = new Intake(hardwareMap);

        servo = hardwareMap.get(CRServoImpl.class, "servo3");
        shooter1 = hardwareMap.get(DcMotorEx.class, "shooter1");
        shooter2 = hardwareMap.get(DcMotorEx.class, "shooter2");
        intake = hardwareMap.get(DcMotorEx.class, "intake");
//EVIL SERVO >:O

        waitForStart();

        while(opModeIsActive()) {
            drive.setDrivePowers(

                    new PoseVelocity2d(
                            new Vector2d(-gamepad1.left_stick_y,
                                    -gamepad1.left_stick_x),
                            -gamepad1.right_stick_x));
            if(gamepad2.x){
                if(Aim == 0){
                    Aim = 1;
                }
                if(Aim == 1 || Aim == -1){
                    Aim = 0;
                }
                servo.setPower(Aim);
            }
            if(gamepad2.b){
                if(Aim == 0){
                    Aim = -1;
                }
                if(Aim == -1 || Aim == 1){
                    Aim = 0;
                }
                servo.setPower(Aim);

                if(gamepad1.right_trigger > 0){
                   shooter1.setPower(1.0);
                   shooter2.setPower(1.0);
                }
                if(gamepad1.right_trigger < 0){
                    shooter1.setPower(0);
                    shooter2.setPower(0);
                }
                if(gamepad1.left_trigger > 0){
                    intake.setPower(1.0);
                }
                if(gamepad1.left_trigger < 0){
                    intake.setPower(0);
                }

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
}           */