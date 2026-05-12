package org.example;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class Character {
    protected int x, y, width, height;
    protected int diamondCount =0;
    protected int screenWidth, screenHeight; // משתנים חדשים לגבולות המסך
    protected Image imageRight, imageLeft, currentImage;

    protected double velocityY;
    protected double gravity = 0.8;
    protected double jumpStrength = -15;

    protected boolean onGround = false;
    protected boolean isAlive;
    protected int velX = 0;

    // הבנאי מעודכן לקבל את מידות המסך
    public Character(int x, int y, int screenWidth, int screenHeight) {
        this.x = x;
        this.y = y;
        this.width = 100;
        this.height = 100;
        this.screenWidth = screenWidth;
        this.screenHeight = screenHeight;
        this.velocityY = 0;
        isAlive=true;
    }

    public Rectangle getBounds() {
        return new Rectangle(x, y, width, height);
    }
    public void addToDiamondCount() {
        this.diamondCount ++;
    }
    public void moveRight() {
        this.velX = 5; // מגדיר מהירות ימינה
        this.currentImage = imageRight; // מעדכן לתמונה הנכונה
    }

    public void moveLeft() {
        this.velX = -5; // מגדיר מהירות שמאלה
        this.currentImage = imageLeft; // מעדכן לתמונה הנכונה
    }

    public void stopMoving() {
        this.velX = 0; // מאפס את המהירות האופקית
        // שים לב: אנחנו לא משנים פה את התמונה, כדי שהדמות תישאר להסתכל
        // לכיוון האחרון שאליו היא הלכה, במקום להפוך לריבוע או להיעלם.
    }

    public void jump() {
        if (onGround) {
            this.velocityY = this.jumpStrength;
            this.onGround = false;
        }
    }

    public void update(ArrayList<Rectangle> platforms) {
        // --- 1. טיפול בציר X ---
        x += velX;

        // עצירה בקירות (פלטפורמות)
        for (Rectangle p : platforms) {
            if (getBounds().intersects(p)) {
                if (velX > 0) x = p.x - width;
                if (velX < 0) x = p.x + p.width;
            }
        }

        // עצירה בקצוות המסך (ימין ושמאל)
        if (x < 0) {
            x = 0; // חסימה מצד שמאל
        } else if (x + width > screenWidth) {
            x = screenWidth - width; // חסימה מצד ימין
        }

        // --- 2. טיפול בציר Y ---
        velocityY += gravity;
        y += velocityY;
        onGround = false;

        // התנגשות בפלטפורמות מלמעלה ומלמטה
        for (Rectangle p : platforms) {
            if (getBounds().intersects(p)) {
                if (velocityY > 0) {
                    y = p.y - height;
                    velocityY = 0;
                    onGround = true;
                } else if (velocityY < 0) {
                    y = p.y + p.height;
                    velocityY = 0;
                }
            }
        }

        // --- 3. מניעת נפילה אל מחוץ למסך (רצפה גלובלית) ---
        // עכשיו משתמשים ב-screenHeight במקום במספר קבוע
        if (y + height >= screenHeight) {
            y = screenHeight - height;
            velocityY = 0;
            onGround = true;
        }
    }
    public void died(){
        isAlive=false;
    }
    public boolean isAlive() {
        return isAlive;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getDiamondCount() {
        return diamondCount;
    }

    public void setDiamondCount(int diamondCount) {
        this.diamondCount = diamondCount;
    }

    public int getScreenWidth() {
        return screenWidth;
    }

    public void setScreenWidth(int screenWidth) {
        this.screenWidth = screenWidth;
    }

    public int getScreenHeight() {
        return screenHeight;
    }

    public void setScreenHeight(int screenHeight) {
        this.screenHeight = screenHeight;
    }

    public Image getImageRight() {
        return imageRight;
    }

    public void setImageRight(Image imageRight) {
        this.imageRight = imageRight;
    }

    public Image getImageLeft() {
        return imageLeft;
    }

    public void setImageLeft(Image imageLeft) {
        this.imageLeft = imageLeft;
    }

    public Image getCurrentImage() {
        return currentImage;
    }

    public void setCurrentImage(Image currentImage) {
        this.currentImage = currentImage;
    }

    public double getVelocityY() {
        return velocityY;
    }

    public void setVelocityY(double velocityY) {
        this.velocityY = velocityY;
    }

    public double getGravity() {
        return gravity;
    }

    public void setGravity(double gravity) {
        this.gravity = gravity;
    }

    public double getJumpStrength() {
        return jumpStrength;
    }

    public void setJumpStrength(double jumpStrength) {
        this.jumpStrength = jumpStrength;
    }

    public boolean isOnGround() {
        return onGround;
    }

    public void setOnGround(boolean onGround) {
        this.onGround = onGround;
    }

    public int getVelX() {
        return velX;
    }

    public void setVelX(int velX) {
        this.velX = velX;
    }

    public void paint(Graphics g) {
        if (currentImage != null) {
            g.drawImage(currentImage, x, y, width, height, null);
        }

        }
    }
