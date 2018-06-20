package game;

import base.GameObject;
import base.GameObjectManager;
import input.MouseInput;
import scene.GamePlayScene;
import scene.SceneManager;

public class StartButton extends GameObject {
    @Override
    public void run() {
        super.run();
        if(MouseInput.instance.isClicked && MouseInput.instance.position.x >= 0){
            SceneManager.instance.changeScene(new GamePlayScene());
        }
    }
}
