package org.example;

import javax.swing.*;
import java.awt.*;

public class Character {
    protected int x;
    protected int y;
    protected int width;
    protected int height;
    protected int ground;

    protected Image imageRight;
    protected Image imageLeft;
    protected Image currentImage;

    protected int velocityY;
    protected int gravity;
    protected boolean isJumping = false;
    protected int jumpStrength = -15;

    public Character(int x, int y) {
        this.x = x;
        this.y = y;
        this.width = 100;
        this.height = 100;
        this.velocityY = 0;
        this.ground = 826 - height;

        this.gravity = 1;
    }

    public void paint(Graphics g) {
        if (currentImage != null) {
            g.drawImage(currentImage, x, y, width, height, null);
        }
    }

    public void moveRight() {
        currentImage = imageRight;
        x += 5;
    }

    public void moveLeft() {
        currentImage = imageLeft;
        x -= 5;
    }

    public void jump() {
        if (!isJumping) {
            this.velocityY = this.jumpStrength;
            this.isJumping = true;
        }
    }

    public void update() {
        if (isJumping) {
            this.velocityY += this.gravity;
            this.y += this.velocityY;

            if (this.y >= this.ground) {
                this.y = this.ground;
                this.velocityY = 0;
                this.isJumping = false;
            }
        }
    }
}