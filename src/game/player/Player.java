package game.player;

import base.FrameCounter;
import base.GameObject;
import base.GameObjectManager;
import base.Vector2D;
import game.bullet.Bullet;

import game.effect.CreatSmoke;
import game.effect.Shield;
import game.effect.Smoke;
import game.effect.TripleShootEffect;
import game.enemy.Enemy;
import game.enemy.EnemyShoot;
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
    private FrameCounter frameCounter;
    public CreatSmoke creatSmoke;
    public EnemyShoot enemyShoot;

    public Player() {
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
        this.frameCounter = new FrameCounter(20);
        this.creatSmoke = new CreatSmoke();
        this.enemyShoot = new EnemyShoot();
    }

    @Override
    public void run() {
        super.run();
        this.boxCollider.position.set(this.position.x -10, this.position.y - 8);
        this.playerMove.run(this);
        this.playerShoot.run(this);
        this.runHitObject.run(this);
        this.creatSmoke.run(this);
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
                this.enemyShoot.run(this);
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