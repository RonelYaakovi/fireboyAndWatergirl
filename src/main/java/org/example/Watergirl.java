package org.example;

import javax.swing.*;

public class Watergirl extends Character {

    public Watergirl(int x, int y, int screenWidth, int screenHeight) {
        super(x, y, screenWidth, screenHeight);
        this.imageRight = new ImageIcon("C:\\Users\\RONEL\\IdeaProjects\\fireboyAndWatergirl\\src\\images\\fireboy_right.gif").getImage();
        this.imageLeft = new ImageIcon("C:\\Users\\RONEL\\IdeaProjects\\fireboyAndWatergirl\\src\\images\\fireboy_left.gif").getImage();
//        לשנות את התמונות
        this.currentImage = this.imageRight;
    }
}


