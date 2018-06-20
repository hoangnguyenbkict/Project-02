
import base.GameObjectManager;
//import game.enemy.EnemyBossSpwaner;
import game.player.Player;
import input.KeyboardInput;
import input.MouseInput;
import scene.GamePlayScene;
import scene.SceneManager;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

public class GameCanvas extends JPanel {
    BufferedImage backBuffered;
    Graphics graphics;

    public Player player;


    public GameCanvas() {
        this.setSize(1024, 600);
        this.setupBackBuffered();

        SceneManager.instance.changeScene(new GamePlayScene());

        this.setVisible(true);
    }

    private void setupBackBuffered() {
        this.backBuffered = new BufferedImage(1024, 600, BufferedImage.TYPE_4BYTE_ABGR);
        this.graphics = this.backBuffered.getGraphics();
    }



    @Override
    protected void paintComponent(Graphics g) {
        // lat backbuffered
        g.drawImage(this.backBuffered, 0, 0, null);
    }

    public void renderAll() {
        GameObjectManager.instance.renderAll(this.graphics);
        this.repaint();
    }

    public void runAll() {
       GameObjectManager.instance.runAll();
       KeyboardInput.instance.reset();
        MouseInput.instance.reset();
        SceneManager.instance.performChangeSceneIfNeeded();
    }
}

