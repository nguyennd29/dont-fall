package game.Gun;

import base.FrameCounter;
import base.GameObject;
import base.GameObjectManager;
import game.player.Player;
import physic.BoxCollider;
import physic.PhysicBody;
import physic.RunHitObject;
import renderer.ImageRenderer;

public class GunDesertEagle extends GameObject implements PhysicBody {
    public RunHitObject runHitObject;
    public BoxCollider boxCollider;


    public  GunDesertEagle (){
        this.renderer = new ImageRenderer("resources/images/3.png", 50, 50);
        this.boxCollider = new BoxCollider(50, 50);
        this.runHitObject = new RunHitObject(Player.class);
    }

    @Override
    public void run() {
        super.run();
        this.boxCollider.position.set(this.position.x - 25, this.position.y - 25);
        this.runHitObject.run(this);

    }

    public void isHaveBulletDesertEagle() {
        GameObjectManager.instance.findPlayer().desertEagle.shoot(GameObjectManager.instance.findPlayer());
    }
    @Override
    public BoxCollider getBoxCollider() {
        return this.boxCollider;
    }

    @Override
    public void getHit(GameObject gameObject) {
        this.isAlive= false;
    }

    @Override
    public boolean isActive() {
        return isAlive;
    }
}
