package org.example;

import java.awt.*;
import java.util.ArrayList;

public class Character {
    protected int x, y, width, height;
    protected int diamondCount = 0;
    protected int screenWidth, screenHeight;

    // --- מערכי תמונות אנימציה (ריצה) ---
    protected Image[] runRightFrames;
    protected Image[] runLeftFrames;

    // --- מערכי תמונות אנימציה (עמידה) ---
    protected Image[] idleRightFrames;
    protected Image[] idleLeftFrames;

    // תמונות עמידה בודדות (למקרה שאין אנימציית עמידה)
    protected Image idleRight;
    protected Image idleLeft;

    protected Image currentImage;

    protected boolean isFacingRight = true;
    protected int currentFrameIndex = 0;
    protected int animationTick = 0;

    // --- הגדרות מהירות אנימציה ---
    protected int animationSpeed = 5;
    protected int idleAnimationSpeed = 15;

    protected double velocityY;
    protected double gravity = 0.8;
    protected double jumpStrength = -13;

    protected boolean onGround = false;
    protected boolean isAlive;
    protected boolean isOnTheDoor = false;
    protected int velX = 0;

    public Character(int x, int y, int screenWidth, int screenHeight) {
        this.x = x;
        this.y = y;
        // אלו המידות הפיזיות האמיתיות של ההיטבוקס (Hitbox)
        this.width = 30;
        this.height = 40;
        this.screenWidth = screenWidth;
        this.screenHeight = screenHeight;
        this.velocityY = 0;
        this.isAlive = true;
    }

    public Rectangle getBounds() {
        return new Rectangle(x, y, width, height);
    }

    public void addToDiamondCount() {
        this.diamondCount++;
    }

    public void moveRight() {
        this.velX = 3;
        this.isFacingRight = true;
    }

    public void moveLeft() {
        this.velX = -3;
        this.isFacingRight = false;
    }

    public void stopMoving() {
        this.velX = 0;
        this.currentFrameIndex = 0;
        this.animationTick = 0;
    }

    public void jump() {
        if (onGround) {
            this.velocityY = this.jumpStrength;
            this.onGround = false;
        }
    }

    public void update(ArrayList<Rectangle> platforms) {
        x += velX;
        for (Rectangle p : platforms) {
            if (getBounds().intersects(p)) {
                if (velX > 0) x = p.x - width;
                if (velX < 0) x = p.x + p.width;
            }
        }
        if (x < 0) x = 0;
        else if (x + width > screenWidth) x = screenWidth - width;

        velocityY += gravity;
        y += velocityY;
        onGround = false;

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

        if (y + height >= screenHeight) {
            y = screenHeight - height;
            velocityY = 0;
            onGround = true;
        }

        if (velX != 0) {
            animationTick++;
            if (animationTick >= animationSpeed) {
                animationTick = 0;
                if (isFacingRight && runRightFrames != null) {
                    currentFrameIndex = (currentFrameIndex + 1) % runRightFrames.length;
                    currentImage = runRightFrames[currentFrameIndex];
                } else if (!isFacingRight && runLeftFrames != null) {
                    currentFrameIndex = (currentFrameIndex + 1) % runLeftFrames.length;
                    currentImage = runLeftFrames[currentFrameIndex];
                }
            }
        } else {
            if (idleRightFrames != null && idleLeftFrames != null) {
                animationTick++;
                if (animationTick >= idleAnimationSpeed) {
                    animationTick = 0;
                    currentFrameIndex = (currentFrameIndex + 1) % idleRightFrames.length;
                }
                currentImage = isFacingRight ? idleRightFrames[currentFrameIndex] : idleLeftFrames[currentFrameIndex];
            } else {
                currentImage = isFacingRight ? idleRight : idleLeft;
            }
        }
    }

    public void paint(Graphics g) {
        if (currentImage != null && isAlive) {

            // במקום לצייר את התמונה בדיוק על ההיטבוקס, אנחנו מרחיבים ומזיזים אותה קצת
            // המספרים האלו "מפצים" על השטח השקוף שיש בתמונה
            int imageX = x - 10;       // מזיז את הציור שמאלה
            int imageY = y - 10;       // מזיז את הציור למעלה
            int imageWidth = width + 20;  // מגדיל את הציור
            int imageHeight = height + 10; // מגדיל את הציור

            g.drawImage(currentImage, imageX, imageY, imageWidth, imageHeight, null);

            // ---------------------------------------------------------
            // טריק מפתחים: תמחק את ה-// משתי השורות למטה כדי לראות
            // בדיוק איפה נמצאת קופסת ההתנגשות (ההיטבוקס) הבלתי נראית!
            // ---------------------------------------------------------
            // g.setColor(Color.RED);
            // g.drawRect(x, y, width, height);
        }
    }

    public void died() { isAlive = false; }
    public boolean isAlive() { return isAlive; }
    public void onTheDoor() { isOnTheDoor = true; }
    public void notONTheDoor() { isOnTheDoor = false; }
    public boolean isOnTheDoor() { return isOnTheDoor; }
}