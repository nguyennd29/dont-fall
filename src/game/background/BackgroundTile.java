package game.background;

import base.GameObject;
import base.Vector2D;
import physic.BoxCollider;
import physic.PhysicBody;
import renderer.ImageRenderer;


public class BackgroundTile extends GameObject {

    public BackgroundTile() {
        super();
        this.position = new Vector2D();
        width = 50;
        height = 50;

    }


    public static BackgroundTile create(int backgroundType) {
        BackgroundTile backgroundTile = new BackgroundTile();


        backgroundTile.renderer = new ImageRenderer("resources/mapcreate/bg1.png", backgroundTile.width, backgroundTile.height);




        return backgroundTile;
    }


    public void run() {
        super.run();
    }
}
