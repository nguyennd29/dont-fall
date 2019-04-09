package game.Gun;
import action.ActionAdapter;
import action.LimitAction;
import action.SequenceAction;
import action.WaitAction;
import base.GameObject;
import base.GameObjectManager;



import java.util.Random;

public class CreateGunShotGun extends GameObject {
    public Random rd;

    public CreateGunShotGun() {
        this.rd = new Random();
        this.configAction();
    }

    public void configAction() {
        this.addAction(
                new LimitAction(
                        10,
                        new SequenceAction(
                                new WaitAction(0),
                                new ActionAdapter() {
                                    @Override
                                    public boolean run(GameObject owner) {
                                        GunShotGun gunShotGun1 = GameObjectManager.instance.recycle(GunShotGun.class);
                                        GunShotGun gunShotGun2 = GameObjectManager.instance.recycle(GunShotGun.class);
                                        GunShotGun gunShotGun3 = GameObjectManager.instance.recycle(GunShotGun.class);
                                        GunShotGun gunShotGun4 = GameObjectManager.instance.recycle(GunShotGun.class);
                                        GunShotGun gunShotGun5 = GameObjectManager.instance.recycle(GunShotGun.class);
                                       GunShotGun gunShotGun6 = GameObjectManager.instance.recycle(GunShotGun.class);

                                        gunShotGun1.position.set(2888,4776);
                                        gunShotGun2.position.set(1648,400);
                                        gunShotGun3.position.set(800,1440);
                                        gunShotGun4.position.set(6238,1616);
                                        gunShotGun5.position.set(5633,3035);
                                        gunShotGun6.position.set(2242,1622);
                                        return true;
                                    }
                                }
                        )
                )
        );
    }
}