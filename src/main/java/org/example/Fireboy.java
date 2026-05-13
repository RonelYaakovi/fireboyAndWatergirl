package org.example;

import javax.swing.ImageIcon;
import java.awt.*;
import java.awt.image.BufferedImage;

public class Fireboy extends Character {

    public Fireboy(int x, int y, int screenWidth, int screenHeight) {
        super(x, y, screenWidth, screenHeight);

        this.idleRight = new ImageIcon("C:\\Users\\RONEL\\Downloads\\download (2).jpg").getImage();
        this.idleLeft = new ImageIcon("C:\\Users\\RONEL\\Downloads\\di78o3m-8348947e-828b-4087-96a8-d660fad38717.png").getImage();

        String folderPath = "C:\\Users\\RONEL\\Downloads\\ezgif-split\\";
        int numberOfFrames = 31;

        this.runRightFrames = new Image[numberOfFrames];
        this.runLeftFrames = new Image[numberOfFrames];

        // טעינת הפריימים ויצירת שיקוף לצד שמאל
        for (int i = 0; i < numberOfFrames; i++) {
            // בניית שם הקובץ (למשל Frame000.jpg)
            String fileName = "Frame" + String.format("%03d", i) + ".jpg";
            Image img = new ImageIcon(folderPath + fileName).getImage();

            // שמירה למערך ימינה
            this.runRightFrames[i] = img;

            // יצירת גרסה הפוכה למערך שמאלה
            this.runLeftFrames[i] = createFlippedImage(img);
        }

        // הגדרת מצב עמידה (Idle) כפריים הראשון במערך
        this.idleRight = this.runRightFrames[0];
        this.idleLeft = this.runLeftFrames[0];
        this.currentImage = this.idleRight;
    }

    // פונקציית עזר שהופכת את התמונה מצד לצד (Flip)
    private Image createFlippedImage(Image source) {
        BufferedImage bufferedImage = new BufferedImage(
                source.getWidth(null),
                source.getHeight(null),
                BufferedImage.TYPE_INT_RGB); // JPG לא תומך בשקיפות

        Graphics2D g = bufferedImage.createGraphics();
        // מצייר את התמונה הפוך: מתחיל מהסוף ומתקדם להתחלה
        g.drawImage(source, source.getWidth(null), 0, -source.getWidth(null), source.getHeight(null), null);
        g.dispose();

        return bufferedImage;


    }
}