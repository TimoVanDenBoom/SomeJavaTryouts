package BarricadeGame;

import java.awt.*;

/**
 * Created by Timo on 16-3-2016.
 */
public class Wall extends Tile{

    private int xPos, yPos;
    private Color color;

    public Wall(int xPos, int yPos){
        this.xPos = xPos;
        this.yPos = yPos;
        this.color = Color.BLUE;
    }

    public void paintTile(Graphics g){
        g.setColor(this.color);
        g.fillRect(this.xPos, this.yPos, super.getWidth(), super.getHeight());
    }
}
