package org.firstinspires.ftc.teamcode.opmodes.auton;

import com.acmerobotics.roadrunner.Pose2d;
import com.acmerobotics.roadrunner.ftc.Actions;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

<<<<<<< HEAD
import org.firstinspires.ftc.teamcode.MecanumDrive;

=======
>>>>>>> 4fd71618041392b9e9965739fcc7cb2889b7921f
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
    }
}