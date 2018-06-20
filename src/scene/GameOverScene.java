package scene;

import base.GameObjectManager;
import game.background.Background;
import game.star.StarSpawner;

public class GameOverScene implements Scene {
    @Override
    public void init() {
        GameObjectManager.instance.add(new Background());
        GameObjectManager.instance.add(new StarSpawner());
    }

    @Override
    public void deinit() {
        GameObjectManager.instance.clear();
    }
}
