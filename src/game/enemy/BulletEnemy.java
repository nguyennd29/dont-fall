package game.enemy;

import base.GameObject;
import base.Vector2D;
import game.NormalBox.Box;
import game.platforms.Platform;
import game.player.BulletPlayer;
import physic.BoxCollider;
import physic.PhysicBody;
import physic.RunHitObject;
import renderer.ImageRenderer;


public class BulletEnemy extends GameObject implements PhysicBody {

    public Vector2D velocity;
    public BoxCollider boxCollider;
    public RunHitObject runHitObject;

    public BulletEnemy() {
        this.width = 30;
        this.height = 30;
        this.velocity = new Vector2D();
        this.renderer = new ImageRenderer("resources/Bullet Image/EnemyBullet.png", width, height);
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
    public BoxCollider getBoxCollider() {
        return this.boxCollider;
    }

    @Override
    public void getHit(GameObject gameObject) {
        this.isAlive = false;

    }

    @Override
    public boolean isActive() {
        return isAlive;
    }
}
