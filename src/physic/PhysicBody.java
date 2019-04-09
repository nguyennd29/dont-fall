package physic;

import base.GameObject;

public interface PhysicBody {

    BoxCollider getBoxCollider();

    void getHit(GameObject gameObject);

    boolean isActive();
}