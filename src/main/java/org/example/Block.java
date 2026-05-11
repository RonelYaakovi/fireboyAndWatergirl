package org.example;

import javax.swing.*;
import java.awt.*;

public class Block extends GameObject {

    private Image image = new ImageIcon("block.png").getImage();

    public Block(int x, int y, int width, int height) {
        super(x, y, width, height);
    }
    public void draw(Graphics g) {
        g.drawImage(image,getX(), getY(), getWidth(), getHeight(), null);
    }
}
