package gfx;

import tools.Tool;

public class GLTools {
    public static double glMapX(double x) {
        return Tool.mapTo((float) x, 0.0f, 100f, -1.0f, 1.0f);
    }
    public static float glMapY(float y) {
        return (float) Tool.mapTo(y, 0.0f, 100f, -1.0f, 1.0f);
    }

    public static double[] getPointByAngle(double x, double y, double angle, double distance) {
        double xResult = x + Math.cos(Math.toRadians(angle + 90)) * distance;
        double yResult = y + Math.sin(Math.toRadians(angle + 90)) * distance;
        return new double[]{xResult, yResult};
    }
}


