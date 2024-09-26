package frc.robot;

public class Constants
{
    public class driveConstants
    {
        public static final double FOREWARD_SPEED_MULTIPLIER = 0.65;
        public static final double ROTATION_SPEED_MULTIPLIER = 0.4;
        public static final double CONTROLLER_DEADZONE = 0.3;
        public static final double CONTROLLER_Z_AXIS_DEADZONE = 0.4;

        public static final int FRONT_RIGHT_MOTOR = 3;
        public static final int FRONT_LEFT_MOTOR = 2;
        public static final int BACK_RIGHT_MOTOR = 4;
        public static final int BACK_LEFT_MOTOR = 1;

        public static final int AUTOCONFIG = 4;
        // public static final double AUTOSPEED = 0;
        public static final double AUTOSPEED = 0.45;
    }

    public class armConstants
    {
        public static final int FRONT_ARM_PORT_0 = 2;
        public static final int FRONT_ARM_PORT_1 = 3;
        public static final int BACK_ARM_PORT_0 = 0;
        public static final int BACK_ARM_PORT_1 = 1;
        public static final int GRAB_PORT_0 = 4;
        public static final int GRAB_PORT_1 = 5;
        public static final int DEPLOY_PORT_0 = 6;
        public static final int DEPLOY_PORT_1 = 7;

        public final static int FRONT_MOTOR = 7;
        public final static int BACK_MOTOR = 6;

        public final static double FRONT_MOTOR_SPEED = 0.45;
        public static final double BACK_MOTOR_SPEED = 0.6;
    }
}
