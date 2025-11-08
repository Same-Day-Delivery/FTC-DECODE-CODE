package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;

@Autonomous(name = "TankDriveAutoCircle", group = "Autonomous")
public class TankDriveAutoCircle extends LinearOpMode {
    private DcMotor motf;
    private DcMotor motb;
    private DcMotor u2;
    private DcMotor u1;
    

    @Override
    public void runOpMode() {
        motf = hardwareMap.get(DcMotor.class, "motf");
        motb = hardwareMap.get(DcMotor.class, "motb");

        motf.setDirection(DcMotor.Direction.FORWARD);
        motb.setDirection(DcMotor.Direction.REVERSE);

        waitForStart();


        if (opModeIsActive()) {
            motf.setPower(1);
            motb.setPower(1);

            sleep(1290); // Run for calculated time

            // Stop motors
            motf.setPower(0);
            motb.setPower(0);
            
            sleep(500);
            
            motf.setPower(1);
            motb.setPower(-1);

            sleep(270); // Run for calculated time
            
            // Stop motors
            motf.setPower(0);
            motb.setPower(0);
            
            sleep(500);
            
            motf.setPower(-1);
            motb.setPower(-1);

            sleep(200); // Run for calculated time
            
            // Stop motors
            motf.setPower(0);
            motb.setPower(0);
            
            sleep(500);
            
            motf.setPower(1);
            motb.setPower(-1);

            sleep(270); // Run for calculated time
            
            // Stop motors
            motf.setPower(0);
            motb.setPower(0);
            
            sleep(500);
            
            motf.setPower(1);
            motb.setPower(1);

            sleep(1100); // Run for calculated time
            
            // Stop motors
            motf.setPower(0);
            motb.setPower(0);
            
            sleep(500);
            
            motf.setPower(1);
            motb.setPower(-1);

            sleep(540); // Run for calculated time
            
            // Stop motors
            motf.setPower(0);
            motb.setPower(0);
            
            sleep(500);
            

            motf.setPower(1);
            motb.setPower(1);

            sleep(1200); // Run for calculated time

            // Stop motors
            motf.setPower(0);
            motb.setPower(0);
            
            sleep(500);
            
            motf.setPower(1);
            motb.setPower(-1);

            sleep(270); // Run for calculated time
            
            // Stop motors
            motf.setPower(0);
            motb.setPower(0);
            
            sleep(500);
            
            motf.setPower(-1);
            motb.setPower(-1);

            sleep(200); // Run for calculated time
            
            // Stop motors
            motf.setPower(0);
            motb.setPower(0);
            
            sleep(500);
            
            motf.setPower(1);
            motb.setPower(-1);

            sleep(270); // Run for calculated time
            
            // Stop motors
            motf.setPower(0);
            motb.setPower(0);
            
            sleep(500);
            
            motf.setPower(1);
            motb.setPower(1);

            sleep(1200); // Run for calculated time
            
            // Stop motors
            motf.setPower(0);
            motb.setPower(0);
            
            sleep(500);
            
            motf.setPower(1);
            motb.setPower(-1);

            sleep(540); // Run for calculated time
            
            // Stop motors
            motf.setPower(0);
            motb.setPower(0);
            
            sleep(500);
            
            motf.setPower(1);
            motb.setPower(1);

            sleep(1100); // Run for calculated time

            // Stop motors
            motf.setPower(0);
            motb.setPower(0);
            
            sleep(500);
            
            motf.setPower(1);
            motb.setPower(-1);

            sleep(270); // Run for calculated time
            
            // Stop motors
            motf.setPower(0);
            motb.setPower(0);
            
            sleep(500);
            
            motf.setPower(-1);
            motb.setPower(-1);

            sleep(200); // Run for calculated time
            
            // Stop motors
            motf.setPower(0);
            motb.setPower(0);
            
            sleep(500);
            
            motf.setPower(1);
            motb.setPower(-1);

            sleep(270); // Run for calculated time
            
            // Stop motors
            motf.setPower(0);
            motb.setPower(0);
            
            sleep(500);
            
            motf.setPower(1);
            motb.setPower(1);

            sleep(1100); // Run for calculated time
            
            // Stop motors
            motf.setPower(0);
            motb.setPower(0);
            
            sleep(500);
            
            motf.setPower(1);
            motb.setPower(-1);

            sleep(540); // Run for calculated time
            
            // Stop motors
            motf.setPower(0);
            motb.setPower(0);
            
            sleep(500);
        }
    }
}
