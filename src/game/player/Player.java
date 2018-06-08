package game.player;

import base.GameObject;
import base.GameObjectManager;
import base.Vector2D;
import game.enemy.Enemy;
import physic.BoxCollider;
import renderer.PolygonRenderer;

import java.awt.*;

public class Player extends GameObject {

    public PlayerMove playerMove;
    public PlayerShoot playerShoot;
    public BoxCollider boxCollider;

    public Player() {
        this.renderer = new PolygonRenderer(
                Color.RED,
                new Vector2D(),
                new Vector2D(0, 16),
                new Vector2D(20, 8)
        );
        this.playerMove = new PlayerMove();
        this.playerShoot = new PlayerShoot();
        this.boxCollider = new BoxCollider(20,20);
    }

    @Override
    public void run() {
        super.run();
        this.playerMove.run(this);
        this.playerShoot.run(this);
        this.boxCollider.position.set(this.position.x - 10, this.position.y -10);
        Player player = GameObjectManager.instance.checkCollision1(this);
        if(player != null){
            player.isAlive = false;
            this.isAlive = false;
            System.out.println("hit");
        }
        ((PolygonRenderer) this.renderer).angle = this.playerMove.angle;
    }
}

