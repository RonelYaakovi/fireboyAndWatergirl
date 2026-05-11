package org.example;

import javax.swing.*;
import java.awt.*;

public class FloorButton extends GameObject{
    Image onimage;
    Image offimage;
    boolean isPressed = false;

    public FloorButton(int x, int y, int width, int height) {
        super(x, y, width, height);
            onimage = new ImageIcon("floor.png").getImage();
            offimage = new ImageIcon("floor.png").getImage();
    }

        public void Press() {
        isPressed = true;
        }




    public void draw(Graphics g) {
        if(isPressed) {
            g.drawImage(onimage,getX(), getY(), getWidth(), getHeight(), null);
        }else  {
            g.drawImage(offimage,getX(), getY(), getWidth(), getHeight(), null);
        }
    }

}
