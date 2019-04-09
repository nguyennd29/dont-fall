package action;

import base.GameObject;

public class LimitAction implements Action {
    private Action action;
    private int max;

    public LimitAction(int max, Action action) {
        this.action = action;
        this.max = max;
    }

    @Override
    public boolean run(GameObject owner) {
        if (this.action.run(owner)) {
            this.action.reset();
            this.max -= 1;
        }
        return this.max == 0;
    }

    @Override
    public void reset() {

    }
}