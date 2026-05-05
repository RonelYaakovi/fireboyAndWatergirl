package org.example;

import javax.swing.ImageIcon;

public class FireBoy extends Character {

    public FireBoy(int x, int y) {
        super(x, y);

        // טעינת ה-GIF-ים של בן האש (תכניס פה את הנתיבים המדויקים שלך!)
        this.imageRight = new ImageIcon("C:\\Users\\RONEL\\IdeaProjects\\fireboyAndWatergirl\\src\\images\\fireboy_right.gif").getImage();
        this.imageLeft = new ImageIcon("C:\\Users\\RONEL\\IdeaProjects\\fireboyAndWatergirl\\src\\images\\fireboy_left.gif").getImage();

        this.currentImage = this.imageRight;
    }
}