package game.platforms;


import base.GameObject;
import base.Vector2D;
import physic.BoxCollider;
import physic.PhysicBody;
import renderer.ImageRenderer;


public class Platform extends GameObject implements PhysicBody {
    private BoxCollider boxCollider;
    private int width;
    private int height;
    public Platform() {
        super();
        this.position=new Vector2D();
        this.width = 50;
        this.height = 75;
        this.boxCollider = new BoxCollider(width,height);

    }

    @Override
    public BoxCollider getBoxCollider() {
        return boxCollider;
    }

    public static Platform create(int platformType) {
        Platform platform = new Platform();
        switch (platformType) {
            case 6:
                platform.renderer = new ImageRenderer("resources/PlatformImage/MossyStoneBricks.png", platform.width, platform.height);
                break;
            case 3:
                platform.renderer = new ImageRenderer("resources/PlatformImage/lavabrick.png", platform.width, platform.height);
                break;
            case 5:
                platform.renderer = new ImageRenderer("resources/PlatformImage/Torch.png", platform.width, platform.height);
                break;
            case 1:
                platform.width*=8;
                platform.height*=8;
                platform.renderer = new ImageRenderer("resources/PlatformImage/LavaFountain.png", platform.width, platform.height-147);
                break;


        }
        return platform;
    }

    @Override
    public void getHit(GameObject gameObject) {

    }

    @Override
    public boolean isActive() {
        return true;
    }

    public void run(){
        super.run();
        this.boxCollider.position.set(this.position.x - width/2, this.position.y - height/2);
    }
}
