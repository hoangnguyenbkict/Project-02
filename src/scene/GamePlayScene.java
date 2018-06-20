package scene;

import base.GameObject;
import base.GameObjectManager;
import game.Demo;
import game.background.Background;
import game.effect.ShieldSpawner;
import game.effect.TripleShootSpawner;
import game.enemy.EnemySpawner;
import game.player.Player;
import game.star.StarSpawner;
import utils.Utils;

import javax.sound.sampled.Clip;

public class GamePlayScene extends GameObject implements Scene {

    private Clip clip;

    @Override
    public void init() {
        this.setupCharacter();
        GameObjectManager.instance.recycle(Demo.class);
        this.clip = Utils.loadAudio("resources/audio/boost.wav");

//        this.clip.loop(-1);
//        this.clip.start();
    }

    @Override
    public void deinit() {
        GameObjectManager.instance.clear();
        this.clip.stop();
    }

    private void setupCharacter() {
        GameObjectManager.instance.add(new Background());

        this.setupPlayer();
        GameObjectManager.instance.add(new ShieldSpawner());
        GameObjectManager.instance.add(new StarSpawner());
        GameObjectManager.instance.add(new TripleShootSpawner());
        GameObjectManager.instance.add(new EnemySpawner());
//        GameObjectManager.instance.add(new EnemyBossSpwaner());
    }

    private void setupPlayer() {
        Player player = GameObjectManager.instance.recycle(Player.class);
        player.position.set(500, 300);
        player.playerMove.velocity.set(4, 0);

    }
}
