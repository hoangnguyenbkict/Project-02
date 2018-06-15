package game.effect;

import base.FrameCounter;
import base.GameObject;
import base.GameObjectManager;

import java.util.Random;

public class ShieldSpawner extends GameObject {
    private FrameCounter frameCounterShield;
    private Random random;

    public ShieldSpawner() {
        this.frameCounterShield = new FrameCounter(200);
        this.random = new Random();
    }

    public void run(){
        if(this.frameCounterShield.run()){
            Shield shield = GameObjectManager.instance.recycle(Shield.class);
            shield.position.set(this.random.nextInt(1024), this.random.nextInt(600));
            GameObjectManager.instance.add(shield);
            this.frameCounterShield.reset();
        }
    }
}


