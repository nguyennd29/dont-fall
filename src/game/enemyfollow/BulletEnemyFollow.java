package game.enemyfollow;

import base.GameObject;
import base.Vector2D;
import game.NormalBox.Box;
import game.platforms.Platform;
import game.player.BulletPlayer;
import physic.BoxCollider;
import physic.PhysicBody;
import physic.RunHitObject;
import renderer.ImageRenderer;

public class BulletEnemyFollow extends GameObject implements PhysicBody {

    public Vector2D velocity;
    public RunHitObject runHitObject;
    public BoxCollider boxCollider;

    public BulletEnemyFollow() {
        this.width = 25;
        this.height = 60;
        this.velocity = new Vector2D();
        this.renderer = new ImageRenderer("resources/Bullet Image/PlayerBullet.png", width, height);
        this.boxCollider = new BoxCollider(width, height);
        this.runHitObject = new RunHitObject(
                Platform.class, Box.class, BulletPlayer.class);
    }

    @Override
    public void run() {
        super.run();
        this.position.addUp(this.velocity);

        this.runHitObject.run(this);

        this.boxCollider.position.set(this.position.x - width / 2, this.position.y - height / 2);
    }

    @Override
    public void getHit(GameObject gameObject) {
        this.isAlive = false;
    }

    @Override
    public boolean isActive() {
        return isAlive;
    }

    @Override
    public BoxCollider getBoxCollider() {
        return this.boxCollider;
    }
}
