package org.firstinspires.ftc.teamcode.opmodes.teleop;
import com.acmerobotics.dashboard.FtcDashboard;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.hardware.TouchSensor;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.robotcore.external.Telemetry;

@TeleOp
public class ControlHubTest extends LinearOpMode {
    @Override
    public void runOpMode() {
        Telemetry tel = FtcDashboard.getInstance().getTelemetry();

        Servo test_servo = hardwareMap.get(Servo.class, "test_servo");
        DcMotor test_motor = hardwareMap.get(DcMotor.class, "test_motor");
        // TouchSensor test_touch = hardwareMap.get(TouchSensor.class, "test_touch");

        // Wait for the game to start (driver presses PLAY)
        waitForStart();

        // run until the end of the match (driver presses STOP)
        while (opModeIsActive()) {
            if (touchSensor.isPressed()){
                //Touch Sensor is pressed.
                test_motor.setPower(0.3);
                test_servo.setPosition(1);
                tel.addData("Touch Sensor", "Is Pressed");
            } else {
                //Touch Sensor is not pressed
                test_motor.setPower(0);
                test_servo.setPosition(0);
                tel.addData("Touch Sensor", "Is Not Pressed");
            }
            tel.update();
        }
    }
}