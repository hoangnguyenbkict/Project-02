package game.effect;

import base.GameObject;
import base.Vector2D;
import game.player.Player;
import game.player.PlayerMove;
import renderer.ImageRenderer;

public class Smoke extends GameObject {

    public Vector2D velocity;
    public PlayerMove playerMove;

    public Smoke() {
        this.renderer = new ImageRenderer("resources/images/circle.png",15,15);
        this.velocity = new Vector2D();
        this.playerMove = new PlayerMove();
    }

    @Override
    public void run(){
        super.run();
        this.position.subtractBy(this.velocity);
    }
}
