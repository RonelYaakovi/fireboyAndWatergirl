package org.example;

import javax.swing.ImageIcon;
import java.awt.*;

public class Door extends GameObject {

    private boolean isOpen;
    private Image imgClosed;
    private Image imgOpen;
    private String type;

    public Door(int x, int y, String type) {
        // קריאה לבנאי של GameObject (מעבירים מיקום וקובעים גודל קבוע לדלת)
        super(x, y, 50, 70);
        this.type = type;
        this.isOpen = false; // מתחיל סגור

        // טעינת התמונות לפי סוג הדלת
        if (this.type.equals("red")) {
            this.imgClosed = new ImageIcon("red_door_closed.png").getImage();
            this.imgOpen = new ImageIcon("red_door_open.png").getImage();
        }
        else if (this.type.equals("blue")) {
            this.imgClosed = new ImageIcon("blue_door_closed.png").getImage();
            this.imgOpen = new ImageIcon("blue_door_open.png").getImage();
        }
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
            // אם הדלת פתוחה, תצייר את התמונה הפתוחה (אדומה או כחולה, בהתאם למה שנטען בבנאי)
            g.drawImage(imgOpen, getX(), getY(), getWidth(), getHeight(), null);
        } else {
            // אם סגורה, תצייר את התמונה הסגורה
            g.drawImage(imgClosed, getX(), getY(), getWidth(), getHeight(), null);
        }
    }
}
