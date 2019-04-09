package action;

import base.GameObject;

import java.util.Arrays;
import java.util.List;

public class GroupAction implements Action {

    private List<Action> actions;

    public GroupAction(Action... actions) {
        this.actions = Arrays.asList(actions);
    }

    @Override
    public boolean run(GameObject owner) {
        this.actions.removeIf(action -> action.run(owner));
        return this.actions.isEmpty();
    }

    @Override
    public void reset() {

    }
}