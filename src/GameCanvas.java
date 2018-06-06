import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class GameCanvas extends JPanel {
    BufferedImage backBuffered;
    Graphics graphics;

    Background background;
    public Player player;
    private EnemySpawner enemySpawner = new EnemySpawner();
    private StarSpawner starSpawner = new StarSpawner();

    public GameCanvas() {
        this.setSize(1024, 600);
        this.setupBackBuffered();
        this.setupCharacter();

        this.setVisible(true);
    }

    private void setupBackBuffered() {
        this.backBuffered = new BufferedImage(1024, 600, BufferedImage.TYPE_4BYTE_ABGR);
        this.graphics = this.backBuffered.getGraphics();
    }

    private void setupCharacter() {
        this.background = new Background();

        this.setupPlayer();

    }

    private void setupPlayer() {
        this.player = new Player();
        this.player.position.set(500, 300);
        this.player.playerMove.velocity.set(4, 0);
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
    }
}

