package game.player;

import base.Attribute;
import base.Vector2D;
import input.KeyboardInput;

public class PlayerMove implements Attribute<Player> {
    private Vector2D defaultVelocity = new Vector2D(9.5f, 0);

    private void backToScreen(Vector2D position) {
        if (position.x > 1024) {
            position.x = 0;
        }
        if (position.x < 0) {
            position.x = 1024;
        }
        if (position.y > 600) {
            position.y = 0;
        }
        if (position.y < 0) {
            position.y = 600;
        }
    }

    @Override
    public void run(Player gameObject) {
        Vector2D velocity = this.defaultVelocity.copy();

        if (KeyboardInput.instance.isLeft) {
            gameObject.angle =180;
            gameObject.position.addUp(-9.5f,0);
        }
        if (KeyboardInput.instance.isRight) {
            gameObject.angle =0;
            gameObject.position.addUp(9.5f,0);
        }
        if (KeyboardInput.instance.isUp) {
            gameObject.angle =270;
            gameObject.position.addUp(0,-9.5f);
        }
        if (KeyboardInput.instance.isDown) {
            gameObject.angle =90;
            gameObject.position.addUp(0,9.5f);
        }

        gameObject.velocity.set(velocity.rotate(gameObject.angle));



        this.backToScreen(gameObject.position);
    }

}