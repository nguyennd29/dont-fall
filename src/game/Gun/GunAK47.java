package game.Gun;

import base.FrameCounter;
import base.GameObject;
import base.GameObjectManager;
import game.player.Player;
import physic.BoxCollider;
import physic.PhysicBody;
import physic.RunHitObject;
import renderer.ImageRenderer;

public class GunAK47 extends GameObject implements PhysicBody {
    public RunHitObject runHitObject;
    public BoxCollider boxCollider;


    public GunAK47 (){
        this.renderer = new ImageRenderer("resources/GunImage/GrenadeSMG.png", 70, 70);
        this.boxCollider = new BoxCollider(70, 70);
        this.runHitObject = new RunHitObject(Player.class);
    }

    @Override
    public void run() {
        super.run();
        this.boxCollider.position.set(this.position.x - 25, this.position.y - 25);
        this.runHitObject.run(this);

    }

    public void isHaveBulletAK() {
        GameObjectManager.instance.findPlayer().ak47.shoot(GameObjectManager.instance.findPlayer())
        ;

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