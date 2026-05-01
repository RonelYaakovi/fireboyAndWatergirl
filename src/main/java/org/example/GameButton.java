package org.example;

import javax.swing.JButton;
import java.awt.Color;
import java.awt.Font;

public class GameButton extends JButton {

    public GameButton(String text, int x, int y, int width, int height, Color bgColor) {
        super(text);

        this.setBounds(x, y, width, height);
        this.setFont(new Font("Arial", Font.BOLD, 20));
        this.setBackground(bgColor);
        this.setForeground(Color.WHITE);
        this.setFocusPainted(false);
    }
}