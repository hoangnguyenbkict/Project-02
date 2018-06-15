package game.player;

import base.GameObject;
import base.Vector2D;
import game.effect.Shield;
import game.effect.TripleShootEffect;
import game.enemy.Enemy;
import physic.BoxCollider;
import physic.PhysicBody;
import physic.RunHitObject;
import renderer.PolygonRenderer;

import java.awt.*;

public class Player extends GameObject implements PhysicBody {
    public PlayerMove playerMove;
    public PlayerShoot playerShoot;
    public BoxCollider boxCollider;
    private RunHitObject runHitObject;
    private int count;

    public Player() {
        this.position = new Vector2D();
        this.renderer = new PolygonRenderer(
                Color.RED,
                new Vector2D(),
                new Vector2D(0, 16),
                new Vector2D(20, 8)
        );
        this.playerMove = new PlayerMove();
        this.playerShoot = new PlayerShoot();
        this.boxCollider = new BoxCollider(20,16);
        this.runHitObject = new RunHitObject(
                Enemy.class,
                Shield.class,
                TripleShootEffect.class
        );
        this.count = 0;
    }

    @Override
    public void run() {
        super.run();
        this.boxCollider.position.set(this.position.x -10, this.position.y - 8);
        this.playerMove.run(this);
        this.playerShoot.run(this);
        this.runHitObject.run(this);
        ((PolygonRenderer) this.renderer).angle = this.playerMove.angle;
    }

    @Override
    public BoxCollider getBoxCollider() {
        return this.boxCollider;
    }

    @Override
    public void getHit(GameObject gameObject) {
        if(gameObject instanceof Enemy) {
            if(this.count == 0){
                isAlive = false;
            }else{
                this.count -= 1;
            }
        }
        if(gameObject instanceof Shield){
            this.count = 3;
        }
        if(gameObject instanceof TripleShootEffect){
            this.playerShoot.shoot = new TripleShoot();
        }
    }

    @Override
    public void render(Graphics graphics){
        super.render(graphics);
        if(this.count > 0){
            graphics.setColor(Color.RED);
            for(int i = 30; i < 40; i++) {
                graphics.drawOval((int) this.position.x - i/2, (int) this.position.y - i/2, i,i);
            }
        }
    }

}