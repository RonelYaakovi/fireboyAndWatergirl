package org.example;

import javax.swing.*;
import java.awt.*;

public class Gate extends GameObject {
    private Image gateImage;
    private boolean isOpening = false;

    private int originalY;
    private int targetY;
    private int speed = 2;

    public Gate(int x, int y) {
        super(x, y, 50, 50);

        gateImage = new ImageIcon("src/images/start screen/gate.png").getImage();// זה לא באמת עובד

        this.originalY = y;
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