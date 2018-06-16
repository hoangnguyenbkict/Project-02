package game.star;

import action.*;
import base.FrameCounter;
import base.GameObject;
import base.GameObjectManager;
import game.star.Star;

import java.util.Random;

public class StarSpawner extends GameObject {
//    private FrameCounter frameCounter;
    private Random random;

    public StarSpawner() {
        this.random = new Random();
        this.creatAction();
//        this.frameCounter = new FrameCounter(30);
    }

    public void creatAction(){
//        Action waitAction = new WaitAction(20);
//        Action creatAction = new ActionAdapter() {
//
//            @Override
//            public boolean run(GameObject owner) {
//                Star star = GameObjectManager.instance.recycle(Star.class);
//                star.position.set(1024,random.nextInt(600));
//                star.velocity.set(-(random.nextInt(3) + 1), 0);
//                return true;
//            }
//        };
//
//        Action sequenceAction = new SequenceAction(waitAction, creatAction);
//        Action repeatAction = new RepeatActionForever(sequenceAction);
//
//        this.addAction(repeatAction);

//        this.addAction(
//                new RepeatActionForever(
//                         new SequenceAction(
//                                 new WaitAction(20),
//                                 new ActionAdapter() {
//                                     @Override
//                                     public boolean run(GameObject owner) {
//                                         Star star = GameObjectManager.instance.recycle(Star.class);
//                                         star.position.set(1024,random.nextInt(600));
//                                         star.velocity.set(-(random.nextInt(3) + 1), 0);
//                                         return true;
//                                     }
//                                 }
//                         )
//                )
//        );
        this.addAction(
                new LimitAction(
                        new SequenceAction(
                                 new WaitAction(20),
                                 new ActionAdapter() {
                                     @Override
                                     public boolean run(GameObject owner) {
                                         Star star = GameObjectManager.instance.recycle(Star.class);
                                         star.position.set(1024,random.nextInt(600));
                                         star.velocity.set(-(random.nextInt(3) + 1), 0);
                                         return true;
                                     }
                                 }
                         ),
                        10
                )
        );
    }

    @Override
    public void run() {
        super.run();
//        if (this.frameCounter.run()) {
//            Star star = new Star();
//            star.position.set(1024, this.random.nextInt(600));
//            star.velocity.set(-(this.random.nextInt(3) + 1), 0);
//            GameObjectManager.instance.add(star);
//            this.frameCounter.reset();
//        }
    }
}
