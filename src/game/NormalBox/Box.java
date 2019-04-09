package game.NormalBox;

import base.GameObject;
import base.Vector2D;
import game.platforms.Platform;
import game.player.BulletPlayer;
import physic.BoxCollider;
import physic.PhysicBody;
import renderer.ImageRenderer;


public class Box extends Platform implements PhysicBody {
    private BoxCollider boxCollider;
    public int HP;
    private int width;
    private int height;

    public Box() {
        super();
        HP = 20;
        this.position = new Vector2D();
        width = 50;
        height = 75;
        this.boxCollider = new BoxCollider(width, height);

    }

    @Override
    public BoxCollider getBoxCollider() {
        return boxCollider;
    }

    public static Box create(int boxType) {
        Box box = new Box();

        box.renderer = new ImageRenderer("resources/PlatformImage/Crate.png", box.width, box.height);


        return box;
    }

    @Override
    public void getHit(GameObject gameObject) {

        if (gameObject instanceof BulletPlayer) {
            this.HP -= ((BulletPlayer) gameObject).damage;
        }
        if (this.HP <= 0) {
            this.isAlive = false;
            this.HP = 100;
        }
    }


    @Override
    public boolean isActive() {
        return this.isAlive;
    }

    public void run() {
        super.run();
        this.boxCollider.position.set(this.position.x - width / 2, this.position.y - height / 2);
    }

}
