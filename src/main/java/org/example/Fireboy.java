package org.example;

import javax.swing.ImageIcon;

public class Fireboy extends Character {

    public Fireboy(int x, int y, int screenWidth, int screenHeight) {
        super(x, y, screenWidth, screenHeight);

        // טעינת ה-GIF-ים של בן האש (תכניס פה את הנתיבים המדויקים שלך!)
        this.imageRight = new ImageIcon("C:\\Users\\RONEL\\IdeaProjects\\fireboyAndWatergirl\\src\\images\\fireboy_right.gif").getImage();
        this.imageLeft = new ImageIcon("C:\\Users\\RONEL\\IdeaProjects\\fireboyAndWatergirl\\src\\images\\fireboy_left.gif").getImage();

        this.currentImage = this.imageRight;
    }
}