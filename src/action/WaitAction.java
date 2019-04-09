package action;

import base.FrameCounter;
import base.GameObject;

public class WaitAction implements Action {

    private FrameCounter frameCounter;

    public WaitAction(int timeInterval) {
        this.frameCounter = new FrameCounter(timeInterval);
    }

    @Override
    public boolean run(GameObject owner) {
        return this.frameCounter.run();
    }

    @Override
    public void reset() {
        this.frameCounter.reset();
    }
}