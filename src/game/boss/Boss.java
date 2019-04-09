package game.boss;

import base.GameObject;
import base.Vector2D;
import game.player.BulletPlayer;
import physic.BoxCollider;
import physic.PhysicBody;
import renderer.ImageRenderer;


public class Boss extends GameObject implements PhysicBody {

    public Vector2D velocity;

    public BoxCollider boxCollider;

    public int HP;

    public Boss() {
        this.width = 130;
        this.height = 130;
        this.renderer = new ImageRenderer("resources/images/FlameDemon Evolved.png", width, height);
        this.velocity = new Vector2D();
        this.HP = 2000;
        this.boxCollider = new BoxCollider(130, 130);
        this.attributes.add(new BossShoot());

    }


    @Override
    public void run() {
        super.run();
        this.position.addUp(this.velocity);

        this.boxCollider.position.set(this.position.x - 65, this.position.y - 65);

    }

    @Override
    public void getHit(GameObject gameObject) {
        if (gameObject instanceof BulletPlayer) this.HP -= ((BulletPlayer) gameObject).damage;
        if (this.HP <= 0) {
            this.isAlive = false;
            this.HP = 2000;
        }
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
