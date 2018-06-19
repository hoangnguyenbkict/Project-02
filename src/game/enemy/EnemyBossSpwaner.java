//package game.enemy;
//
//import action.ActionAdapter;
//import action.LimitAction;
//import action.SequenceAction;
//import action.WaitAction;
//import base.GameObject;
//import base.GameObjectManager;
//
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Random;
//
//public class EnemyBossSpwaner extends GameObject {
//
//    private List<EnemyBoss> list;
//    private Random random;
//    public EnemyBoss enemyBoss;
//
//    public EnemyBossSpwaner() {
//        this.random = new Random();
//        this.enemyBoss = new EnemyBoss();
//    }
//
//    public void creatAction(){
//        this.addAction(
//                new LimitAction(
//                        new SequenceAction(
//                                new WaitAction(10),
//                                new ActionAdapter(){
//                                    @Override
//                                    public boolean run(GameObject owner) {
//                                        EnemyBoss enemyBoss = GameObjectManager.instance.recycle(EnemyBoss.class);
//                                        enemyBoss.position.set(random.nextInt(1024), random.nextInt(600));
//                                        GameObjectManager.instance.add(enemyBoss);
//                                        return true;
//                                    }
//                                }
//                        ),
//                        5
//                )
//        );
//    }
//
//    @Override
//    public void run() {
//        super.run();
//    }
//}
