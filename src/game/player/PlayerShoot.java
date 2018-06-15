package game.player;

import base.FrameCounter;
import base.GameObjectManager;
import base.Vector2D;
import game.bullet.Bullet;
import input.KeyboardInput;

public class PlayerShoot {

    private FrameCounter frameCounter, frameCounterSingleShoot;
    public Shoot shoot;
    public SingleShoot singleShoot;
    public TripleShoot tripleShoot;

    public PlayerShoot() {
        this.frameCounter = new FrameCounter(5);
        this.frameCounterSingleShoot = new FrameCounter(100);
        this.tripleShoot = new TripleShoot();
        this.shoot = new SingleShoot();
    }

    public void run(Player player) {
        if (KeyboardInput.instance.spacePressed) {
            if (this.frameCounter.run()) {
                this.shoot.shoot(player);
                this.frameCounter.reset();
            }
            if(this.frameCounterSingleShoot.run()){
                this.shoot = new SingleShoot();
                this.frameCounterSingleShoot.reset();
            }
        }
    }
}
