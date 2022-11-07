package com.company;

import com.company.GameView.DisasterView;
import com.company.GameView.GameView;
import com.company.GameView.RedSeaGameView;
import com.company.GameView.TenCommandmentsView;
import com.company.Spirit.DisasterViewSpirit.Bug;
import com.company.Spirit.DisasterViewSpirit.Frog;
import com.company.Spirit.DisasterViewSpirit.Ice;
import com.company.Spirit.DisasterViewSpirit.Tombstone;
import com.company.Spirit.Moses;
import com.company.Spirit.RedSeaViewSpirit.Anubis;
import com.company.Spirit.RedSeaViewSpirit.Cat;
import com.company.Spirit.RedSeaViewSpirit.Pharaoh;
import com.company.Spirit.Spirit;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Main extends JPanel implements KeyListener {

    // 每格移動的大小
    public static final int CELL = 50;

    // 視窗 500 * 500
    public static final int WIDTH = 500;
    public static final int HEIGHT = 500;

    // 計算總共有多少橫行及直行
    public static final int ROW = HEIGHT / CELL;
    public static final int COLUMN = WIDTH / CELL;

    Moses moses;
    public static GameView gameView;

    private int level;

    public Main() {
        level = 1;
        resetGame(new DisasterView());
        addKeyListener(this);
    }

    public void resetGame(GameView game) {
        moses = new Moses(1, 1);
        gameView = game;
        repaint();
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(WIDTH, HEIGHT);
    }

    @Override
    public void paintComponent(Graphics g) {
        gameView.drawView(g);
        moses.draw(g);
        requestFocusInWindow();
    }

    public static void main(String[] args) {
        JFrame window = new JFrame();
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setContentPane(new Main());
        window.pack();
        window.setLocationRelativeTo(null);
        window.setVisible(true);
        window.setResizable(false);
    }

    private boolean changeLevel(String result) {
        if (result.equals("Next level")) {
            level++;
            if (level == 2) {
                resetGame(new RedSeaGameView());
            } else if (level == 3) {
                resetGame(new TenCommandmentsView());
            }
            return true;
        }
        return false;
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        Point mosesPoint = moses.getRelativePosition();
        switch (e.getKeyCode()) {
            case KeyEvent.VK_UP:
                if (mosesPoint.y > 1) {
                    String result = moses.overlap(mosesPoint.x, mosesPoint.y - 1);
                    if (result.equals("Die")) {
                        // reset game
                        level = 1;
                        JOptionPane.showMessageDialog(this, "You die. Please try again.");
                        resetGame(new DisasterView());
                        return;
                    }
                    if (!result.equals("Cannot move")) {
                        mosesPoint.y -= 1;
                    }

                    if (result.equals("Game over")) {
                        JOptionPane.showMessageDialog(this, "You win the game!");
                        return;
                    }

                    if (changeLevel(result)) return;
                }
                break;
            case KeyEvent.VK_DOWN:
                if (mosesPoint.y < ROW) {
                    String result = moses.overlap(mosesPoint.x, mosesPoint.y + 1);
                    if (result.equals("Die")) {
                        // reset game
                        level = 1;
                        JOptionPane.showMessageDialog(this, "You die. Please try again.");
                        resetGame(new DisasterView());
                        return;
                    }
                    if (!result.equals("Cannot move")) {
                        mosesPoint.y += 1;
                    }

                    if (result.equals("Game over")) {
                        JOptionPane.showMessageDialog(this, "You win the game!");
                        return;
                    }
                    if (changeLevel(result)) return;
                }
                break;
            case KeyEvent.VK_LEFT:
                if (mosesPoint.x > 1) {
                    String result = moses.overlap(mosesPoint.x - 1, mosesPoint.y);
                    if (result.equals("Die")) {
                        // reset game
                        level = 1;
                        JOptionPane.showMessageDialog(this, "You die. Please try again.");
                        resetGame(new DisasterView());
                        return;
                    }
                    if (!result.equals("Cannot move")) {
                        mosesPoint.x -= 1;
                    }

                    if (result.equals("Game over")) {
                        JOptionPane.showMessageDialog(this, "You win the game!");
                        return;
                    }
                    if (changeLevel(result)) return;
                }
                break;
            case KeyEvent.VK_RIGHT:
                if (mosesPoint.x < COLUMN) {
                    String result = moses.overlap(mosesPoint.x + 1, mosesPoint.y);
                    if (result.equals("Die")) {
                        // reset game
                        level = 1;
                        JOptionPane.showMessageDialog(this, "You die. Please try again.");
                        resetGame(new DisasterView());
                        return;
                    }
                    if (!result.equals("Cannot move")) {
                        mosesPoint.x += 1;
                    }

                    if (result.equals("Game over")) {
                        JOptionPane.showMessageDialog(this, "You win the game!");
                        return;
                    }
                    if (changeLevel(result)) return;
                }
                break;

            case KeyEvent.VK_W:
                for (int i = mosesPoint.y; i > 0; i--) {
                    for (Spirit s : gameView.getElements()) {
                        if (s.getRelativePosition() != null && s.getRelativePosition().x == mosesPoint.x && s.getRelativePosition().y == i) {
                            if (s instanceof Cat || s instanceof Ice || s instanceof Tombstone) {
                                return;
                            }
                            if (s instanceof Anubis || s instanceof Pharaoh || s instanceof Bug || s instanceof Frog) {
                                s.setNullPosition();
                                repaint();
                                return;
                            }
                        }
                    }
                }
                break;

            case KeyEvent.VK_S:
                for (int i = mosesPoint.y; i <= ROW; i++) {
                    for (Spirit s : gameView.getElements()) {
                        if (s.getRelativePosition() != null && s.getRelativePosition().x == mosesPoint.x && s.getRelativePosition().y == i) {
                            if (s instanceof Cat || s instanceof Ice || s instanceof Tombstone) {
                                return;
                            }
                            if (s instanceof Anubis || s instanceof Pharaoh || s instanceof Bug || s instanceof Frog) {
                                s.setNullPosition();
                                repaint();
                                return;
                            }
                        }
                    }
                }
                break;

            case KeyEvent.VK_D:
                for (int i = mosesPoint.x; i <= COLUMN; i++) {
                    for (Spirit s : gameView.getElements()) {
                        if (s.getRelativePosition() != null && s.getRelativePosition().x == i && s.getRelativePosition().y == mosesPoint.y) {
                            if (s instanceof Cat || s instanceof Ice || s instanceof Tombstone) {
                                return;
                            }
                            if (s instanceof Anubis || s instanceof Pharaoh || s instanceof Bug || s instanceof Frog) {
                                s.setNullPosition();
                                repaint();
                                return;
                            }
                        }
                    }
                }
                break;

            case KeyEvent.VK_A:
                for (int i = mosesPoint.x; i > 0; i--) {
                    for (Spirit s : gameView.getElements()) {
                        if (s.getRelativePosition() != null && s.getRelativePosition().x == i && s.getRelativePosition().y == mosesPoint.y) {
                            if (s instanceof Cat || s instanceof Ice || s instanceof Tombstone) {
                                return;
                            }
                            if (s instanceof Anubis || s instanceof Pharaoh || s instanceof Bug || s instanceof Frog) {
                                s.setNullPosition();
                                repaint();
                                return;
                            }
                        }
                    }
                }
                break;
        }
        moses.setPosition(mosesPoint);
        // repaint整個 JPanel ， 所以遊戲畫面會自動更新
        repaint();
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}