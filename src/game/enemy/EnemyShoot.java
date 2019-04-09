package game.enemy;

import base.Attribute;
import base.FrameCounter;
import base.GameObjectManager;
import base.Vector2D;

public class EnemyShoot implements Attribute<Enemies> {

    private FrameCounter frameCounter;

    public EnemyShoot() {
        this.frameCounter = new FrameCounter(10);
    }


    @Override
    public void run(Enemies gameObject) {
        if (frameCounter.run()) {
                BulletEnemy bulletEnemy = GameObjectManager.instance.recycle(BulletEnemy.class);
                bulletEnemy.position.set(gameObject.position);
            bulletEnemy.velocity.set(GameObjectManager.instance.findPlayer().position.subtract(gameObject.position).normalized().multiply(10));

            frameCounter.reset();
            }
    }
}
