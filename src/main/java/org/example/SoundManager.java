package org.example;

import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;

public class SoundManager {
    private Clip backgroundMusic;

    // הפעלת מנגינת רקע בלולאה (Loop)
    public void playBackgroundMusic(String filePath) {
        try {
            File musicPath = new File(filePath);
            if (musicPath.exists()) {
                AudioInputStream audioInput = AudioSystem.getAudioInputStream(musicPath);
                backgroundMusic = AudioSystem.getClip();
                backgroundMusic.open(audioInput);
                backgroundMusic.loop(Clip.LOOP_CONTINUOUSLY); // ניגון אינסופי
                backgroundMusic.start();
            } else {
                System.out.println("לא נמצא קובץ שמע בנתיב: " + filePath);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // עצירת המנגינה (למקרה של יציאה מהשלב)
    public void stopMusic() {
        if (backgroundMusic != null && backgroundMusic.isRunning()) {
            backgroundMusic.stop();
        }
    }
}