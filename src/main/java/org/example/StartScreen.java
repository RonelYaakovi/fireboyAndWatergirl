package org.example;

import javax.swing.*;
import java.awt.*;

public class StartScreen extends JPanel {
    private Window window;
    private JButton startButton;
    private JButton rulesButton;
    private JButton exitRulesButton;
    private ImageIcon rulesImage;
    private Image backgroundImage;


    public StartScreen(Window window) {
        this.window = window;
        this.setLayout(null);

        this.backgroundImage = new ImageIcon("C:\\Users\\RONEL\\IdeaProjects\\fireboyAndWatergirl\\src\\images\\start screen\\Background_fireboy&watergirl.jpeg").getImage();
        this.backgroundImage = backgroundImage.getScaledInstance(window.getWidth(), window.getHeight(), Image.SCALE_SMOOTH);

        this.startButton = new GameButton("Start", 190, 290, 140, 45, new Color(192, 7, 7));


        this.startButton.addActionListener(e -> {
            window.switchPanel(new LevelSelectionScreen(window));
        });
        this.rulesButton = new GameButton("Rules", 470, 290, 140, 45, new Color(3, 174, 210));


        this.add(this.startButton);
        this.add(this.rulesButton);

        this.rulesButton.addActionListener(e -> {
            window.switchPanel(new RulesScreen(window));
        });




    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        if (this.backgroundImage != null) {
            g.drawImage(this.backgroundImage, 0, 0, this);
        }
    }


}