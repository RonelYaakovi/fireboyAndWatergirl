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

        this.startButton = new JButton("Start");
        this.startButton.setBounds(190, 290, 140, 45);
        this.startButton.setFont(new Font("Arial", Font.BOLD, 20));
        Color startButtonColor = new Color(192, 7, 7);
        this.startButton.setBackground(startButtonColor);
        this.startButton.setForeground(Color.WHITE);
        this.startButton.setFocusPainted(false);


//        this.startButton.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                פה צריך לעבור למסך המשחק*****
//            }
//        });
        this.rulesButton = new JButton("Rules");
        this.rulesButton.setBounds(470, 290, 140, 45);
        this.rulesButton.setFont(new Font("Arial", Font.BOLD, 20));
        Color rulesButtonColor = new Color(3, 174, 210);
        this.rulesButton.setBackground(rulesButtonColor);
        this.rulesButton.setForeground(Color.WHITE);
        this.rulesButton.setFocusPainted(false);




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