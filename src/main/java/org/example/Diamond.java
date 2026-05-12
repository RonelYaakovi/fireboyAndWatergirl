package org.example;

import java.awt.*;

// ירושה ממחלקת האב!
public class Diamond extends GameObject {

    private Image diamondImage;

    public Diamond(int x, int y, Image diamondImage) {
        // קריאה לבנאי של מחלקת האב (מעבירים לו מיקום וגודל)
        // נוסיף 10 למיקום כדי למרכז את היהלום במשבצת, ונגדיר גודל 30x30
        super(x + 10, y + 10, 30, 30);

        this.diamondImage = diamondImage;
    }

    // אנחנו רק צריכים להגיד איך לצייר אותו
    public void paint(Graphics g) {
        if (diamondImage != null) {
            // משתמשים ב-x, y, width, height שירשנו מהאב
            g.drawImage(diamondImage, getX(), getY(), getWidth(), getHeight(), null);
        }
    }
}