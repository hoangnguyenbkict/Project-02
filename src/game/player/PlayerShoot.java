package game.player;

import base.FrameCounter;
import base.GameObjectManager;
import base.Vector2D;
import game.bullet.Bullet;
import input.KeyboardInput;
import utils.Utils;

import javax.sound.sampled.Clip;

public class PlayerShoot {

    private FrameCounter frameCounter, frameCounterSingleShoot;
    public Shoot shoot;
    public SingleShoot singleShoot;
    public TripleShoot tripleShoot;
    private Clip clip;

    public PlayerShoot() {
        this.frameCounter = new FrameCounter(3);
        this.frameCounterSingleShoot = new FrameCounter(100);
        this.tripleShoot = new TripleShoot();
        this.shoot = new SingleShoot();
        this.clip = Utils.loadAudio("resources/audio/boost.wav");
    }

    public void run(Player player) {
        if (KeyboardInput.instance.spacePressed) {

            if (this.frameCounter.run()) {
                this.shoot.shoot(player);
                this.clip.loop(1);
                this.clip.start();
                this.frameCounter.reset();
            }
            if(this.frameCounterSingleShoot.run()){
                this.shoot = new SingleShoot();
                this.frameCounterSingleShoot.reset();
            }
        }
    }
}
