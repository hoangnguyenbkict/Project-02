import java.awt.*;
import java.util.ArrayList;
import java.util.List;

// singleton: chi khoi tao 1 object duy nhat trong 1 class luon luon de la private o contructor
public class GameObjectManager {

    public static GameObjectManager instance = new GameObjectManager(); // goi bien thong qua class ma khong phai khoi tao object

    private List<GameObject> list;

   private GameObjectManager() {
        this.list = new ArrayList<>();
    }

    public void add(GameObject gameObject){
        this.list.add(gameObject);
    }

    public void runAll(){
        this.list.forEach(gameObject -> gameObject.run());
    }

    public void renderAll(Graphics graphics){
        this.list.forEach(gameObject -> gameObject.render(graphics));
    }

}
