package game.boss;

import base.Attribute;
import base.FrameCounter;
import base.GameObjectManager;
import base.Vector2D;

public class BossShoot implements Attribute<Boss> {

    private FrameCounter frameCounter;

    public BossShoot() {
        this.frameCounter = new FrameCounter(80);
    }

    @Override
    public void run(Boss gameObject) {

        if (this.frameCounter.run()) {
            for (double angle = 0.0; angle < 360.0; angle += 360.0 / 15) {
                BulletBoss bulletBoss = GameObjectManager.instance.recycle(BulletBoss.class);
                bulletBoss.position.set(gameObject.position);
                bulletBoss.velocity.set((new Vector2D(2, 0)).rotate(angle));
            }
            this.frameCounter.reset();
        }

    }
}
