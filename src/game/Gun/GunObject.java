package game.Gun;

import base.GameObject;
import base.GameObjectManager;
import game.player.BulletPlayer;
import game.player.Player;
import input.MouseInput;

import java.util.Random;

public class GunObject{
    public long lastTime;
    public int firingRate; //bullet per second
    public int recoilRate;
    public int bulletSpeed;
    public int manaCost;
    public GunObject() {
        this.lastTime = 0;
        this.firingRate = 0;
        this.recoilRate = 0;
        this.bulletSpeed = 0;
        this.manaCost = 0;

    }

    public void shoot(GameObject  gameObject){
        if(Player.instance.Mana >= manaCost)
        if (MouseInput.instance.clicked) {
            long currentTime = System.nanoTime();
            if (currentTime - this.lastTime >=1_000_000_000/firingRate) {
                Random random = new Random();
                int recoilY=25+recoilRate/2 - random.nextInt(recoilRate);
                BulletPlayer bulletPlayer = GameObjectManager.instance.recycle(BulletPlayer.class);
                bulletPlayer.position.set(gameObject.position);
                bulletPlayer.velocity.set(MouseInput.instance.vector2D.subtract(gameObject.position).subtract(0,recoilY).normalized().multiply(bulletSpeed));
                this.lastTime = currentTime;
                Player.instance.Mana -=manaCost;
            }
        }
    }

}
