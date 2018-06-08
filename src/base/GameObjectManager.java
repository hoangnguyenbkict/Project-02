package base;

import game.bullet.Bullet;
import game.enemy.Enemy;
import game.player.Player;
import game.player.PlayerMove;
import physic.BoxCollider;
import renderer.PolygonRenderer;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

// singleton: chi khoi tao 1 object duy nhat trong 1 class luon luon de la private o contructor
public class GameObjectManager {

    public static GameObjectManager instance = new GameObjectManager(); // goi bien thong qua class ma khong phai khoi tao object

    private List<GameObject> list;
    private List<GameObject> tempList;

    private GameObjectManager() {
        this.list = new ArrayList<>();
        this.tempList = new ArrayList<>();
    }

    public void add(GameObject gameObject){
        this.tempList.add(gameObject);
    }

    public void runAll(){
        this.list.stream()
                .filter(gameObject -> gameObject.isAlive)
                .forEach(gameObject -> gameObject.run());
        this.list.addAll(this.tempList);
        this.tempList.clear();
    }

    public void renderAll(Graphics graphics){
        this.list
                .stream()
                .filter(gameObject -> gameObject.isAlive)
                .forEach(gameObject -> gameObject.render(graphics));
    }

    public Player findPlayer(){
        return (Player) this.list
                .stream()
                .filter(gameObject -> gameObject instanceof Player)
                .findFirst()
                .orElse(null);
    }

    public Enemy checkCollision(Bullet bullet){
        return (Enemy) this.list
                .stream()
                .filter(gameObject -> gameObject.isAlive)
                .filter(gameObject -> gameObject instanceof Enemy)
                .filter(gameObject -> {
                    BoxCollider other = ((Enemy) gameObject).boxCollider;
                    return bullet.boxCollider.checkCoxCollider(other);
                })
                .findFirst()
                .orElse(null);
        }
    public Player checkCollision1(Enemy enemy){
        return (Player) this.list.stream().filter(gameObject -> gameObject.isAlive).filter(gameObject -> gameObject instanceof Player).filter(gameObject ->{
            BoxCollider other = ((Player) gameObject).boxCollider;
            return enemy.boxCollider.checkCoxCollider(other);
        }).findFirst().orElse(null);
    }
}
