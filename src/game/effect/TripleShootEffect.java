package game.effect;

import base.GameObject;
import base.GameObjectManager;
import game.player.Player;
import physic.BoxCollider;
import physic.PhysicBody;
import physic.RunHitObject;
import renderer.ImageRenderer;

import java.awt.*;

public class TripleShootEffect extends GameObject implements PhysicBody {

    public BoxCollider boxCollider;
    private RunHitObject runHitObject;

    public TripleShootEffect() {
        this.renderer = new ImageRenderer("resources/images/powerup_triple_shot.png",20,20,Color.YELLOW);
        this.boxCollider = new BoxCollider(20,20);
        this.runHitObject = new RunHitObject(
                Player.class
        );
    }

    @Override
    public void run(){
        super.run();
        this.boxCollider.position.set(this.position.x -10, this.position.y - 10);
        this.runHitObject.run(this);
    }

    @Override
    public BoxCollider getBoxCollider() {
        return this.boxCollider;
    }

    @Override
    public void getHit(GameObject gameObject) {
        if (gameObject instanceof Player) {
            this.isAlive = false;

        }
    }
}

