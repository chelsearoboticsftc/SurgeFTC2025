package org.firstinspires.ftc.teamcode.opmodes.teleop;

import com.acmerobotics.roadrunner.Pose2d;
import com.acmerobotics.roadrunner.PoseVelocity2d;
import com.acmerobotics.roadrunner.Vector2d;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import org.firstinspires.ftc.teamcode.subsystems.example.Shooter;
import org.firstinspires.ftc.teamcode.MecanumDrive;
//trst
//Greyson is better than Ben at google baseball

@TeleOp
public class BasicTeleopDrive extends LinearOpMode {
    @Override
    public void runOpMode() throws InterruptedException {
        MecanumDrive drive = new MecanumDrive(hardwareMap, new Pose2d(0, 0, 0));
        Shooter test1 = new Shooter(hardwareMap);

        waitForStart();


        while (opModeIsActive()) {

            drive.setDrivePowers(
                    new PoseVelocity2d(
                            new Vector2d(-gamepad1.left_stick_y,
                                    -gamepad1.left_stick_x),
                            -gamepad1.right_stick_x));

            if(gamepad1.right_trigger > 0) {

                test1.setMotorPower(0.5);
            }
            else if(gamepad1.right_trigger == 0){
                test1.setMotorPower(0);
            }

        telemetry.addData("Forward Input", -gamepad1.left_stick_y);
        telemetry.addData("Strafe Input", -gamepad1.left_stick_x);
        telemetry.addData("Turn Input", -gamepad1.right_stick_x);
        telemetry.update();
        }
    }
}
//ben and greyson
//Wesley and Mack
//Are all cool
// :P
//mack attack i chose you
// aaaahhh
// ben is cool 