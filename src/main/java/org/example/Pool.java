package org.example;

import java.awt.*;

public class Pool extends GameObject {

    private Image poolImage;

    // בנאי שמקבל מיקום ואת סוג התמונה (לבה או מים)
    public Pool(int x, int y, Image poolImage) {
        // קריאה לבנאי של מחלקת האב:
        // אנחנו ממקמים את הבריכה קצת יותר נמוך (y + 25) ועושים אותה בגובה 25 במקום 50
        super(x, y + 25, 50, 25);

        this.poolImage = poolImage;
    }


    public void paint(Graphics g) {
        if (poolImage != null) {
            g.drawImage(poolImage, getX(), getY(),getWidth(), getHeight(), null);
        }
        }
    }
