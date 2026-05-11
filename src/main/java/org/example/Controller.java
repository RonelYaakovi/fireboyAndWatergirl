package org.example;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Controller implements KeyListener {

    // אני משתמש במחלקת האב Character כדי שזה יעבוד גם ל-FireBoy וגם ל-Watergirl
    private Character fireBoy;
    private Character watergirl;

    // אינדקסים:
    // 0=ימינה(אש), 1=שמאלה(אש), 2=קפיצה(אש)
    // 3=ימינה(מים), 4=שמאלה(מים), 5=קפיצה(מים)
    private boolean[] booleans;

    public Controller(Character fireBoy, Character watergirl) {
        this.fireBoy = fireBoy;
        this.watergirl = watergirl;
        this.booleans = new boolean[6];
    }

    @Override
    public void keyTyped(KeyEvent e) {
        // לא צריך לממש כלום כאן
    }

    @Override
    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();

        // --- מקשי FireBoy (חצים) ---
        if (key == KeyEvent.VK_RIGHT) booleans[0] = true;
        else if (key == KeyEvent.VK_LEFT) booleans[1] = true;
        else if (key == KeyEvent.VK_UP) booleans[2] = true;

            // --- מקשי Watergirl (WASD) ---
        else if (key == KeyEvent.VK_D) booleans[3] = true; // D = ימינה
        else if (key == KeyEvent.VK_A) booleans[4] = true; // A = שמאלה
        else if (key == KeyEvent.VK_W) booleans[5] = true; // W = קפיצה
    }

    @Override
    public void keyReleased(KeyEvent e) {
        int key = e.getKeyCode();

        if (key == KeyEvent.VK_RIGHT) booleans[0] = false;
        else if (key == KeyEvent.VK_LEFT) booleans[1] = false;
        else if (key == KeyEvent.VK_UP) booleans[2] = false;

        else if (key == KeyEvent.VK_D) booleans[3] = false;
        else if (key == KeyEvent.VK_A) booleans[4] = false;
        else if (key == KeyEvent.VK_W) booleans[5] = false;
    }

    // הפונקציה הזו תיקרא מתוך לולאת המשחק המרכזית (Game Loop) בכל פריים
    public void applyInputs() {

        // --- תנועת FireBoy ---
        if (booleans[0]) {
            fireBoy.moveRight();
        } else if (booleans[1]) {
            fireBoy.moveLeft();
        } else {
            fireBoy.stopMoving();
        }

        if (booleans[2]) {
            fireBoy.jump();
        }
        // --- תנועת Watergirl ---
        if (booleans[3]) {
            watergirl.moveRight();
        } else if (booleans[4]) {
            watergirl.moveLeft();
        } else {
            watergirl.stopMoving();
        }

        if (booleans[5]) {
            watergirl.jump();
        }
    }
    }