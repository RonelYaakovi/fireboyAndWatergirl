package org.example;

import javax.swing.*;
import java.awt.*;

public class LevelSelectionScreen extends JPanel {
    private Window window;
    private Image backgroundImage;
    private GameButton level1Button;
    private GameButton level2Button;
    private JButton backButton;

    public LevelSelectionScreen(Window window) {
        this.window = window;
        this.setLayout(null);

        this.backgroundImage = new ImageIcon("C:\\Users\\RONEL\\IdeaProjects\\fireboyAndWatergirl\\src\\images\\start screen\\Background_fireboy&watergirl.jpeg").getImage();

        this.level1Button = new GameButton("LEVEL 1", 200, 250, 150, 50, new Color(138, 95, 65));
        this.level1Button.addActionListener(e -> {
            Level1 level1 = new Level1(window);
            window.switchPanel(level1);
            level1.startLevel();
        });

        this.level2Button = new GameButton("LEVEL 2", 450, 250, 150, 50, new Color(138, 95, 65));
        this.level2Button.addActionListener(e -> {
            System.out.println("Loading stage 2...");

            // כאן בהמשך נקרא למחלקת המשחק: window.switchPanel(new GameLevel(window, 2));
        });

        this.backButton = new JButton("Back");
        this.backButton.setBounds(350, 480, 100, 40);
        this.backButton.setFont(new Font("Arial", Font.BOLD, 16));
        this.backButton.setBackground(new Color(50, 50, 50));
        this.backButton.setForeground(Color.WHITE);
        this.backButton.setFocusPainted(false);
        this.backButton.addActionListener(e -> {
            window.switchPanel(new StartScreen(window));
        });

        this.add(level1Button);
        this.add(level2Button);
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
        g2d.setFont(new Font("Verdana", Font.BOLD, 40));

        FontMetrics metrics = g2d.getFontMetrics(g2d.getFont());
        String title = "SELECT LEVEL";
        int x = (800 - metrics.stringWidth(title)) / 2;
        g2d.drawString(title, x, 120);
    }
}