package org.example;

import javax.swing.*;
import java.awt.*;

public class Gate extends GameObject {
    private Image gateImage;
    private boolean isOpening = false;

    private int originalY;
    private int targetY;
    private int speed = 2;

    // הבנאי מקבל עכשיו רק x ו-y!
    public Gate(int x, int y) {
        // מעבירים לאב את המיקום, ומקבעים את הגודל ל-50x50 (או כל גודל משבצת אחר שתבחר)
        super(x, y, 50, 50);

        gateImage = new ImageIcon("gate.png").getImage();

        this.originalY = y;
        // כאן אנחנו משתמשים ב-getHeight() שקיבלנו מהאב (שזה עכשיו תמיד 50)
        this.targetY = y - getHeight();
    }

    public void open() {
        this.isOpening = true;
    }

    public void close() {
        this.isOpening = false;
    }

    public void update() {
        if (isOpening) {
            if (getY() > targetY) {
                super.setY(getY() - speed);
                if (getY() < targetY) {
                    super.setY(targetY);
                }
            }
        }
        else {
            if (getY() < originalY) {
                super.setY(getY() + speed);
                if (getY() > originalY) {
                    super.setY(originalY);
                }
            }
        }
    }

    public void draw(Graphics g) {
        g.drawImage(gateImage, getX(), getY(), getWidth(), getHeight(), null);
    }
}