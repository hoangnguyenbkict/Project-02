package game.background;

import base.GameObject;
import renderer.BackgroundRenderer;
import renderer.Renderer;

import java.awt.*;

public class Background extends GameObject {

    public Renderer renderer;


    public Background() {
        this.renderer = new BackgroundRenderer(1024, 600, Color.BLACK);
    }

    @Override
    public void render(Graphics graphics) {
        super.render(graphics);
        this.renderer.render(graphics, this.position);
    }
}
