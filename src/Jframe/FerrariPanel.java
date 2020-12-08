package Jframe;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Timo on 9-3-2016.
 */
public class FerrariPanel extends JPanel implements Runnable{


    private final int AREA_ROWS = 10;
    private final int AREA_COLUMNS = 30;

    private JLabel increaseRate;
    private JTextField desiredIncrease;
    private JButton confirmIncrease;
    private JTextArea resultArea;
    private JComboBox shapeSelection;
    private int default_increase, maxSpeed;
    private double degrees;
    private Ferrari ferrari;
    private ActionListener listener;
    private Thread animator;
    private boolean Circle, Rectangle, Triangle;

    public FerrariPanel(Ferrari ferrari){
        this.ferrari = ferrari;
        this.listener = new AddActionListener();
        this.animator = new Thread(this);
        this.default_increase = 10;
        this.maxSpeed = 300;
        this.degrees = 0;
        this.Circle = true;
        this.Rectangle = false;
        this.Triangle = false;

        animator.start();

        createResultArea();
        createTextField();
        createButton();
        add(increaseRate);
        add(desiredIncrease);
        add(confirmIncrease);

        JScrollPane scrollPane = new JScrollPane(resultArea);
        add(scrollPane);
        createJComboBox();
    }


    private void createTextField(){
        this.increaseRate = new JLabel("Change speed by: ");

        final int FIELD_WIDTH = 10;
        this.desiredIncrease = new JTextField(FIELD_WIDTH);
        this.desiredIncrease.setText("" + this.default_increase);

    }

    private void createResultArea(){
        this.resultArea = new JTextArea(AREA_ROWS, AREA_COLUMNS);
        this.resultArea.setText(ferrari.getSpeed() + "\n");
        this.resultArea.setEditable(false);
    }

    @Override
    public void run() {

        while (true){
            if(this.Circle){
                int scaledSpeed = this.ferrari.getSpeed() / 10;
                this.ferrari.moveCircle(this.degrees);
                this.degrees = this.degrees + scaledSpeed;
            }

            if(this.Rectangle){
                this.ferrari.setLastRectX(this.ferrari.getxPosition());
                this.ferrari.setLastRectY(this.ferrari.getyPosition());
                this.ferrari.moveRectangle(this.ferrari.getSpeed());
            }

            if (this.Triangle){
                this.ferrari.setLastXTri(this.ferrari.getxPosition());
                this.ferrari.setLastYTri(this.ferrari.getyPosition());
                this.ferrari.moveTriangle(this.ferrari.getSpeed());
            }

            repaint();
            try{
                Thread.sleep(100);
            }
            catch(InterruptedException e){

            }
        }
    }

    class AddActionListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {

            if(e.getSource() == confirmIncrease){
                int rate = Integer.parseInt(desiredIncrease.getText());

                if (rate < 0 && -rate > ferrari.getSpeed()){
                    rate = -ferrari.getSpeed();
                }
                if ((ferrari.getSpeed() + rate) > maxSpeed){
                    rate = maxSpeed - ferrari.getSpeed();
                }

                ferrari.increaseSpeed(rate);
                resultArea.insert(ferrari.getSpeed() + "\n", 0);
                resultArea.setCaretPosition(0);
                repaint();
            }

            if (e.getSource() == shapeSelection){
                if (shapeSelection.getSelectedItem().equals("Circle")){
                    Rectangle = false;
                    Triangle = false;
                    Circle = true;
                }
                if (shapeSelection.getSelectedItem().equals("Rectangle")){
                    ferrari.setxPosition(ferrari.getLastRectX());
                    ferrari.setyPosition(ferrari.getLastRectY());
                    Circle = false;
                    Triangle = false;
                    Rectangle = true;

                }
                if (shapeSelection.getSelectedItem().equals("Triangle")){
                    ferrari.setxPosition(ferrari.getLastXTri());
                    ferrari.setyPosition(ferrari.getLastYTri());
                    Circle = false;
                    Rectangle = false;
                    Triangle = true;
                }
            }
        }
    }

    private void createButton(){
        this.confirmIncrease = new JButton("Change Speed");

        this.confirmIncrease.addActionListener(this.listener);
    }

    private void createJComboBox(){
        this.shapeSelection = new JComboBox();
        this.shapeSelection.addItem("Circle");
        this.shapeSelection.addItem("Rectangle");
        this.shapeSelection.addItem("Triangle");

        this.shapeSelection.addActionListener(this.listener);
        add(this.shapeSelection);
    }

    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);

        g.drawLine(50, 245, 350, 245);
        g.fillOval(ferrari.getxPosition(), ferrari.getyPosition(), 10, 10);

        for (int i = 50; i <= 350; i += 10) {
            g.drawLine(i, 245, i, 250);

        }

        for (int i = 50; i <= 350 ; i += 20) {
            g.drawString(Integer.toString(i - 50), i - 8, 270);
        }

        g.setColor(Color.BLUE);
        g.fillRect(50, 230, ferrari.getSpeed(), 10);

    }
}
