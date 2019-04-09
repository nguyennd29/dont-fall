package game.boss;

import base.GameObject;
import base.Vector2D;
import game.NormalBox.Box;
import game.platforms.Platform;
import game.player.BulletPlayer;
import physic.BoxCollider;
import physic.PhysicBody;
import physic.RunHitObject;
import renderer.ImageRenderer;

public class BulletBoss extends GameObject implements PhysicBody {

    public Vector2D velocity;
    public RunHitObject runHitObject;
    public BoxCollider boxCollider;

    public BulletBoss() {
        this.width = 10;
        this.height = 10;
        this.velocity = new Vector2D();
        this.renderer = new ImageRenderer("resources/images/circle.png", width, height);
        this.boxCollider = new BoxCollider(10, 10);
        this.runHitObject = new RunHitObject(
                Platform.class, Box.class, BulletPlayer.class);
    }

    @Override
    public void run() {
        super.run();
        this.position.addUp(this.velocity);
        this.runHitObject.run(this);
        this.boxCollider.position.set(this.position.x - 5, this.position.y - 5);

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
