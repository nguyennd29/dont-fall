package game.player;

import base.GameObject;
import base.Vector2D;
import game.NormalBox.Box;
import game.boss.Boss;
import game.enemy.Enemies;
import game.enemyfollow.EnemyFollow;
import game.platforms.Platform;
import physic.BoxCollider;
import physic.PhysicBody;
import physic.RunHitObject;
import renderer.ImageRenderer;

public class BulletPlayer extends GameObject implements PhysicBody {

    public Vector2D velocity;
    public BoxCollider boxCollider;
    public RunHitObject runHitObject;
    public int damage;

    public BulletPlayer() {
        this.width = 30;
        this.height = 30;
        this.velocity = new Vector2D();

        this.renderer = new ImageRenderer("resources/Bullet Image/PlayerBullet2.png", width, height);
        this.boxCollider = new BoxCollider(width, height);
        this.damage=15;
        this.runHitObject = new RunHitObject(
                EnemyFollow.class,
                Enemies.class, Boss.class, Platform.class, Box.class);

    }

    @Override
    public void run() {
        super.run();
        this.position.addUp(this.velocity);
        this.boxCollider.position.set(this.position.x - width / 2, this.position.y - height / 2);
        this.runHitObject.run(this);
    }

    public void getHit(GameObject gameObject) {
        this.isAlive = false;
    }

    @Override
    public boolean isActive() {
        return false;
    }

    public BoxCollider getBoxCollider() {
        return this.boxCollider;
    }
}

