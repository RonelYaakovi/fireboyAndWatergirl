package org.example;

import java.awt.*;

public class Pool extends GameObject {

    private Image poolImage;
    private String type; // יכול להיות: "FIRE", "WATER", "POISON"

    public Pool(int x, int y, Image poolImage, String type) {
        // הבריכה נמוכה יותר מגובה הבלוק (15 פיקסלים גובה) כדי שיראה כמו שלולית
        super(x, y + 10, 25, 30);
        this.poolImage = poolImage;
        this.type = type;
    }

    public String getType() {
        return type;
    }

    public void paint(Graphics g) {
        if (poolImage != null) {
            g.drawImage(poolImage, getX(), getY(), getWidth(), getHeight(), null);
        }
    }
}