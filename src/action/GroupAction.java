package action;

import base.GameObject;

import java.util.Arrays;
import java.util.List;

public class GroupAction implements Action{

    private List<Action> actions;
//    private int count;

    public GroupAction(Action... actions) {
        this.actions = Arrays.asList(actions);
    }

    @Override
    public boolean run(GameObject owner) {
//        this.actions.forEach(action -> {
//            if(action.run(owner)){
//                count += 1;
//            }
//        });
        this.actions.removeIf(action -> action.run(owner)); // neu true se xoa ptu do di
        return this.actions.isEmpty();  // action rong thi group action se ket thuc
    }

    @Override
    public void reset() {

    }
}
