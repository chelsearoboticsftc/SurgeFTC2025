package org.firstinspires.ftc.teamcode.opmodes.teleop;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import org.firstinspires.ftc.teamcode.subsystems.example.SmartShooter;

@TeleOp
public class ShooterCalibrator extends LinearOpMode {
    @Override
    public void runOpMode() throws InterruptedException {
        SmartShooter shooter1 = new SmartShooter(hardwareMap);

        waitForStart();

        double step = 0.1;
        double velocity = 0;

        while(opModeIsActive()){
            // A button presses increase velocity by "step"
            if (gamepad1.aWasPressed()) {
                velocity += step;
            }
            // B button presses reset velocity to 0
            if (gamepad1.bWasPressed()) {
                velocity = 0;
            }
            shooter1.setMotorVelocity(velocity);
            this.telemetry.addData("Velocity", velocity);
            this.telemetry.update();
        }
    }
}
