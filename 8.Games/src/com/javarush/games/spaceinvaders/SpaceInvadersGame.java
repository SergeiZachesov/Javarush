package com.javarush.games.spaceinvaders;

import com.javarush.engine.cell.*;
import com.javarush.games.spaceinvaders.gameobjects.*;

import java.util.*;

public class SpaceInvadersGame extends Game {

    public static final int WIDTH = 64;
    public static final int HEIGHT = 64;
    private List<Star> stars;
    private EnemyFleet enemyFleet;
    public static final int COMPLEXITY = 5;
    private List<Bullet> enemyBullets;
    private PlayerShip playerShip;
    private boolean isGameStopped;
    private int animationsCount;
    private List<Bullet> playerBullets;
    private static final int PLAYER_BULLETS_MAX = 1;
    private int score;

    @Override
    public void initialize() {
        setScreenSize(WIDTH, HEIGHT);
        createGame();
    }

    private void createGame() {
        setTurnTimer(40);
        createStars();
        enemyFleet = new EnemyFleet();
        enemyBullets = new ArrayList<Bullet>();
        playerShip = new PlayerShip();
        isGameStopped = false;
        animationsCount = 0;
        playerBullets = new ArrayList<Bullet>();
        score = 0;
        drawScene();

    }

    @Override
    public void onTurn(int step) {
        moveSpaceObjects();
        check();
        Bullet bul = enemyFleet.fire(this);
        if (bul != null) {
            enemyBullets.add(bul);
        }
        setScore(score);
        drawScene();
    }

    private void drawScene() {
        drawField();
        enemyFleet.draw(this);
        for (Bullet x : enemyBullets) {
            x.draw(this);
        }
        playerShip.draw(this);
        for (Bullet x : playerBullets) {
            x.draw(this);
        }
    }

    private void drawField() {
        for (int x = 0; x < HEIGHT; x++) {
            for (int y = 0; y < WIDTH; y++) {
                setCellValueEx(x, y, Color.BLACK, "");
            }
        }
        for (Star s : stars) {
            s.draw(this);
        }
    }

    private void createStars() {
        stars = new ArrayList<Star>();
        stars.add(new Star(4, 7));
        stars.add(new Star(23, 43));
        stars.add(new Star(43, 5));
        stars.add(new Star(45, 54));
        stars.add(new Star(32, 43));
        stars.add(new Star(54, 23));
        stars.add(new Star(61, 43));
        stars.add(new Star(13, 53));
    }

    private void moveSpaceObjects() {
        enemyFleet.move();
        for (Bullet x : enemyBullets) {
            x.move();
        }
        playerShip.move();
        for (Bullet x : playerBullets) {
            x.move();
        }
    }

    private void removeDeadBullets() {
        Iterator iterator = enemyBullets.iterator();
        while (iterator.hasNext()) {
            Bullet enemyBullets = (Bullet) iterator.next();
            if (enemyBullets.y >= HEIGHT - 1 || !enemyBullets.isAlive) {
                iterator.remove();
            }
        }
        Iterator iterator2 = playerBullets.iterator();
        while (iterator2.hasNext()) {
            Bullet playerBullets = (Bullet) iterator2.next();
            if (!playerBullets.isAlive || playerBullets.y + playerBullets.height < 0) {
                iterator2.remove();
            }
        }
    }

    private void check() {
        if (!playerShip.isAlive) stopGameWithDelay();
        playerShip.verifyHit(enemyBullets);
        enemyFleet.deleteHiddenShips();
        if (enemyFleet.getBottomBorder() >= playerShip.y) playerShip.kill();
        if (enemyFleet.getShipsCount() == 0) playerShip.win();
        score += enemyFleet.verifyHit(playerBullets);
        removeDeadBullets();
    }

    private void stopGame(boolean isWin) {
        isGameStopped = true;
        stopTurnTimer();
        if (isWin) {
            showMessageDialog(Color.TRANSPARENT, "WIN", Color.GREEN, 50);
        } else {
            showMessageDialog(Color.TRANSPARENT, "GAME OVER", Color.RED, 50);
        }
    }

    private void stopGameWithDelay() {
        animationsCount++;
        if (animationsCount >= 10) {
            stopGame(playerShip.isAlive);
        }
    }

    @Override
    public void onKeyReleased(Key key) {
        if (key == Key.RIGHT && playerShip.getDirection() == Direction.RIGHT) playerShip.setDirection(Direction.UP);
        if (key == Key.LEFT && playerShip.getDirection() == Direction.LEFT) playerShip.setDirection(Direction.UP);
    }

    @Override
    public void onKeyPress(Key key) {
        if (key == Key.SPACE && isGameStopped) {
            isGameStopped = false;
            createGame();
            return;
        }
        switch (key) {
            case LEFT:
                playerShip.setDirection(Direction.LEFT);
                break;
            case RIGHT:
                playerShip.setDirection(Direction.RIGHT);
                break;
            case SPACE:
                Bullet bul = playerShip.fire();
                if (bul != null && playerBullets.size() < PLAYER_BULLETS_MAX) {
                    playerBullets.add(bul);
                }
                break;
        }
    }

    @Override
    public void setCellValueEx(int x, int y, Color cellColor, String value) {
        if (x >= 0 && x < HEIGHT && y >= 0 && y < WIDTH) {
            super.setCellValueEx(x, y, cellColor, value);
        }
    }
}
