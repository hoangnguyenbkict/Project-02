package game.effect;

import base.FrameCounter;
import base.GameObject;
import base.Vector2D;
import game.player.Player;
import game.player.PlayerMove;
import renderer.ImageRenderer;

import java.awt.*;

public class Smoke extends GameObject {

    public Vector2D velocity;
    private FrameCounter frameCounter;

    public Smoke() {
        this.renderer = new ImageRenderer("resources/images/circle.png",15,15,Color.CYAN);
        this.velocity = new Vector2D();
        this.frameCounter = new FrameCounter(2);
    }

    @Override
    public void run() {
        super.run();
        if (this.frameCounter.run()) {
            this.position.subtractBy(this.velocity);
            ImageRenderer imageRenderer = (ImageRenderer) this.renderer;
            if (imageRenderer != null) {
                imageRenderer.width -= 1;
                imageRenderer.height -= 1;
                if (imageRenderer.width == 0 || imageRenderer.height == 0) {
                    isAlive = false;
                }
            }
            this.frameCounter.reset();
        }
    }
}
