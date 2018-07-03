package constant;

import base.Vector2D;

public class Constant {

    public static class Window {
        public static final int WIDTH = 1024;
        public static final int HEIGHT = 600;
    }

    public static class Player {
        public static final Vector2D[] VERTICES = {
                new Vector2D(),
                new Vector2D(0, 16),
                new Vector2D(20, 8)
        };
    }
}
