package org.example;

import java.awt.*;

public class Diamond extends GameObject {

    private Image currentImage;
    private String type;
    private boolean isCollected = false;

    public Diamond(int x, int y, Image diamondImage, String type) {
        super(x + 2, y + 2, 20, 20);
        this.currentImage = diamondImage;
        this.type = type;
        this.isCollected = false;
    }

    public String getType() {
        return type;
    }

    public boolean isCollected() {
        return isCollected;
    }

    public void setCollected(boolean collected) {
        this.isCollected = collected;
    }

    public void paint(Graphics g) {
        if (!isCollected && currentImage != null) {
            g.drawImage(currentImage, getX(), getY(), getWidth(), getHeight(), null);
        }
    }
}