package game.Gun;

import action.ActionAdapter;
import action.LimitAction;
import action.SequenceAction;
import action.WaitAction;
import base.GameObject;
import base.GameObjectManager;

import java.util.Random;

public class CreateDesertEagle extends GameObject {
    public Random rd;
    public CreateDesertEagle() {
        this.rd = new Random();
        this.configAction();
    }

    public void configAction() {
        this.addAction(
                new LimitAction(
                        1,
                        new SequenceAction(
                                new WaitAction(150),
                                new ActionAdapter() {
                                    @Override
                                    public boolean run(GameObject owner) {
                                        GunDesertEagle desertEagle = GameObjectManager.instance.recycle(GunDesertEagle.class);
                                        desertEagle.position.set(GameObjectManager.instance.findPlayer().position.x,GameObjectManager.instance.findPlayer().position.y);
                                        return true;
                                    }
                                }
                        )
                )
        );
    }
}

