package BarricadeGame;

import java.awt.*;

/**
 * Created by Timo on 16-3-2016.
 */
public class Barricade extends Tile{

    private int xPos, yPos;
    private Color color;

    public Barricade(int xPos, int yPos){
        this.xPos = xPos;
        this.yPos = yPos;
        this.color = Color.GREEN;
    }

    public void paintTile(Graphics g){
        g.setColor(this.color);
        g.fillRect(this.xPos, this.yPos, super.getWidth(), super.getHeight());
    }
}
