package game.effect;

import base.FrameCounter;
import base.GameObject;
import base.GameObjectManager;

import java.util.Random;

public class TripleShootSpawner extends GameObject {
    private FrameCounter frameCounterShoot;
    private Random random;

    public TripleShootSpawner() {
        this.frameCounterShoot = new FrameCounter(200);
        this.random = new Random();
    }

    @Override
    public void run(){
        super.run();
        if(this.frameCounterShoot.run()){
            TripleShootEffect tripleShoot = GameObjectManager.instance.recycle(TripleShootEffect.class);
            tripleShoot.position.set(this.random.nextInt(1024), this.random.nextInt(600));
            GameObjectManager.instance.add(tripleShoot);
            this.frameCounterShoot.reset();
        }
    }
}
