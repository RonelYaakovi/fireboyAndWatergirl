package org.example;

import javax.swing.*;
import java.awt.*;

public class RulesScreen extends JPanel {
    private Window window;
    private Image backgroundImage;
    private JButton backButton;

    public RulesScreen(Window window) {
        this.window = window;
        this.setLayout(null);

        this.backgroundImage = new ImageIcon("src/images/start screen/Background_fireboy&watergirl.jpeg").getImage();

        this.backButton = new JButton("Back");
        this.backButton.setBounds(340, 480, 100, 40);
        this.backButton.setFont(new Font("Arial", Font.BOLD, 16));
        this.backButton.setBackground(new Color(50, 50, 50));
        this.backButton.setForeground(Color.WHITE);
        this.backButton.setFocusPainted(false);

        this.backButton.addActionListener(e -> {
            window.switchPanel(new StartScreen(window));
        });

        this.add(backButton);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;

        if (this.backgroundImage != null) {
            g2d.drawImage(this.backgroundImage, 0, 0, 800, 600, this);
        }

        g2d.setColor(new Color(0, 0, 0, 180));
        g2d.fillRect(0, 0, 800, 600);

        g2d.setColor(Color.WHITE);
        g2d.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);

        g2d.setFont(new Font("Verdana", Font.BOLD, 36));
        drawCenteredString(g2d, "GAME RULES", 100);

        g2d.setFont(new Font("Arial", Font.PLAIN, 20));
        int startY = 180;
        int spacing = 40;

        drawCenteredString(g2d, "• Fireboy moves with ARROW KEYS", startY);
        drawCenteredString(g2d, "• Watergirl moves with WASD KEYS", startY + spacing);
        drawCenteredString(g2d, "• Fireboy cannot touch water pools", startY + spacing * 2);
        drawCenteredString(g2d, "• Watergirl cannot touch lava pools", startY + spacing * 3);
        drawCenteredString(g2d, "• Green mud/poison is deadly for both!", startY + spacing * 4);
        drawCenteredString(g2d, "• Collect all diamonds and reach the exit doors", startY + spacing * 5);
        drawCenteredString(g2d, "• Work together! You need both to finish a level", startY + spacing * 6);
    }

    private void drawCenteredString(Graphics g, String text, int y) {
        FontMetrics metrics = g.getFontMetrics(g.getFont());
        int x = (800 - metrics.stringWidth(text)) / 2;
        g.drawString(text, x, y);
    }
}