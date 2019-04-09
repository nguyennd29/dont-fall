package action;

import base.GameObject;

public class RepeatActionForever implements Action {

    private Action action;

    public RepeatActionForever(Action action) {
        this.action = action;
    }

    @Override
    public boolean run(GameObject owner) {
        if (this.action.run(owner)) {
            this.action.reset();
        }
        return false;
    }

    @Override
    public void reset() {

    }
}