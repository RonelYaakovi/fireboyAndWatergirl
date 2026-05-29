package org.example;
import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class Level1 extends BaseLevel {
    private Fireboy fireBoy;
    private Watergirl waterGirl;
    private Controller controller;
    private ArrayList<Block> blocks;
    private ArrayList<Pool> pools;
    private ArrayList<Diamond> diamonds;
    private Portal portal;
    private Color mapColor;
    private boolean isGameOver = false;
    private boolean isVictory = false;
    private JButton tryAgainButton;
    private Image firePoolImg = new ImageIcon("src/images/start screen/fireGif.gif").getImage();
    private Image waterPoolImg = new ImageIcon("src/images/start screen/watergGif.gif").getImage();
    private Image poisonPoolImg = new ImageIcon("src/images/start screen/toxic-peepo-0.jpg").getImage();
    private Image redDiamondImg = new ImageIcon("src/images/start screen/diamond-red.gif").getImage();
    private Image blueDiamondImg = new ImageIcon("src/images/start screen/Diamon-blue.gif").getImage();

    private final int[][] mapMatrix = {
            {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
            {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 6, 6, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1},
            {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 8, 0, 0, 1},
            {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1},
            {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1},
            {1, 0, 0, 0, 0, 0, 1, 2, 2, 2, 2, 1, 1, 1, 1, 1, 1, 1, 1, 3, 3, 3, 3, 1, 1, 1, 1, 1, 1, 1, 1, 1},
            {1, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
            {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 5, 5, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1},
            {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1},
            {1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1},
            {1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1},
            {1, 1, 1, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1},
            {1, 0, 0, 0, 5, 5, 0, 0, 0, 1, 1, 1, 1, 4, 4, 4, 4, 1, 1, 1, 4, 4, 4, 4, 1, 1, 1, 0, 0, 0, 0, 1},
            {1, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 1},
            {1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1},
            {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 6, 6, 0, 0, 1, 0, 0, 1},
            {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1},
            {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1},
            {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1},
            {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1},
            {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1},
            {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1},
            {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2, 2, 2, 2, 1, 1, 1, 1, 1, 3, 3, 3, 3, 1, 1, 1, 1, 1, 1, 1, 1, 1},
            {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1}
    };

    public Level1(Window window) {
        super(window, "src/images/start screen/stone-wall-pavement-from-bricks-rocks-with-moss-game-background-cartoon_191307-991.jpg");
        this.blocks = new ArrayList<>();
        this.pools = new ArrayList<>();
        this.diamonds = new ArrayList<>();
        this.mapColor = new Color(167, 127, 96);
        this.fireBoy = new Fireboy(40, 500, 800, 600);
        this.waterGirl = new Watergirl(80, 500, 800, 600);
        this.controller = new Controller(fireBoy, waterGirl);
        this.addKeyListener(controller);
        this.addFocusListener(controller);
        this.setFocusable(true);
        tryAgainButton = new GameButton("Try Again", 320, 340, 160, 45, new Color(50, 50, 50));
        tryAgainButton.setVisible(false);
        tryAgainButton.addActionListener(e -> restartLevel());
        this.add(tryAgainButton);
        soundManager.playBackgroundMusic("src/images/start screen/Level Music.wav");
    }

    @Override
    protected void buildMap() {
        int tileSize = 25;
        for (int row = 0; row < mapMatrix.length; row++) {
            for (int col = 0; col < mapMatrix[row].length; col++) {
                int x = col * tileSize;
                int y = row * tileSize;
                int cellType = mapMatrix[row][col];
                switch (cellType) {
                    case 1:
                        Block b = new Block(x, y, tileSize, tileSize, mapColor);
                        blocks.add(b);
                        hitboxes.add(b.getBounds());
                        break;
                    case 2:
                        pools.add(new Pool(x, y - 10, firePoolImg, "FIRE"));
                        break;
                    case 3:
                        pools.add(new Pool(x, y - 10, waterPoolImg, "WATER"));
                        break;
                    case 4:
                        pools.add(new Pool(x, y - 10, poisonPoolImg, "POISON"));
                        break;
                    case 5:
                        diamonds.add(new Diamond(x, y, redDiamondImg, "FIRE"));
                        break;
                    case 6:
                        diamonds.add(new Diamond(x, y, blueDiamondImg, "WATER"));
                        break;
                    case 8:
                        if (portal == null) {
                            portal = new Portal(x, y);
                        }
                        break;
                }
            }
        }
    }

    private void restartLevel() {
        for (java.awt.event.KeyListener kl : this.getKeyListeners()) {
            this.removeKeyListener(kl);
        }
        for (java.awt.event.FocusListener fl : this.getFocusListeners()) {
            this.removeFocusListener(fl);
        }
        this.fireBoy = new Fireboy(40, 500, 800, 600);
        this.waterGirl = new Watergirl(80, 500, 800, 600);
        this.controller = new Controller(fireBoy, waterGirl);
        this.addKeyListener(controller);
        this.addFocusListener(controller);
        this.isGameOver = false;
        this.isVictory = false;
        this.isPaused = false;
        tryAgainButton.setVisible(false);
        if (portal != null) {
            portal.reset();
        }
        for (Diamond d : diamonds) {
            d.setCollected(false);
        }
        soundManager.playBackgroundMusic("src/images/start screen/Level Music.wav");
        this.requestFocusInWindow();
    }

    @Override
    protected void updateLevel() {
        if (isGameOver || isVictory) return;
        controller.applyInputs();
        fireBoy.update(hitboxes);
        waterGirl.update(hitboxes);
        Rectangle fireBounds = fireBoy.getBounds();
        Rectangle waterBounds = waterGirl.getBounds();
        for (Pool p : pools) {
            if (fireBounds.intersects(p.getBounds())) {
                if (p.getType().equals("WATER") || p.getType().equals("POISON")) {
                    triggerGameOver();
                }
            }
            if (waterBounds.intersects(p.getBounds())) {
                if (p.getType().equals("FIRE") || p.getType().equals("POISON")) {
                    triggerGameOver();
                }
            }
        }
        for (Diamond d : diamonds) {
            if (!d.isCollected()) {
                if (fireBounds.intersects(d.getBounds()) && d.getType().equals("FIRE")) {
                    d.setCollected(true);
                    fireBoy.addToDiamondCount();
                }
                if (waterBounds.intersects(d.getBounds()) && d.getType().equals("WATER")) {
                    d.setCollected(true);
                    waterGirl.addToDiamondCount();
                }
            }
        }
        if (portal != null) {
            Rectangle portalBounds = portal.getBounds();
            if (fireBoy.isVisible() && fireBounds.intersects(portalBounds)) {
                fireBoy.disappear();
                fireBoy.stopMoving();
                portal.setFireBoyEntered();
            }
            if (waterGirl.isVisible() && waterBounds.intersects(portalBounds)) {
                waterGirl.disappear();
                waterGirl.stopMoving();
                portal.setWaterGirlEntered();
            }
            if (portal.areBothInside()) {
                isVictory = true;
                soundManager.stopMusic();
            }
        }
    }

    private void triggerGameOver() {
        isGameOver = true;
        soundManager.stopMusic();
        fireBoy.died();
        waterGirl.died();
        tryAgainButton.setVisible(true);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        for (Block b : blocks) b.paint(g);
        for (Pool p : pools) p.paint(g);
        for (Diamond d : diamonds) d.paint(g);
        if (portal != null) portal.draw(g);
        if (fireBoy != null) fireBoy.paint(g);
        if (waterGirl != null) waterGirl.paint(g);
        if (isGameOver) {
            g.setColor(new Color(0, 0, 0, 180));
            g.fillRect(0, 0, 800, 600);
            g.setColor(Color.RED);
            g.setFont(new Font("Verdana", Font.BOLD, 50));
            String text = "GAME OVER";
            FontMetrics metrics = g.getFontMetrics(g.getFont());
            int x = (800 - metrics.stringWidth(text)) / 2;
            g.drawString(text, x, 260);
        }
        if (isVictory) {
            g.setColor(new Color(0, 0, 0, 180));
            g.fillRect(0, 0, 800, 600);
            g.setColor(Color.GREEN);
            g.setFont(new Font("Verdana", Font.BOLD, 50));
            String text = "LEVEL COMPLETED!";
            FontMetrics metrics = g.getFontMetrics(g.getFont());
            int x = (800 - metrics.stringWidth(text)) / 2;
            g.drawString(text, x, 260);
        }
    }
}