//package game.enemy;
//
//import base.GameObject;
//import base.GameObjectManager;
//import base.Vector2D;
//import game.player.Player;
//import physic.BoxCollider;
//import physic.PhysicBody;
//import renderer.ImageRenderer;
//
//import java.awt.*;
//import java.util.ArrayList;
//import java.util.List;
//
//public class EnemyBoss extends GameObject implements PhysicBody {
//
//    public Vector2D velocity;
//    public BoxCollider boxCollider;
//    private EnemyShoot enemyShoot;
//
//    public EnemyBoss() {
//        this.velocity = new Vector2D();
//        this.enemyShoot = new EnemyShoot();
//        this.boxCollider = new BoxCollider(20,20);
//        this.renderer = new ImageRenderer("resources/images/circle.png", 20, 20, Color.PINK);
//
//    }
//
//
//    @Override
//    public void run() {
//        super.run();
//        this.position.addUp(this.velocity);
//        this.enemyShoot.run(this);
//        this.boxCollider.position.set(this.position.x - 10, this.position.y - 10);
//        Player player = GameObjectManager.instance.findPlayer();
//        if (player != null) {
//            this.velocity.set(
//                    player.position
//                            .subtract(this.position)
//                            .normalize()
//                            .multiply(0.5f)
//            );
//        }
//    }
//
//    @Override
//    public BoxCollider getBoxCollider() {
//        return this.boxCollider;
//    }
//
//    @Override
//    public void getHit(GameObject gameObject) {
//        this.isAlive = false;
//    }
//}
