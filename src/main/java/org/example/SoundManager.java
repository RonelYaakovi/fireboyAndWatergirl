package org.example;

import javax.sound.sampled.*;
import java.io.File;

public class SoundManager {
    private Clip backgroundMusic;

    public void playBackgroundMusic(String filePath) {
        try {
            if (backgroundMusic != null && backgroundMusic.isRunning()) {
                return;
            }

            if (backgroundMusic != null && backgroundMusic.isOpen()) {
                backgroundMusic.stop();
                backgroundMusic.close();
            }

            File musicPath = new File(filePath);
            if (musicPath.exists()) {
                AudioInputStream audioInput = AudioSystem.getAudioInputStream(musicPath);
                backgroundMusic = AudioSystem.getClip();
                backgroundMusic.open(audioInput);
                backgroundMusic.loop(Clip.LOOP_CONTINUOUSLY);
                backgroundMusic.start();
            } else {
                System.out.println("Audio file not found: " + filePath);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void stopMusic() {
        if (backgroundMusic != null && backgroundMusic.isRunning()) {
            backgroundMusic.stop();
            backgroundMusic.close();
        }
    }
    public void pauseMusic() {
        if (backgroundMusic != null && backgroundMusic.isRunning()) {
            backgroundMusic.stop();
        }
    }

    public void resumeMusic() {
        if (backgroundMusic != null && backgroundMusic.isOpen()) {
            backgroundMusic.start();
        }
    }
}