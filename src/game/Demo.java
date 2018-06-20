package game;

import base.GameObject;
import renderer.TextRenderer;

import java.awt.*;

public class Demo extends GameObject {

    public Demo() {
        this.position.set(40,400);
        this.renderer = new TextRenderer(
                "Hello World",
                Color.cyan,
                "resources/FiraMono-Bold.ttf",
                10
        );
    }
}
