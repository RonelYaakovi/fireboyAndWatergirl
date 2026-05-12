package org.example;

import java.awt.*;

public class Door extends GameObject {

    private boolean isOpen;
    private Image imgClosed;
    private Image imgOpen;

    public Door(int x, int y, Image imgClosed, Image imgOpen) {
        // קריאה לבנאי של GameObject (מעבירים מיקום וקובעים גודל קבוע לדלת)
        super(x, y, 50, 70);

        this.imgClosed = imgClosed;
        this.imgOpen = imgOpen;
        this.isOpen = false; // מתחיל סגור
    }

    // מתודה לפתיחת הדלת (כשהשחקן עומד עליה)
    public void open() {
        this.isOpen = true;
    }

    // מתודה לסגירת הדלת (כשהשחקן עוזב אותה)
    public void close() {
        this.isOpen = false;
    }

    // בדיקת הסטטוס (לצורך בדיקת ניצחון)
    public boolean isOpen() {
        return isOpen;
    }

    // ציור הדלת בהתאם לסטטוס שלה
    public void paint(Graphics g) {
        if (isOpen) {
            g.drawImage(imgOpen, getX(), getY(),getWidth(), getHeight(), null);
        } else {
            g.drawImage(imgClosed, getX(), getY(),getWidth(), getHeight(), null);
        }
    }
}
