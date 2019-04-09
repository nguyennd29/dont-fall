package Tilemap;

import base.GameObject;
import base.GameObjectManager;
import game.NormalBox.Box;
import game.background.BackgroundTile;
import game.platforms.Platform;

import java.util.List;

public class Layer {
    List<Integer> data;
    int height;
    int width;

    public void generate() {

       for(int  titleY =0;titleY<height;titleY++) {
           for (int titleX = 0; titleX < width; titleX++) {
               int mapData = data.get(titleY * width + titleX);
               if (mapData == 1) {
                   Platform platform=Platform.create(mapData);
                   platform.position.set(50 * titleX - 25, titleY * 50);

                   GameObjectManager.instance.add(platform);
               } else if (mapData == 2) {
                   BackgroundTile backgroundTile=BackgroundTile.create(mapData);
                   backgroundTile.position.set(50*titleX,titleY*50);

                   GameObjectManager.instance.add(backgroundTile);
               } else if (mapData == 4) {
                   BackgroundTile backgroundTile = BackgroundTile.create(2);
                   backgroundTile.position.set(50*titleX,titleY*50);

                   GameObjectManager.instance.add(backgroundTile);

                   Box box =Box.create(mapData);
                   box.position.set(50*titleX,titleY*50);
                   GameObjectManager.instance.add(box);
               }

               else if(mapData!=0){
                   Platform platform=Platform.create(mapData);
                   platform.position.set(50*titleX,titleY*50);

                   GameObjectManager.instance.add(platform);
               }
           }
       }
    }

    @Override
    public String toString() {
        return "Layer{" +
                "data=" + data +
                ", height=" + height +
                ", width=" + width +
                '}';
    }
}
