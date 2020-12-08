package BarricadeGame;

import java.awt.*;

/**
 * Created by Timo on 16-3-2016.
 */
public class Player  {

    private int xPos, yPos, width, height;
    private Color color;
    private final int MAX_Y = 450;
    private final int MAX_X = 450;
    private final int MIN_Y = 0;
    private final int MIN_X = 0;

    public Player(int xPos, int yPos){
        this.xPos = xPos;
        this.yPos = yPos;
        this.width = 50;
        this.height = 50;
        this.color = Color.RED;
    }

    public void moveUp(){
        if (this.yPos != this.MIN_Y){
            this.yPos -= 50;
        }
    }

    public void moveDown(){
        if (this.yPos != this.MAX_Y){
            this.yPos += 50;
        }
    }

    public void moveLeft(){
        if (this.xPos != this.MIN_X){
            this.xPos -= 50;
        }
    }

    public void moveRight(){
        if (this.xPos != this.MAX_X){
            this.xPos += 50;
        }
    }


    public void paintPlayer(Graphics g) {

        g.setColor(this.color);
        g.fillRect(this.xPos, this.yPos, this.width, this.height);
    }
}
