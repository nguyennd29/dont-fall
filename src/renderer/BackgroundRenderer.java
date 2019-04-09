package renderer;

import base.Vector2D;

import java.awt.*;

public class BackgroundRenderer implements Renderer {
    private Color color;
    private int width;
    private int height;

    public BackgroundRenderer(Color color, int width, int height) {
        this.color = color;
        this.width = width;
        this.height = height;
    }

    @Override
    public void render(Graphics graphics, Vector2D position) {
        graphics.setColor(this.color);
        graphics.fillRect((int)position.x, (int)position.y, this.width, this.height);

    }
}
