package input;

import base.GameObjectManager;
import base.Vector2D;
import game.ViewPort;
import game.player.BulletPlayer;

import java.awt.event.*;
import java.util.Random;

public class MouseInput implements MouseListener, MouseMotionListener {
    public boolean clicked = false;
    public Vector2D vector2D;
    public static MouseInput instance = new MouseInput();

    @Override
    public void mouseClicked(MouseEvent e) {
    }

    @Override
    public void mousePressed(MouseEvent e) {
        this.clicked = true;
        vector2D = new Vector2D(e.getX()+ ViewPort.instance.position.x, e.getY()+ViewPort.instance.position.y);
        System.out.println(e.getX()+ ViewPort.instance.position.x);
        System.out.println(e.getY()+ViewPort.instance.position.y);
    }


    @Override
    public void mouseReleased(MouseEvent e) {
        this.clicked = false;

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }


    @Override
    public void mouseDragged(MouseEvent e) {

        this.clicked = true;
        vector2D = new Vector2D(e.getX()+ ViewPort.instance.position.x, e.getY()+ViewPort.instance.position.y);
    }

    @Override
    public void mouseMoved(MouseEvent e) {

    }

}
