//package game.effect;
//
//import action.ActionAdapter;
//import action.LimitAction;
//import action.SequenceAction;
//import action.WaitAction;
//import base.GameObject;
//
//import java.util.Random;
//
//public class EffectSpawner extends GameObject {
//
//    private Random random;
//    private Boolean surprise;
//    public ShieldSpawner shieldSpawner;
//    public TripleShootSpawner tripleShootSpawner;
//
//    public EffectSpawner() {
//        this.shieldSpawner = new ShieldSpawner();
//        this.tripleShootSpawner = new TripleShootSpawner();
//        this.random = new Random();
//    }
//
//    public void randomEffect(){
//        if(this.surprise == true){
//            this.shieldSpawner.run();
//        }else{
//            this.tripleShootSpawner.run();
//        }
//    }
//
//    public void creatEffect(){
//        this.addAction(
//                new LimitAction(
//                        new SequenceAction(
//                                new WaitAction(900),
//                                new ActionAdapter(){
//                                    @Override
//                                    public boolean run(GameObject owner) {
//
//                                        return true;
//                                    }
//                                }
//                        )
//
//                )
//        );
//    }
//}
