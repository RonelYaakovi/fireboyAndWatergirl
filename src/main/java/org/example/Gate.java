package org.example;

import javax.swing.*;
import java.awt.*;

public class Gate extends GameObject {
    private Image gateImage;
    private boolean isOpening = false;

    private int originalY; // המיקום ההתחלתי (שער סגור למטה)
    private int targetY;   // הגובה המקסימלי (שער פתוח למעלה)
    private int speed = 2; // מהירות התנועה

    public Gate(int x, int y, int width, int height) {
        super(x, y, width, height);
        // טעינת התמונה (מומלץ להעביר מה-GamePanel כדי לא לטעון מחדש לכל שער, אבל נשאיר ככה לבקשתך)
        gateImage = new ImageIcon("gate.png").getImage();

        this.originalY = y;          // שומרים את ה-Y המקורי בזיכרון!
        this.targetY = y - height;   // קובעים את יעד הפתיחה
    }

    // הפונקציה שנקרא לה מהכפתור כשהשחקן עומד עליו
    public void open() {
        this.isOpening = true;
    }

    // הפונקציה שנקרא לה כשהשחקן יורד מהכפתור
    public void close() {
        this.isOpening = false;
    }

    // הפונקציה המעודכנת: מטפלת גם בעלייה וגם בירידה
    public void update() {

        if (isOpening) {
            // אם צריך להיפתח והוא עדיין נמוך מהיעד
            if (getY() > targetY) {
                super.setY(getY() - speed); // עולה למעלה

                // תיקון קטן: מוודאים שלא עלינו "יותר מדי" בגלל המהירות
                if (getY() < targetY) {
                    super.setY(targetY);
                }
            }
        }
        else {
            // אם צריך להיסגר והוא עדיין גבוה מהמקור
            if (getY() < originalY) {
                super.setY(getY() + speed); // יורד למטה

                // תיקון: מוודאים שלא נכנסנו מתחת לרצפה
                if (getY() > originalY) {
                    super.setY(originalY);
                }
            }
        }
    }

    public void draw(Graphics g) {
        // ציור השער במיקומו העדכני
        g.drawImage(gateImage, getX(), getY(), getWidth(), getHeight(), null);
    }
}