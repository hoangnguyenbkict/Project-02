package game.effect;

import base.FrameCounter;
import base.GameObject;
import base.GameObjectManager;
import base.Vector2D;
import game.bullet.Bullet;
import game.player.Player;
import game.player.Shoot;
import game.player.SingleShoot;
import renderer.ImageRenderer;

import java.awt.*;

public class CreatSmoke extends GameObject  {

    private FrameCounter frameCounter;
    public Shoot shoot;

    public CreatSmoke() {
        this.frameCounter = new FrameCounter(10);
        this.shoot = new SingleShoot();
    }

    public void run(Player player) {
        if (this.frameCounter.run()) {
            Smoke smoke = GameObjectManager.instance.recycle(Smoke.class);
            smoke.renderer = new ImageRenderer("resources/images/circle.png",15,15,Color.CYAN);
            smoke.position.set(player.position);

            Vector2D rotate = player.playerMove.velocity.add(
                    (new Vector2D(2, 0)).rotate(player.playerMove.angle));

            smoke.velocity.set(rotate);
            this.frameCounter.reset();
        }
    }
}
