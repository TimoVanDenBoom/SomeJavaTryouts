package BarricadeGame;

import java.awt.*;

/**
 * Created by Timo on 16-3-2016.
 */
public abstract class Tile {

    private int width, height;

    public Tile(){
        this.width = 50;
        this.height = 50;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public abstract void paintTile(Graphics g);
}
