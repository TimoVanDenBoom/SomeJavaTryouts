package BarricadeGame;

import javax.swing.*;

/**
 * Created by Timo on 16-3-2016.
 */
public class Frame extends JFrame {

    private final int WIDTH = 507;
    private final int HEIGHT = 600;
    private Map panel;

    public Frame(){

        this.panel = new Map();

        setSize(this.WIDTH, this.HEIGHT);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setTitle("Tryout");
        setVisible(true);

        add(this.panel);
    }
}
