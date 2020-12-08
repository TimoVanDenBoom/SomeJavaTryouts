package Lolgame;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Timo on 3-3-2016.
 */
public class Ground extends JComponent{

    private int height, width, xPosition, yPosition;
    private Color color;

    public Ground(){
        this.height = 100;
        this.width = 840;
        this.xPosition = 0;
        this.yPosition = 500;
        this.color = Color.GREEN.darker();
    }

    @Override
    public int getHeight() {
        return height;
    }

    public int getWidth() {
        return width;
    }

    public int getxPosition() {
        return xPosition;
    }

    public int getyPosition() {
        return yPosition;
    }

    public Color getColor() {
        return color;
    }
}
