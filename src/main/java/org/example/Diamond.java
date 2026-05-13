package org.example;

import java.awt.*;

public class Diamond extends GameObject {

    private Image diamondImage;
    private String type; // "FIRE" או "WATER"
    private boolean isCollected = false;

    public Diamond(int x, int y, Image diamondImage, String type) {
        // כדי להגדיל: נוריד את הרווח (x+2 במקום x+5) ונגדיל את המידות ל-20x20
        super(x + 2, y + 2, 20, 20);
        this.diamondImage = diamondImage;
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
        if (!isCollected && diamondImage != null) {
            g.drawImage(diamondImage, getX(), getY(), getWidth(), getHeight(), null);
        }
    }
}