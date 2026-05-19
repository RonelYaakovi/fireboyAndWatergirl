package org.example;

import java.awt.*;

public class Pool extends GameObject {

    private Image currentImage;
    private Image redPoolImage;
    private Image bluePoolImage;
    private Image greenPoolImage;
    private String type; // יכול להיות: "FIRE", "WATER", "POISON"

    public Pool(int x, int y, String type) {
        // הבריכה נמוכה יותר מגובה הבלוק (15 פיקסלים גובה) כדי שיראה כמו שלולית
        super(x, y + 10, 25, 30);
        this.type = type;
        if (type.equals("red")) {
            currentImage = redPoolImage;
        }else if (type.equals("blue")) {
            currentImage = bluePoolImage;
        }
        else if (type.equals("green")) {
            currentImage = greenPoolImage;
        }
    }

    public String getType() {
        return type;
    }

    public void paint(Graphics g) {
        if (currentImage!= null) {
            g.drawImage(currentImage, getX(), getY(), getWidth(), getHeight(), null);
        }
    }
}