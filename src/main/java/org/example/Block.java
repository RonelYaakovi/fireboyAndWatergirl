package org.example;

import java.awt.*;

public class Block extends GameObject {

    private Color blockColor;

    public Block(int x, int y, int width, int height, Color color) {
        super(x, y, width, height);
        this.blockColor = color;
    }

    public void draw(Graphics g) {
        g.setColor(blockColor);
        g.fillRect(getX(), getY(), getWidth(), getHeight());

        // ציור מסגרת שחורה קטנה סביב כל קובייה כדי שייראה כמו אבנים
        g.setColor(Color.BLACK);
        g.drawRect(getX(), getY(), getWidth(), getHeight());
    }
}