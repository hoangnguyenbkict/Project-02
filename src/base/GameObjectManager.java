package base;

import game.player.Player;

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
        this.list.forEach(gameObject -> gameObject.run());
        this.list.addAll(this.tempList);
        this.tempList.clear();
    }

    public void renderAll(Graphics graphics){
        this.list.forEach(gameObject -> gameObject.render(graphics));
    }

    public Player findPlayer(){
        return (Player) this.list
                .stream()
                .filter(gameObject -> gameObject instanceof Player)
                .findFirst()
                .orElse(null);
    }
}
