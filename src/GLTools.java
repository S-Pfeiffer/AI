public class GLTools {
    public static double glMapX(double x) {
        return Tool.mapTo((float) x, 0.0f, 100f, -1.0f, 1.0f);
    }
    public static float glMapY(float y) {
        return (float) Tool.mapTo(y, 0.0f, 100f, -1.0f, 1.0f);
    }
}


