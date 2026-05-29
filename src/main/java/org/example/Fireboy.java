package org.example;

import javax.swing.ImageIcon;
import java.awt.*;
import java.awt.image.BufferedImage;

public class Fireboy extends Character {

    public Fireboy(int x, int y, int screenWidth, int screenHeight) {
        super(x, y, screenWidth, screenHeight);

        String idleFolder = "src/images/start screen/Fight_Stance_Idle-ef897b61/south";
        String runFolder = "src/images/start screen/Running-3e435754/east";

        int numberOfRunFrames = 8;
        int numberOfIdleFrames = 8;

        this.runRightFrames = new Image[numberOfRunFrames];
        this.runLeftFrames = new Image[numberOfRunFrames];

        this.idleRightFrames = new Image[numberOfIdleFrames];
        this.idleLeftFrames = new Image[numberOfIdleFrames];

        for (int i = 0; i < numberOfIdleFrames; i++) {
            String fileName = "frame_" + String.format("%03d", i) + ".png";
            Image img = new ImageIcon(idleFolder + fileName).getImage();

            this.idleRightFrames[i] = img;
            this.idleLeftFrames[i] = createFlippedImage(img);
        }

        for (int i = 0; i < numberOfRunFrames; i++) {
            String fileName = "frame_" + String.format("%03d", i) + ".png";
            Image img = new ImageIcon(runFolder + fileName).getImage();

            this.runRightFrames[i] = img;
            this.runLeftFrames[i] = createFlippedImage(img);
        }

        this.currentImage = this.idleRightFrames[0];
    }

    private Image createFlippedImage(Image source) {
        if (source == null) return null;
        BufferedImage bufferedImage = new BufferedImage(
                source.getWidth(null),
                source.getHeight(null),
                BufferedImage.TYPE_INT_ARGB);

        Graphics2D g = bufferedImage.createGraphics();
        g.drawImage(source, source.getWidth(null), 0, -source.getWidth(null), source.getHeight(null), null);
        g.dispose();

        return bufferedImage;
    }
}