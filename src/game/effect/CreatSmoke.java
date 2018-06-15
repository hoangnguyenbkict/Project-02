package game.effect;

import base.FrameCounter;
import base.GameObject;
import base.GameObjectManager;
import base.Vector2D;
import game.bullet.Bullet;
import game.player.PlayerMove;

public class CreatSmoke extends GameObject  {

    private FrameCounter frameCounter;

    public CreatSmoke() {

        this.frameCounter = new FrameCounter(20);
    }

    @Override
    public void run(){
        super.run();
        if(this.frameCounter.run()){
            Smoke smoke = GameObjectManager.instance.recycle(Smoke.class);
            smoke.position.set(position);

            Vector2D rotate = smoke.playerMove.velocity.add(
                    (new Vector2D(1, 0)).rotate(smoke.playerMove.angle));

            smoke.velocity.set(rotate);
            this.frameCounter.reset();
        }

    }
}
