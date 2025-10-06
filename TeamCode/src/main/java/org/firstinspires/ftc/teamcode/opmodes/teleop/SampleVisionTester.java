package org.firstinspires.ftc.teamcode.opmodes.teleop;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import org.firstinspires.ftc.teamcode.subsystems.example.SampleVision;
import org.firstinspires.ftc.robotcore.external.navigation.Position;

@TeleOp
public class SampleVisionTester extends LinearOpMode {

    private Position distance;

    @Override
    public void runOpMode() throws InterruptedException {

        SampleVision GoalDistance = new SampleVision(hardwareMap);
        waitForStart();
        while(opModeIsActive()){
            distance = GoalDistance.getDistanceToGoal(20);
            //20 equals BLUE team
            telemetry.addLine(String.format("XYZ %6.1f %6.1f %6.1f inch",
                    distance.x,distance.y,distance.z));
            telemetry.update();
            sleep(5000);
        }
    }

}
