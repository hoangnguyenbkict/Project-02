package game.effect;
import base.GameObject;
import base.GameObjectManager;
import base.Vector2D;
import renderer.ImageRenderer;

import java.awt.*;
import java.util.Random;

public class CreatExplosion extends GameObject {
    private Random random;

    public CreatExplosion() {
        this.random = new Random();
    }

    public void run() {
        for (double angle1 = 0.0; angle1 <= 360; angle1 += 20) {
            this.random = new Random();
            for (double angle = 0.0; angle <= 360.0; angle += random.nextInt(20) + 10) {
                Explosion explosion = GameObjectManager.instance.recycle(Explosion.class);
                explosion.renderer = new ImageRenderer("resources/images/star.png", 5, 5, Color.CYAN);
                explosion.position.set(this.position);
                this.random = new Random();
                explosion.velocity.set((new Vector2D(this.random.nextInt(3) + 1, 0)).rotate(angle));
                explosion.run();

            }
        }
    }
}
