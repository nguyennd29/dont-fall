package input;


import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyboardInput implements KeyListener {

    public static KeyboardInput instance = new KeyboardInput();

    public boolean isLeft = false;
    public boolean isRight = false;
    public boolean isUp = false;
    public boolean isDown = false;

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_LEFT) this.isLeft = true;
        if (e.getKeyCode() == KeyEvent.VK_RIGHT) this.isRight = true;
        if (e.getKeyCode() == KeyEvent.VK_UP) this.isUp = true;
        if (e.getKeyCode() == KeyEvent.VK_DOWN) this.isDown = true;

    }

    @Override
    public void keyReleased(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_LEFT) this.isLeft = false;
        if (e.getKeyCode() == KeyEvent.VK_RIGHT) this.isRight = false;
        if (e.getKeyCode() == KeyEvent.VK_UP) this.isUp = false;
        if (e.getKeyCode() == KeyEvent.VK_DOWN) this.isDown = false;

    }

}
