package game.Gun;


import action.ActionAdapter;
import action.LimitAction;
import action.SequenceAction;
import action.WaitAction;
import base.GameObject;
import base.GameObjectManager;


import java.util.Random;

public class CreateGunAK47 extends GameObject {
    public Random rd;
    public CreateGunAK47() {
        this.rd = new Random();
        this.configAction();
    }

    public void configAction() {
        this.addAction(
                new LimitAction(
                        1,
                        new SequenceAction(
                                new WaitAction(10),
                                new ActionAdapter() {
                                    @Override
                                    public boolean run(GameObject owner) {
                                        GunAK47 GunAK471 = GameObjectManager.instance.recycle(GunAK47.class);
                                        GunAK47 GunAK472 = GameObjectManager.instance.recycle(GunAK47.class);
                                        GunAK47 GunAK473 = GameObjectManager.instance.recycle(GunAK47.class);
                                        GunAK47 GunAK474 = GameObjectManager.instance.recycle(GunAK47.class);
                                        GunAK47 GunAK475 = GameObjectManager.instance.recycle(GunAK47.class);
                                        GunAK47 GunAK476 = GameObjectManager.instance.recycle(GunAK47.class);
                                        GunAK47 GunAK477 = GameObjectManager.instance.recycle(GunAK47.class);
                                        GunAK47 GunAK478 = GameObjectManager.instance.recycle(GunAK47.class);
                                        GunAK471.position.set(2730, 2608);
                                        GunAK472.position.set(2746, 1659);
                                        GunAK473.position.set(350, 2000);
                                        GunAK474.position.set(2176, 3794);
                                        GunAK475.position.set(1170, 4117);
                                        GunAK476.position.set(3147, 4765);
                                        GunAK477.position.set(4421, 2464);
                                        GunAK478.position.set(6200,2340);
                                        return true;
                                    }
                                }
                        )
                )
        );
    }


}