package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class MyFrame {
    private JFrame frame;
    private JButton button;
    private Random rand;
    private Color color;

    public class Panel extends JPanel {
        public void paintComponent(Graphics g) {
            g.setColor(color);
            g.fillRect(100,100,200,100);
        }
    }

    public class ButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent event) {
            int r,g,b;
            rand = new Random();
            r = (int)(rand.nextDouble()*256);
            g = (int)(rand.nextDouble()*256);
            b = (int)(rand.nextDouble()*256);
            color = new Color(r,g,b);
            frame.repaint();
        }
    }

    public void startFrame() {
        frame = new JFrame("My frame");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Panel panel = new Panel();
        button = new JButton("switch color");

        button.addActionListener(new ButtonListener());
        panel.add(button);
        frame.add(panel);
        frame.setBounds(300,300,400,400);
        frame.setVisible(true);
    }
}
