package game.effect;

import base.GameObject;
import game.player.Player;
import physic.BoxCollider;
import physic.PhysicBody;
import physic.RunHitObject;
import renderer.ImageRenderer;

public class Shield extends GameObject implements PhysicBody {

    public BoxCollider boxCollider;
    private RunHitObject runHitObject;

    public Shield() {
        this.renderer = new ImageRenderer("resources/images/powerup_shield.png",20,20);
        this.boxCollider = new BoxCollider(20,20);
        this.runHitObject = new RunHitObject(
                Player.class
        );
    }

    @Override
    public void run(){
        super.run();
        this.boxCollider.position.set(this.position.x -10, this.position.y - 8);
        this.runHitObject.run(this);
    }

    @Override
    public BoxCollider getBoxCollider() {
        return this.boxCollider;
    }

    @Override
    public void getHit(GameObject gameObject) {
        if (gameObject instanceof Player) {
            isAlive = false;
        }
    }
}
