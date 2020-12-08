package Jframe;

import javax.swing.*;

/**
 * Created by Timo on 8-3-2016.
 */
public class SetupFerrariFrame extends JFrame {

    private final int FRAME_WIDTH = 400;
    private final int FRAME_HEIGHT = 400;
    private FerrariPanel panel;

    public SetupFerrariFrame(Ferrari ferrari){

        this.panel = new FerrariPanel(ferrari);
        add(this.panel);

        setResizable(false);
        setSize(FRAME_WIDTH, FRAME_HEIGHT);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Ferrari");
        setVisible(true);
    }
}
