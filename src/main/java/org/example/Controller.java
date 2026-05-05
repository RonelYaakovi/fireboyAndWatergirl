package org.example;

import org.example.FireBoy;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Controller implements KeyListener {
    FireBoy fireBoy;
    Watergirl watergirl;
    boolean[] booleans;

    public Controller(FireBoy fireBoy, Watergirl watergirl) {
        this.fireBoy = fireBoy;
        this.watergirl = watergirl;
        this.booleans = new boolean[6]; // צריך רק ימינה, שמאלה, וקפיצה
        this.move();
    }

    public void keyTyped(KeyEvent e) {
    }

    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_RIGHT)
            this.booleans[0] = true;
        else if (e.getKeyCode() == KeyEvent.VK_LEFT) {
            this.booleans[1] = true;
        } else if (e.getKeyCode() == KeyEvent.VK_UP) {
            this.booleans[2] = true;
        } else if (e.getKeyCode() == KeyEvent.VK_D) {
            booleans[3] = true;
        } else if (e.getKeyCode() == KeyEvent.VK_W) {
            booleans[4] = true;
        } else if (e.getKeyCode() == KeyEvent.VK_A) {
            booleans[5] = true;
        }
    }

    public void keyReleased(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_RIGHT)
            this.booleans[0] = false;
        else if (e.getKeyCode() == KeyEvent.VK_LEFT) {
            this.booleans[1] = false;
        } else if (e.getKeyCode() == KeyEvent.VK_UP || e.getKeyCode() == KeyEvent.VK_SPACE) {
            this.booleans[2] = false;
        } else if (e.getKeyCode() == KeyEvent.VK_D) {
            booleans[3] = false;
        } else if (e.getKeyCode() == KeyEvent.VK_W) {
            booleans[4] = false;
        } else if (e.getKeyCode() == KeyEvent.VK_A) {
            booleans[5] = false;
        }
    }

    public void move() {
        new Thread(() -> {
            while (true) {
                if (booleans[0])
                    this.fireBoy.moveRight();
                if (booleans[1])
                    this.fireBoy.moveLeft();
                if (booleans[2])
                    this.fireBoy.jump();// מפעיל את פיזיקת הקפיצה
                if (booleans[3])
                    this.watergirl.moveRight();
                if (booleans[4])
                    this.watergirl.moveLeft();
                if (booleans[5])
                    this.watergirl.jump();
                try {
                    Thread.sleep(16);
                } catch (InterruptedException e) {
                }
            }
        }).start();
    }
}