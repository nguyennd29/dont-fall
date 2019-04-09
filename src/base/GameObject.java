package base;

import action.Action;
import game.ViewPort;
import renderer.Renderer;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

public class GameObject {
    public Vector2D position;
    public Vector2D screenPosition;

    public Renderer renderer;

    public boolean isAlive;

    public int width;
    public int height;

    public List<Attribute> attributes;

    public List<Action> actions;

    public GameObject() {
        this.position = new Vector2D();
        this.screenPosition = new Vector2D();
        this.attributes = new ArrayList<>();
        this.isAlive = true;
        this.actions = new ArrayList<>();

    }

    public void render(Graphics2D g2d, ViewPort viewPort) {

        if (renderer != null) {
            renderer.render(g2d, viewPort.translate(this.screenPosition));
        }
    }

    public void run() {
        this.screenPosition.set(position);

        this.attributes.forEach(attribute -> attribute.run(this));

        this.actions.removeIf(action -> action.run(this));
    }

    public void addAction(Action action) {
        this.actions.add(action);
    }

    public boolean isInViewport(ViewPort viewPort) {
        Rectangle r1 = new Rectangle((int) this.position.x, (int) this.position.y, this.width, this.height);
        Rectangle r2 = new Rectangle((int) viewPort.position.x, (int) viewPort.position.y, viewPort.width, viewPort.height);

        return r2.contains(r1) || r2.intersects(r1);
    }
}
