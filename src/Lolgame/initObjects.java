package Lolgame;


import javafx.scene.shape.Ellipse;

import javax.swing.JComponent;
import java.awt.*;

/**
 * Created by Timo on 3-3-2016.
 */
public class initObjects extends JComponent{


    private Ground ground = new Ground();
    private Ball ball = new Ball(100, 300);


    public void paintComponent(Graphics g){
        Graphics2D g2 = (Graphics2D) g;

        g2.setColor(ground.getColor());
        g2.fillRect(ground.getxPosition(), ground.getyPosition(), ground.getWidth(), ground.getHeight());
        g2.drawImage(ball.getImage(), ball.getxPosition(), ball.getyPosition(), ball.getWidth(), ball.getHeight(), null);


    }

    public Ground getGround() {
        return ground;
    }

    public Ball getBall() {
        return ball;
    }
}
