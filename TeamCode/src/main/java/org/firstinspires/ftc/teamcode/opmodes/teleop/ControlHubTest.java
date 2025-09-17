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
//        DcMotor test_motor = hardwareMap.get(DcMotor.class, "test_motor");
         TouchSensor test_touch = hardwareMap.get(TouchSensor.class, "test_touch");

        // Wait for the game to start (driver presses PLAY)
        waitForStart();

        int counter = 0;
        // run until the end of the match (driver presses STOP)
        while (opModeIsActive()) {
            counter += 1;
            if (counter > 1000) {
                counter = 0;
            }
            tel.addData("Counter", counter);
            tel.addData("Touch Sensor Pressed", test_touch.isPressed());
            tel.addData("Touch Sensor Value", test_touch.getValue());
//            test_servo.setPosition(counter / 1000.0);

            if (test_touch.isPressed()) {
                //Touch Sensor is pressed.
//                test_motor.setPower(0.3);
                test_servo.setPosition(1);
            } else {
                //Touch Sensor is not pressed
//                test_motor.setPower(0);
                test_servo.setPosition(0);
            }
            tel.update();
        }
    }
}