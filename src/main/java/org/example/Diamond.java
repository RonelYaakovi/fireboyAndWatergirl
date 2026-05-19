package org.example;

import javax.swing.ImageIcon;
import java.awt.*;

public class Diamond extends GameObject {

    private Image currentImage; // רק משתנה אחד ששומר את התמונה שבאמת צריך
    private String type;        // "red" או "blue"
    private boolean isCollected = false;

    public Diamond(int x, int y, String type) {
        // כדי להגדיל: נוריד את הרווח (x+2 במקום x+5) ונגדיל את המידות ל-20x20
        super(x , y , 20, 20);
        this.type = type;
        this.isCollected = false;

        // טעינת התמונה ישירות מהקובץ לפי הסוג (כמו שעשינו בדלת)
        if (this.type.equals("red")) {
            this.currentImage = new ImageIcon("red_diamond.png").getImage();
        }
        else if (this.type.equals("blue")) {
            this.currentImage = new ImageIcon("blue_diamond.png").getImage();
        }
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
        if (!isCollected) {
            // מציירים פשוט את currentImage, המחלקה כבר יודעת איזו תמונה זו
            g.drawImage(currentImage, getX(), getY(), getWidth(), getHeight(), null);
        }
    }
}