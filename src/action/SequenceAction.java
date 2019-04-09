package action;

import base.GameObject;

import java.util.Arrays;
import java.util.List;

public class SequenceAction implements Action {

    private List<Action> actions;
    private int currentIndex;

    public SequenceAction(Action... actions) {
        this.actions = Arrays.asList(actions);
        this.currentIndex = 0;
    }

    @Override
    public boolean run(GameObject owner) {
        Action action = this.actions.get(this.currentIndex);
        if (action.run(owner)) {
            if (this.currentIndex == this.actions.size() - 1) {
                return true;
            } else {
                this.currentIndex += 1;
            }
        }
        return false;
    }

    @Override
    public void reset() {
        this.currentIndex = 0;
        this.actions.forEach(action -> action.reset());
    }
}