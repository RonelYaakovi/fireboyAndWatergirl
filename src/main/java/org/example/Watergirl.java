package org.example;

import javax.swing.ImageIcon;
import java.awt.*;
import java.awt.image.BufferedImage;

public class Watergirl extends Character {

    public Watergirl(int x, int y, int screenWidth, int screenHeight) {
        // שימוש בבנאי של מחלקת האב ובגדלים שהגדרנו (30x40)
        super(x, y, screenWidth, screenHeight);

        String folderPath = "C:\\Users\\RONEL\\Downloads\\ezgif-split\\";
        int numberOfFrames = 31; // 31 פריימים לאנימציית הריצה

        this.runRightFrames = new Image[numberOfFrames];
        this.runLeftFrames = new Image[numberOfFrames];

        // 1. הגדרת תמונת העמידה (Idle) - מופיעה כשהדמות לא זזה
        // בחרנו ב-Frame000 כתמונה הקבועה לעמידה
        Image idleImg = new ImageIcon("C:\\Users\\RONEL\\Downloads\\WaterGirl.png").getImage();
        this.idleRight = idleImg;
        this.idleLeft = createFlippedImage(idleImg); // יצירת גרסה הפוכה לשמאל

        // 2. טעינת כל מערך הריצה (31 פריימים) ויצירת שיקוף אוטומטי
        for (int i = 0; i < numberOfFrames; i++) {
            String fileName = "Frame" + String.format("%03d", i) + ".jpg";
            Image img = new ImageIcon(folderPath + fileName).getImage();

            this.runRightFrames[i] = img;
            this.runLeftFrames[i] = createFlippedImage(img);
        }

        // הגדרת תמונת ההתחלה
        this.currentImage = this.idleRight;
    }

    // מתודה ליצירת תמונת מראה (Flip) לצד שמאל באופן תכנותי
    private Image createFlippedImage(Image source) {
        if (source == null) return null;
        BufferedImage bufferedImage = new BufferedImage(
                source.getWidth(null),
                source.getHeight(null),
                BufferedImage.TYPE_INT_RGB); // JPG לא תומך בשקיפות

        Graphics2D g = bufferedImage.createGraphics();
        g.drawImage(source, source.getWidth(null), 0, -source.getWidth(null), source.getHeight(null), null);
        g.dispose();

        return bufferedImage;
    }
}