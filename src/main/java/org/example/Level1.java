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
    private Door fireDoor;
    private Door waterDoor;
    private Color mapColor;

    private boolean isGameOver = false;
    private JButton tryAgainButton;

    private Image firePoolImg = new ImageIcon("C:\\Users\\RONEL\\Downloads\\fireGif.gif").getImage();
    private Image waterPoolImg = new ImageIcon("C:\\Users\\RONEL\\Downloads\\watergGif.gif").getImage();
    private Image poisonPoolImg = new ImageIcon("C:\\Users\\RONEL\\Downloads\\toxic-peepo-0.jpg").getImage();
    private Image redDiamondImg = new ImageIcon("C:\\Users\\RONEL\\Downloads\\diamond-red.gif").getImage();
    private Image blueDiamondImg = new ImageIcon("C:\\Users\\RONEL\\Downloads\\Diamon-blue.gif").getImage();
    private Image doorClosedImg = new ImageIcon("C:\\Users\\RONEL\\...\\door_closed.png").getImage();
    private Image doorOpenImg = new ImageIcon("C:\\Users\\RONEL\\...\\door_open.png").getImage();

    private final int[][] mapMatrix = {
            {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
            {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 6, 6, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1},
            {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 7, 7, 0, 7, 7, 0, 1},
            {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 7, 7, 0, 7, 7, 0, 1},
            {1, 0, 0, 0, 0, 1, 1, 2, 2, 2, 2, 1, 1, 1, 1, 1, 1, 1, 1, 3, 3, 3, 3, 3, 1, 1, 1, 1, 1, 1, 1, 1},
            {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1},
            {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1},
            {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 5, 5, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1},
            {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1},
            {1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1},
            {1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1},
            {1, 1, 1, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1},
            {1, 0, 0, 0, 5, 5, 0, 0, 0, 1, 1, 1, 4, 4, 4, 4, 4, 1, 1, 1, 4, 4, 4, 4, 4, 1, 1, 1, 1, 0, 0, 1},
            {1, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 1},
            {1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1},
            {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 6, 6, 0, 0, 1, 0, 0, 1},
            {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1},
            {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1},
            {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1},
            {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1},
            {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1},
            {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1},
            {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 1, 1, 1, 1, 3, 3, 3, 3, 3, 1, 1, 1, 1, 1, 1, 1, 1},
            {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1}
    };

    public Level1(Window window) {
        super(window, "C:\\Users\\RONEL\\Downloads\\stone-wall-pavement-from-bricks-rocks-with-moss-game-background-cartoon_191307-991.jpg");
        this.blocks = new ArrayList<>();
        this.pools = new ArrayList<>();
        this.diamonds = new ArrayList<>();

        this.mapColor = new Color(167, 127, 96);

        this.fireBoy = new Fireboy(40, 500, 800, 600);
        this.waterGirl = new Watergirl(80, 500, 800, 600);

        this.controller = new Controller(fireBoy, waterGirl);
        this.addKeyListener(controller);
        this.setFocusable(true);

        tryAgainButton = new GameButton("Try Again", 320, 340, 160, 45, new Color(50, 50, 50));
        tryAgainButton.setVisible(false);
        tryAgainButton.addActionListener(e -> restartLevel());
        this.add(tryAgainButton);
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
                    case 1: // קיר
                        Block b = new Block(x, y, tileSize, tileSize, mapColor);
                        blocks.add(b);
                        hitboxes.add(b.getBounds());
                        break;
                    case 2: //בריכת אש
                        pools.add(new Pool(x, y - 10, firePoolImg, "FIRE"));
                        break;
                    case 3: //בריכת מים
                        pools.add(new Pool(x, y - 10, waterPoolImg, "WATER"));
                        break;
                    case 4: //בריכת רעל
                        pools.add(new Pool(x, y - 10, poisonPoolImg, "POISON"));
                        break;
                    case 5://יהלום אדום
                        diamonds.add(new Diamond(x, y, redDiamondImg, "FIRE"));
                        break;
                    case 6: //יהלום כחול
                        diamonds.add(new Diamond(x, y, blueDiamondImg, "WATER"));
                        break;
                    case 7: // דלתות יציאה
                        if (fireDoor == null) {
                            fireDoor = new Door(x - 50, y, "red");
                            waterDoor = new Door(x, y, "blue");
                        }
                        break;
                }
            }
        }
    }

    private void restartLevel() {
        isGameOver = false;
        tryAgainButton.setVisible(false);
        this.isPaused = false;
        this.isGameOver = false;
        tryAgainButton.setVisible(false);
        this.fireBoy = new Fireboy(40, 500, 800, 600);
        this.waterGirl = new Watergirl(80, 500, 800, 600);
        this.controller = new Controller(fireBoy, waterGirl);

        for (Diamond d : diamonds) {
            d.setCollected(false);
        }

        this.requestFocusInWindow();
    }

    @Override
    protected void updateLevel() {
        if (isGameOver) return;

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

        if (fireDoor != null && waterDoor != null) {
            if (fireBounds.intersects(fireDoor.getBounds())) {
                fireDoor.open();
                fireBoy.onTheDoor();
            } else {
                fireDoor.close();
                fireBoy.notONTheDoor();
            }

            if (waterBounds.intersects(waterDoor.getBounds())) {
                waterDoor.open();
                waterGirl.onTheDoor();
            } else {
                waterDoor.close();
                waterGirl.notONTheDoor();
            }

            if (fireBoy.isOnTheDoor() && waterGirl.isOnTheDoor()) {
                System.out.println("Victory! Level Completed!");
            }
        }
    }

    private void triggerGameOver() {
        isGameOver = true;
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

        if (fireDoor != null) fireDoor.paint(g);
        if (waterDoor != null) waterDoor.paint(g);

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
    }
}