package physic;

import base.GameObject;
import base.Vector2D;

import java.awt.*;

public class BoxCollider extends GameObject {
    public Vector2D position;


    public BoxCollider (int width, int height) {
        this.width = width;
        this.height = height;
        this.position=new Vector2D();
    }

    public boolean checkCollision(BoxCollider other){
        Rectangle r1 =new Rectangle((int) this.position.x,(int)this.position.y,this.width,this.height);
        Rectangle r2 =new Rectangle((int) other.position.x,(int)other.position.y,other.width,other.height);

        return r1.intersects(r2);
    }
    public int getWidth(){
        return this.width;
    }
    public int getHeight(){
        return this.height;
    }


    public BoxCollider shift(float dx,float dy) {
        BoxCollider shiftedBoxCollider = new BoxCollider(this.width,this.height);
        shiftedBoxCollider.position.set(this.position.add(dx,dy));
        shiftedBoxCollider.screenPosition.set(this.screenPosition.add(dx,dy));
        return shiftedBoxCollider;
    }
}

