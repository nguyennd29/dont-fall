package game.Gun;

public class AK47 extends GunObject {
    public AK47(){
        this.lastTime=0;
        this.firingRate = 8;
        this.recoilRate = 40;
        this.bulletSpeed = 50;
        this.manaCost = 3;
    }
}
