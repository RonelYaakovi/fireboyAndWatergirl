package org.example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class startScreen extends JPanel {
    private Window window;
    Image backgroundImage;
    ImageIcon startButtonImage;
    JButton startButton;
    JButton roleButton;

    public startScreen(Window window) {
        this.window = window;
        this.backgroundImage = new ImageIcon("C:\\Users\\RONEL\\Downloads\\Fireboy-Watergirl-ForestTemple_OG-logo_Nero_AI_Image_Upscaler_Photo_Face (1).jpeg").getImage();
        this.startButtonImage = new ImageIcon("C:\\Users\\RONEL\\Downloads\\start-button-concept-game-start-button-11563520127pwcsff95og-removebg-preview.png");
        this.setLayout(null);
        this.startButton.setIcon(startButtonImage);
        this.startButton.setBounds(300, 400, 200, 50);
        this.startButton.addActionListener(ActionEvent -> {

        });
//        roleButton.setIcon();
//        this.roleButton.setBounds();
        this.roleButton.addActionListener(ActionEvent -> {

        });
        this.add(startButton);
    }

    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (backgroundImage != null) {
            g.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), this);
        }
    }


}
