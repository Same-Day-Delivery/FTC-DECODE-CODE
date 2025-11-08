package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;

@Autonomous(name = "TankDriveAutoCircle", group = "Autonomous")
public class TankDriveAutoCircle extends LinearOpMode {
    private DcMotor FR;
    private DcMotor FL;
    private DcMotor BR;
    private DcMotor BL;
    
    // Variables
    
    static final double INCREMENT   = 0.001;     // amount to slew servo each CYCLE_MS cycle
    static final int    CYCLE_MS    =   50;     // period of each cycle
    static final double MAX_POS     =  1.0;     // Maximum rotational position
    static final double MIN_POS     =  0.0;
    
    
    // Define class members
    Servo   servo;
    double  position = (MAX_POS - MIN_POS) / 2; // Start at halfway position
    boolean rampUpleft = false;
    boolean rampUpright = false;

    @Override
    public void init() {
        
        // Motors
        
        FR = hardwareMap.get(DcMotor.class, "FR");
        FL = hardwareMap.get(DcMotor.class, "FL");  
        BR = hardwareMap.get(DcMotor.class, "BR");
        BL = hardwareMap.get(DcMotor.class, "BL");  

        FR.setDirection(DcMotor.Direction.REVERSE);
        FL.setDirection(DcMotor.Direction.FORWARD);
        BL.setDirection(DcMotor.Direction.FORWARD);
        BR.setDirection(DcMotor.Direction.REVERSE);
        
        // Servos
        
        servo = hardwareMap.get(Servo.class, "S1");
        
        // IMU
        
        // Retrieve the IMU from the hardware map
        IMU imu = hardwareMap.get(IMU.class, "imu");
        // Adjust the orientation parameters to match your robot
        IMU.Parameters parameters = new IMU.Parameters(new RevHubOrientationOnRobot(
                RevHubOrientationOnRobot.LogoFacingDirection.UP,
                RevHubOrientationOnRobot.UsbFacingDirection.FORWARD));
        // Without this, the REV Hub's orientation is assumed to be logo up / USB forward
        imu.initialize(parameters);
    }    

    @Override
    public void runOpMode() {
        FR = hardwareMap.get(DcMotor.class, "FR");
        FL = hardwareMap.get(DcMotor.class, "FL");
        BR = hardwareMap.get(DcMotor.class, "BR");
        BL = hardwareMap.get(DcMotor.class, "BL");

        FR.setDirection(DcMotor.Direction.FORWARD);
        FL.setDirection(DcMotor.Direction.REVERSE);
        BR.setDirection(DcMotor.Direction.FORWARD);
        BL.setDirection(DcMotor.Direction.REVERSE);

        waitForStart();
    }
    @Override
    public void loop() {
        // Get joystick values
        double y = -gamepad1.left_stick_y; // Remember, Y stick value is reversed
        double x = gamepad1.left_stick_x * 1.1; // Counteract imperfect strafing
        double rx = gamepad1.right_stick_x;
        
       
        
        
        // Denominator is the largest motor power (absolute value) or 1
        // This ensures all the powers maintain the same ratio,
        // but only if at least one is out of the range [-1, 1]
        double denominator = Math.max(Math.abs(y) + Math.abs(x) + Math.abs(rx), 1);
        double frontLeftPower = (y + x + rx) / denominator;
        double backLeftPower = (y - x + rx) / denominator;
        double frontRightPower = (y - x - rx) / denominator;
        double backRightPower = (y + x - rx) / denominator;
        
        
        
        // Set motor powers
        FL.setPower(frontLeftPower);
        FR.setPower(frontRightPower);
        BL.setPower(backLeftPower);
        BR.setPower(backRightPower);
        
        
        // Servo code
        if(gamepad1.leftBumperWasPressed()) {
            rampUpleft = true;
        }
        if(gamepad1.leftBumperWasReleased()) {
            rampUpleft = false;
        }
        if(gamepad1.rightBumperWasPressed()) {
            rampUpright = true;
        }
        if(gamepad1.rightBumperWasReleased()) {
            rampUpright = false;
        }
        if(rampUpright) {
            position -= INCREMENT;
            servo.setPosition(position);
        }
        if(rampUpleft) {
            position += INCREMENT;
            servo.setPosition(position);
        }
        if(position<0){
            position = 0;
        }
        if(position>1){
            position = 1;
        }
        if(gamepad1.bWasPressed()){
            servo.setPosition(1);
            
        }
        if(gamepad1.aWasPressed()){
            servo.setPosition(0);
        }

        // Display telemetry for debugging
        telemetry.addData("Button Pressed:", gamepad1.toString() );
        telemetry.update();
    }
}
