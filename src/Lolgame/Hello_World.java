package Lolgame; /**
 * Created by Timo on 2-3-2016.
 */

import javax.swing.*;
import java.awt.*;



public class Hello_World {



    public static void main(String[] args) {

        JFrame jframe = new JFrame();


        jframe.setSize(840, 600);
        jframe.setTitle("Blocks");
        jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jframe.setResizable(false);
        jframe.getContentPane().setBackground(Color.CYAN);
        jframe.setVisible(true);

        initObjects objects = new initObjects();


        jframe.add(objects);






        while (true){
            if (System.currentTimeMillis() % 10 == 0){
                objects.getBall().gravity(objects);
            }
        }







    }


}
