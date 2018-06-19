package game.enemy;

import base.GameObject;
import base.GameObjectManager;
import base.Vector2D;
import game.bullet.Bullet;

import java.util.Random;


public class EnemyShoot extends GameObject {

    private Random random;

    public EnemyShoot() {
        this.random = new Random();
    }

    public void run(Enemy enemy) {
            for (double angle = 0.0; angle <= 360.0; angle += 15.0) {
                Bullet bulletEnemy = new Bullet();
                bulletEnemy.position.set(enemy.position);
                bulletEnemy.velocity.set(
                        (new Vector2D(3, 0)).rotate(angle));
                GameObjectManager.instance.add(bulletEnemy);
            }
    }
}

