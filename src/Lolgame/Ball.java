package Lolgame;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Timo on 3-3-2016.
 */
public class Ball extends JComponent{

    private int width, height;
    private ImageIcon i;
    private Image image;
    private boolean falling;
    private int xPosition, yPosition;


    public Ball(int xPosition, int yPosition) {
        this.width = 24;
        this.height = 24;
        this.xPosition = xPosition;
        this.yPosition = yPosition;
        this.i = new ImageIcon("src/imgs/Pinball.png");
        this.image = i.getImage();
        this.falling = true;
    }

    public void gravity(initObjects objects){
        while(this.falling){
            this.yPosition += 1;
            objects.repaint();
            if (this.yPosition == 500) {
                this.falling = false;
            }


        }
        while(!this.falling){
            this.yPosition -= 1;
            objects.repaint();
            if (this.yPosition == 300){
                this.falling = true;
            }
        }

    }

    @Override
    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public int getxPosition() {
        return xPosition;
    }

    public int getyPosition() {
        return yPosition;
    }


    public Image getImage() {
        return image;
    }
}
