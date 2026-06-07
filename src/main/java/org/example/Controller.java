package org.example;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

public class Controller implements KeyListener, FocusListener {

    private Character fireBoy;
    private Character watergirl;


    private boolean[] booleans;

    public Controller(Character fireBoy, Character watergirl) {
        this.fireBoy = fireBoy;
        this.watergirl = watergirl;
        this.booleans = new boolean[6];
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();

        if (key == KeyEvent.VK_RIGHT) booleans[0] = true;
        else if (key == KeyEvent.VK_LEFT) booleans[1] = true;
        else if (key == KeyEvent.VK_UP) booleans[2] = true;

        else if (key == KeyEvent.VK_D) booleans[3] = true;
        else if (key == KeyEvent.VK_A) booleans[4] = true;
        else if (key == KeyEvent.VK_W) booleans[5] = true;
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

    public void applyInputs() {

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

    @Override
    public void focusGained(FocusEvent e) {
    }

    @Override
    public void focusLost(FocusEvent e) {
        for (int i = 0; i < booleans.length; i++) {
            booleans[i] = false;
        }
        fireBoy.stopMoving();
        watergirl.stopMoving();
    }
}