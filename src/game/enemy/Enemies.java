package game.enemy;

import base.GameObject;
import base.GameObjectManager;
import base.Vector2D;
import game.player.BulletPlayer;
import game.player.Player;
import physic.BoxCollider;
import physic.PhysicBody;
import renderer.ImageRenderer;


public class Enemies extends GameObject implements PhysicBody {


    public Vector2D velocity;
    public BoxCollider boxCollider;
    public int HP;

    public Enemies() {
        this.width = 80;
        this.height = 90;
        this.velocity = new Vector2D();
        this.renderer = new ImageRenderer("resources/images/Vampire.png", width, height);
        this.HP = 400;
        this.boxCollider = new BoxCollider(width, height);
        this.attributes.add(new EnemyShoot());
    }

    @Override
    public void run() {
        super.run();
        this.position.addUp(velocity);
        this.boxCollider.position.set(this.position.x - width / 2, this.position.y - height / 2);
    }

    @Override
    public BoxCollider getBoxCollider() {
        return this.boxCollider;
    }

    @Override
    public void getHit(GameObject gameObject) {
        if (gameObject instanceof BulletPlayer) this.HP -= Player.instance.damage;
        if (this.HP <= 0) {
            this.isAlive = false;
            this.HP = 400;
        }
    }

    @Override
    public boolean isActive() {
        return isAlive;
    }
}



