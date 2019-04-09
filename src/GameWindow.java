import Tilemap.Map;
import base.Settings;
import input.KeyboardInput;
import input.MouseInput;

import javax.swing.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class GameWindow extends JFrame {

    private GameCanvas gameCanvas;
    private long lastTime = 0;

    public GameWindow() {
        this.setSize(Settings.GAMEPLAY_WIDTH, Settings.GAMEPLAY_HEIGHT);

        this.setupGameCanvas();

        this.event();

        addWall();

        this.setVisible(true);


    }

    private void addWall(){
        Map map = Map.load("resources/mapcreate/map-dontfall.json");
        map.generate();

    }
    private void setupGameCanvas() {
        this.gameCanvas = new GameCanvas();
        this.add(gameCanvas);
    }

    private void event() {
        this.addKeyListener(KeyboardInput.instance);
        this.windowEvent();
        this.addMouseListener(MouseInput.instance);
        this.addMouseMotionListener(MouseInput.instance);

    }


    private void windowEvent() {
        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(1);
            }
        });
    }

    public void gameLoop() {
        while (true) {
            long currentTime = System.nanoTime();
            if (currentTime - this.lastTime >= 17_000_000) {
                this.gameCanvas.runAll();
                this.gameCanvas.renderAll();
                this.lastTime = currentTime;
            }
        }
    }
}
