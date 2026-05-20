package org.example;

import java.awt.*;

public class Pool extends GameObject {

    private Image currentImage;
    private String type;

    public Pool(int x, int y, Image poolImage, String type) {
        super(x, y + 10, 25, 25);
        this.currentImage = poolImage;
        this.type = type;
    }

    public String getType() {
        return type;
    }

    public void paint(Graphics g) {
        if (currentImage != null) {
            g.drawImage(currentImage, getX(), getY(), getWidth(), getHeight(), null);
        }
    }
}