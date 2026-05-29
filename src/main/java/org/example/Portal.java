package org.example;
import javax.swing.*;
import java.awt.*;

public class Portal extends GameObject {
    private Image image;
    private boolean fireBoyEntered = false;
    private boolean waterGirlEntered = false;

    public Portal(int x, int y) {
        super(x, y, 50, 75);
        this.image = new ImageIcon("src/images/start screen/unknown.png").getImage();
    }

    public void draw(Graphics g) {
        if (image != null) {
            g.drawImage(image, getX(), getY(), getWidth(), getHeight(), null);
        }
    }

    public void setFireBoyEntered() { this.fireBoyEntered = true; }
    public void setWaterGirlEntered() { this.waterGirlEntered = true; }
    public boolean areBothInside() { return fireBoyEntered && waterGirlEntered; }

    public void reset() {
        this.fireBoyEntered = false;
        this.waterGirlEntered = false;
    }
}