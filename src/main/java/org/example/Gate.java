package org.example;

import javax.swing.*;
import java.awt.*;

public class Gate extends GameObject {
    private Image gateImage;
    private boolean isOpening = false; // האם השער בתהליך פתיחה
    private int targetY;               // הגובה המקסימלי אליו הוא צריך להגיע
    private int speed = 2;             // מהירות העלייה (פיקסלים לפריים)

    public Gate(int x, int y, int width, int height) {
        super(x, y, width, height);
        gateImage = new ImageIcon("gate.png").getImage(); // רק תמונה אחת!

        // נגדיר שהשער אמור לעלות למעלה מרחק ששווה לגובה שלו
        // (אפשר גם לתת מספר קבוע אחר, למשל y - 100)
        this.targetY = y - height;
    }

    // הפונקציה שנקרא לה מהכפתור
    public void open() {
        this.isOpening = true;
    }

    // הפונקציה החדשה: אחראית על התנועה עצמה
    public void update() {
        // אם אמרו לו להיפתח, והוא עדיין לא הגיע ליעד שלו למעלה
        if (isOpening && getY() > targetY) {

            // מזיזים אותו למעלה על ידי חיסור מה-Y הנוכחי
            // הערה: ודא שיש לך מתודת setY במחלקת GameObject שלך!
            super.setY(getY() - speed);
        }
    }

    public void draw(Graphics g) {
        // תמיד מציירים את אותה תמונה, היא פשוט תצוייר ב-Y חדש בכל פעם
        g.drawImage(gateImage, getX(), getY(), getWidth(), getHeight(), null);
    }
}