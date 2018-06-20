package game.enemy;

import action.ActionAdapter;
import action.LimitAction;
import action.SequenceAction;
import action.WaitAction;
import base.GameObject;
import base.GameObjectManager;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class EnemySpawner extends GameObject {

    private Random random;

    public EnemySpawner() {
        this.random = new Random();
       // this.creatAction();
        this.creatAction2();
    }

    public void creatAction(){
       this.addAction(
               new LimitAction(
                       new SequenceAction(
                               new WaitAction(300),
                               new ActionAdapter(){
                                   @Override
                                   public boolean run(GameObject owner) {
                                       Enemy enemy = GameObjectManager.instance.recycle(Enemy.class);
                                       enemy.position.set(random.nextInt(1024), random.nextInt(600));
                                       GameObjectManager.instance.add(enemy);
                                       return true;
                                   }
                               }
                       ),
                       70
               )
       );
    }

    public void creatAction2(){
        this.addAction(
                new SequenceAction(
                        new WaitAction(30),
                        new ActionAdapter(){

                            private List<Enemy> list = new ArrayList<>();
                            private int count = 0;

                            @Override
                            public boolean run(GameObject owner) {
                                if (list.isEmpty()) {
                                    // frame
                                    Enemy enemy = GameObjectManager.instance.recycle(Enemy.class);
                                    enemy.position.set(random.nextInt(1024), random.nextInt(600));
                                    this.count += 1;
                                    list.add(enemy);
                                }

                                list.removeIf(enemy -> !enemy.isAlive);

                                return this.count == 5;
                            }
                        }
                )
        );
    }

//    public void creatEnemyShoot(){
//        this.addAction(
//                new WaitAction(500),
//                new LimitAction(
//                        new SequenceAction(
//
//                        ),5)
//        );
//    }

    @Override
    public void run() {
        super.run();
//        if (this.frameCounter.run()) {
//            // tao enemy
//            Enemy enemy = GameObjectManager.instance.recycle(Enemy.class);
//            enemy.position.set(this.random.nextInt(1024), this.random.nextInt(600));
//            GameObjectManager.instance.add(enemy);
//            this.frameCounter.reset();
//        }
    }
}