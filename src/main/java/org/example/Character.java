package org.example;

import java.awt.*;
import java.util.ArrayList;

public class Character {
    protected int x, y, width, height;
    protected int diamondCount = 0;
    protected int screenWidth, screenHeight;

    // --- מערכי תמונות אנימציה ---
    protected Image[] runRightFrames;
    protected Image[] runLeftFrames;
    protected Image idleRight;
    protected Image idleLeft;
    protected Image currentImage;

    // --- טיימר אנימציה ---
    protected boolean isFacingRight = true;
    protected int currentFrameIndex = 0;
    protected int animationTick = 0;
    protected int animationSpeed = 5; // מהירות החלפת תמונות

    protected double velocityY;
    protected double gravity = 0.8;
    protected double jumpStrength = -13;

    protected boolean onGround = false;
    protected boolean isAlive;
    protected int velX = 0;

    public Character(int x, int y, int screenWidth, int screenHeight) {
        this.x = x;
        this.y = y;
        this.width = 50;  // הותאם לעבור במפה
        this.height = 40; // הותאם לעבור במפה
        this.screenWidth = screenWidth;
        this.screenHeight = screenHeight;
        this.velocityY = 0;
        isAlive=true;
    }

    public Rectangle getBounds() {
        return new Rectangle(x, y, width, height);
    }

    public void addToDiamondCount() {
        this.diamondCount++;
    }

    public void moveRight() {
        this.velX = 2;
        this.isFacingRight = true;
    }

    public void moveLeft() {
        this.velX = -2;
        this.isFacingRight = false;
    }

    public void stopMoving() {
        this.velX = 0;
        this.currentFrameIndex = 0; // איפוס אנימציה
        this.currentImage = isFacingRight ? idleRight : idleLeft;
    }

    public void jump() {
        if (onGround) {
            this.velocityY = this.jumpStrength;
            this.onGround = false;
        }
    }

    public void update(ArrayList<Rectangle> platforms) {
        // --- 1. תנועה והתנגשות ציר X ---
        x += velX;
        for (Rectangle p : platforms) {
            if (getBounds().intersects(p)) {
                if (velX > 0) x = p.x - width;
                if (velX < 0) x = p.x + p.width;
            }
        }
        if (x < 0) x = 0;
        else if (x + width > screenWidth) x = screenWidth - width;

        // --- 2. תנועה והתנגשות ציר Y ---
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

        // --- 3. עדכון פריים אנימציה ---
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
            currentImage = isFacingRight ? idleRight : idleLeft;
        }
    }

    public void paint(Graphics g) {
        if (currentImage != null) {
            g.drawImage(currentImage, x, y, width, height, null);
        }
    }

    // שאר הגטרים והסטרס שלך (isAlive, died וכו')...
    public void died(){ isAlive=false; }
    public boolean isAlive() { return isAlive; }
}