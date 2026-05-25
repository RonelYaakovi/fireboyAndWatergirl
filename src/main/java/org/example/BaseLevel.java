package org.example;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public abstract class BaseLevel extends JPanel implements Runnable {
    protected Window window;
    protected Image backgroundImage;
    protected Thread gameThread;
    protected JButton backButton;
    protected SoundManager soundManager = new SoundManager();

    protected boolean isPaused = false;
    protected JButton pauseButton;

    protected ArrayList<Rectangle> hitboxes;

    public BaseLevel(Window window, String bgImagePath) {
        this.window = window;
        this.setLayout(null);
        this.backgroundImage = new ImageIcon(bgImagePath).getImage();
        this.hitboxes = new ArrayList<>();

        createPauseButton();
        createBackButton();
    }

    private void createPauseButton() {
        pauseButton = new GameButton("Pause", 10, 10, 100, 30, new Color(100, 100, 100));
        pauseButton.setFont(new Font("Arial", Font.BOLD, 14));

        pauseButton.addActionListener(e -> {
            isPaused = !isPaused;
            pauseButton.setText(isPaused ? "Resume" : "Pause");

            if (isPaused) {
                soundManager.pauseMusic();
            } else {
                soundManager.resumeMusic();
                this.requestFocusInWindow();
            }
        });

        this.add(pauseButton);
    }

    private void createBackButton() {
        backButton = new GameButton("Back", 120, 10, 100, 30, new Color(100, 100, 100));
        backButton.setFont(new Font("Arial", Font.BOLD, 14));

        backButton.addActionListener(e -> {
            soundManager.stopMusic();
            window.switchPanel(new LevelSelectionScreen(window));
        });

        this.add(backButton);
    }

    protected abstract void buildMap();

    protected abstract void updateLevel();

    public void startLevel() {
        buildMap();
        gameThread = new Thread(this);
        gameThread.start();
    }

    @Override
    public void run() {
        while (true) {
            if (!isPaused) {
                updateLevel();
            }

            repaint();

            try {
                Thread.sleep(16);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        if (backgroundImage != null) {
            g.drawImage(backgroundImage, 0, 0, window.getWidth(), window.getHeight(), this);
        }

        if (isPaused) {
            g.setColor(new Color(0, 0, 0, 150));
            g.fillRect(0, 0, window.getWidth(), window.getHeight());

            g.setColor(Color.WHITE);
            g.setFont(new Font("Verdana", Font.BOLD, 50));
            g.drawString("PAUSED", 280, 300);
        }

        g.setColor(Color.GREEN);
        for (Rectangle wall : hitboxes) {
            g.drawRect(wall.x, wall.y, wall.width, wall.height);
        }
    }
}