package base;

import game.ViewPort;
import game.background.BackgroundTile;
import game.enemyfollow.EnemyFollow;
import game.platforms.Platform;
import game.player.BulletPlayer;
import game.player.Player;
import physic.BoxCollider;
import physic.PhysicBody;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class GameObjectManager {

    static public GameObjectManager instance = new GameObjectManager();

    private List<GameObject> list;
    private List<GameObject> tempList;

    private GameObjectManager() {
        this.list = new ArrayList<>();
        this.tempList = new ArrayList<>();
    }

    public void add(GameObject gameObject) {
        this.tempList.add(gameObject);
    }

    public void runAll() {
        this.list
                .stream()
                .filter(gameObject -> gameObject.isAlive)
                .forEach(gameObject -> gameObject.run());
        this.list.addAll(this.tempList);
        this.tempList.clear();
    }

    public void renderBackground(Graphics2D g2d, ViewPort viewPort) {
        this.list
                .stream()
                .filter(gameObject -> gameObject instanceof BackgroundTile)
                .filter(gameObject -> gameObject.isInViewport(viewPort))
                .forEach(gameObject -> gameObject.render(g2d, viewPort));
    }

    public void renderAll(Graphics2D g2d, ViewPort viewPort) {
        this.list
                .stream()
                .filter(gameObject -> gameObject.isAlive)
                .filter(gameObject -> !(gameObject instanceof BackgroundTile))
//                .filter(gameObject -> gameObject.isInViewport(viewPort))
                .forEach(gameObject -> gameObject.render(g2d, viewPort));
    }

    public Player findPlayer() {
        return (Player) this.list
                .stream()
                .filter(gameObject -> gameObject instanceof Player)
                .findFirst()
                .orElse(null);
    }


    public <T extends GameObject & PhysicBody> T checkCollision(BoxCollider boxCollider, Class<T> cls) {
        return (T) this.list
                .stream()
                .filter(gameObject -> gameObject.isAlive)
                .filter(gameObject -> cls.isInstance(gameObject))
                .filter(gameObject -> {
                    BoxCollider other = ((T) gameObject).getBoxCollider();
                    return boxCollider.checkCollision(other);
                })
                .findFirst()
                .orElse(null);
    }

    public <T extends GameObject> T recycle(Class<T> cls) {
        T object = (T) this.list
                .stream()
                .filter(gameObject -> !gameObject.isAlive)
                .filter(gameObject -> cls.isInstance(gameObject))
                .findFirst()
                .orElse(null);

        if (object != null) {
            object.isAlive = true;
            return object;
        } else {
            try {
                object = cls.newInstance();
                this.add(object);
                return object;
            } catch (InstantiationException | IllegalAccessException e) {
                e.printStackTrace();
                return null;
            }
        }

    }
    public void clear() {
        this.list.clear();
        this.tempList.clear();
    }


}