package game.boss;

import action.ActionAdapter;
import action.LimitAction;
import action.SequenceAction;
import action.WaitAction;
import base.GameObject;
import base.GameObjectManager;

import java.util.Random;

public class CreateBoss extends GameObject {

    private Random random;

    public CreateBoss() {
        this.random = new Random();
        this.configAction();
    }

    public void configAction() {
        this.addAction(
                new LimitAction(1,
                        new SequenceAction(
                                new WaitAction(500),
                                new ActionAdapter() {
                                    @Override
                                    public boolean run(GameObject owner) {
                                        Boss boss = GameObjectManager.instance.recycle(Boss.class);
                                        boss.position.set(8100, 4500);
                                        boss.velocity.set(0,0);
                                        return true;
                                    }
                                }
                        )
                )
        );
    }
}
