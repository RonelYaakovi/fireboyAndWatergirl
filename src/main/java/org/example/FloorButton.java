package org.example;

import javax.swing.*;
import java.awt.*;

public class FloorButton extends GameObject {
    private Image onImage;
    private Image offImage;
    private boolean isPressed = false;

    // הבנאי מקבל רק X ו-Y מהמטריצה
    public FloorButton(int x, int y) {
        // מעבירים לאב רוחב 50, גובה 20.
        // מוסיפים 30 ל-Y כדי שהכפתור ישב בדיוק למטה (על הרצפה של המשבצת)
        super(x, y + 30, 50, 20);

        // טוענים שתי תמונות שונות כדי שיראו הבדל בלחיצה
        this.onImage = new ImageIcon("button_on.png").getImage();
        this.offImage = new ImageIcon("button_off.png").getImage();
    }

    // שיניתי לאות קטנה (מוסכמה בג'אווה למתודות)
    public void press() {
        this.isPressed = true;
    }

    // הוספתי גם פונקציית שחרור למקרה ותרצה שהכפתור ייכבה כשיורדים ממנו
    // (ולקרוא לה מה-GamePanel)
    public void release() {
        this.isPressed = false;
    }

    // כדי שה-GamePanel יוכל לבדוק אם הכפתור לחוץ
    // (למשל כדי לדעת אם לפתוח את ה-Gate)
    public boolean isPressed() {
        return this.isPressed;
    }

    public void draw(Graphics g) {
        if (isPressed) {
            g.drawImage(onImage, getX(), getY(), getWidth(), getHeight(), null);
        } else {
            g.drawImage(offImage, getX(), getY(), getWidth(), getHeight(), null);
        }
    }
}