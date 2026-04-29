package org.example;

import javax.swing.*;
import java.awt.*;

public class Window extends JFrame {

    public Window() {
        this.setTitle("fireboy and watergirl");
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setLayout(new BorderLayout());
        this.setSize(800, 600);
        this.setLocationRelativeTo(null);
        switchPanel(new StartScreen(this));
        this.setVisible(true);

    }


    public void switchPanel(Component newPanel) {
        this.getContentPane().removeAll();
        this.getContentPane().add(newPanel);
        this.revalidate();
        this.repaint();
        newPanel.requestFocusInWindow();
    }

}
