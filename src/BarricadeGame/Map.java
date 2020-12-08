package BarricadeGame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * Created by Timo on 16-3-2016.
 */
public class Map extends JPanel {

    private int[][] tiles;

    private Player player;

    private KeyTyped keyTyped;



    public Map(){
        this.tiles = new int[][] {
                {0, 1, 0, 0, 0, 1, 1, 1, 1, 1},
                {0, 1, 1, 0, 0, 1, 1, 1, 0, 1},
                {0, 1, 0, 0, 0, 1, 0, 1, 1, 1},
                {0, 0, 2, 0, 0, 1, 1, 1, 0, 1},
                {0, 1, 2, 0, 0, 1, 1, 1, 1, 1},
                {0, 1, 1, 0, 0, 1, 1, 1, 0, 1},
                {0, 1, 0, 1, 0, 1, 1, 1, 1, 1},
                {0, 1, 2, 0, 0, 1, 1, 2, 1, 1},
                {0, 1, 1, 0, 0, 1, 1, 1, 1, 1},
                {0, 1, 0, 0, 0, 1, 1, 1, 1, 2}
        };

        this.player = new Player(0, 0);
        this.keyTyped = new KeyTyped();

        addKeyListener(this.keyTyped);
        setBackground(Color.LIGHT_GRAY);
        setFocusable(true);

    }


    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);

        for (int i = 0; i < 500; i += 50) {
            for (int j = 0; j < 500; j += 50) {

                if (this.tiles[j / 50][i / 50] == 1){
                    Wall wall = new Wall(i, j);
                    wall.paintTile(g);
                }

                if (this.tiles[j / 50][i / 50] == 2){
                    Barricade barricade = new Barricade(i, j);
                    barricade.paintTile(g);
                }

                this.player.paintPlayer(g);

                g.setColor(Color.BLACK);
                g.drawRect(i, j, 50, 50);

            }

        }
    }

    public class KeyTyped implements KeyListener {

        @Override
        public void keyTyped(KeyEvent e) {

        }

        @Override
        public void keyPressed(KeyEvent e) {
            int key = e.getKeyCode();

            if (key == KeyEvent.VK_LEFT){
                player.moveLeft();
                repaint();
            }
            if (key == KeyEvent.VK_RIGHT){
                player.moveRight();
                repaint();
            }
            if (key == KeyEvent.VK_UP){
                player.moveUp();
                repaint();
            }
            if (key == KeyEvent.VK_DOWN){
                player.moveDown();
                repaint();
            }
        }

        @Override
        public void keyReleased(KeyEvent e) {

        }
    }

}
