package physic;

import base.GameObject;
import base.GameObjectManager;

import java.util.Arrays;
import java.util.List;

public class RunHitObject<V extends GameObject & PhysicBody> {

    private List<Class<V>> classes;

    public RunHitObject(Class<V>... classes) {
        this.classes = Arrays.asList(classes);
    }

    public <T extends GameObject & PhysicBody> void run(T gameObject) {
        this.classes
                .stream()
                .map(cls -> GameObjectManager.instance.checkCollision(gameObject.getBoxCollider(), cls))
                .filter(object -> object != null)
                .forEach(object -> {
                    object.getHit(gameObject);
                    gameObject.getHit(object);
                });

    }

}