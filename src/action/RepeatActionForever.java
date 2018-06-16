package action;

import base.GameObject;

public class RepeatActionForever implements Action {    //chay vo han -> trong ham run luon return false

    private Action action;

    public RepeatActionForever(Action action) { //chi co 1 action duy nhat
        this.action = action;
    }

    @Override
    public boolean run(GameObject owner) {
        if(this.action.run(owner)){
            this.action.reset();
        }

        return false;
    }

    @Override
    public void reset() {

    }
}
