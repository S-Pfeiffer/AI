public class GLTools {
    public static float glMapX(int x) {
        return (2.0f * x / GLGlobals.SCREEN_WIDTH) - 1.0f;
    }

    public static float glMapY(int y) {
        return 1.0f - (2.0f * y / GLGlobals.SCREEN_HEIGHT);
    }
}


