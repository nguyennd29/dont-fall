package game;

import base.GameObject;
import base.Settings;
import base.Vector2D;
import physic.BoxCollider;
import physic.PhysicBody;
import renderer.Renderer;

import java.awt.*;
import java.awt.geom.AffineTransform;

public class ViewPort {
    static public ViewPort instance = new ViewPort();
    public Vector2D position;
    public Vector2D followOffset;
    public int width;
    public int height;
    private ViewPort() {
        width = Settings.GAMEPLAY_WIDTH + 100;
        height = Settings.GAMEPLAY_HEIGHT + 100;
        position = new Vector2D();
        followOffset = new Vector2D();

    }

    public void follow(GameObject gameObject) {
        position = gameObject.position.add(followOffset);
    }

    public Vector2D translate(Vector2D screenPosition) {

        return screenPosition.subtract(this.position);
    }


    public Vector2D getFollowOffset() {
        return followOffset;
    }

}


