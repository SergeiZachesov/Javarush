package com.javarush.games.spaceinvaders.gameobjects;


import com.javarush.engine.cell.Game;
import com.javarush.games.spaceinvaders.Direction;
import com.javarush.games.spaceinvaders.ShapeMatrix;
import com.javarush.games.spaceinvaders.SpaceInvadersGame;

import java.util.*;

public class EnemyFleet {

    private static final int ROWS_COUNT = 3;
    private static final int COLUMNS_COUNT = 10;
    private static final int STEP = ShapeMatrix.ENEMY.length + 1;
    private List<EnemyShip> ships;
    private Direction direction = Direction.RIGHT;

    public EnemyFleet() {
        createShips();
    }

    private void createShips() {
        ships = new ArrayList<EnemyShip>();
        for (int i = 0; i < ROWS_COUNT; i++) {
            for (int j = 0; j < COLUMNS_COUNT; j++) {
                ships.add(new EnemyShip(j * STEP, i * STEP + 12));
            }
        }
        ships.add(new Boss(STEP * COLUMNS_COUNT / 2 - ShapeMatrix.BOSS_ANIMATION_FIRST.length / 2 - 1, 5));
    }

    public void draw(Game game) {
        for (EnemyShip x : ships) {
            x.draw(game);
        }
    }

    private double getLeftBorder() {
        double xMin = ships.get(0).x;
        for (EnemyShip x : ships) {
            if (xMin > x.x) xMin = x.x;
        }
        return xMin;
    }

    private double getRightBorder() {
        double xMax = ships.get(0).x + ships.get(0).width;
        for (EnemyShip x : ships) {
            if (xMax < x.x + x.width) xMax = x.x + x.width;
        }
        return xMax;
    }

    private double getSpeed() {
        return Double.min(2.0, 3.0 / ships.size());
    }

    public void move() {
        if (ships.size() == 0) return;
        double speed = getSpeed();
        if (direction == Direction.LEFT && getLeftBorder() < 0) {
            direction = Direction.RIGHT;
            for (EnemyShip x : ships) {
                x.move(Direction.DOWN, speed);
            }
        } else if (direction == Direction.RIGHT && getRightBorder() > SpaceInvadersGame.WIDTH) {
            direction = Direction.LEFT;
            for (EnemyShip x : ships) {
                x.move(Direction.DOWN, speed);
            }
        } else {
            for (EnemyShip x : ships) {
                x.move(direction, speed);
            }
        }
    }

    public Bullet fire(Game game) {
        if (ships.size() == 0) return null;
        int perc = game.getRandomNumber(100 / SpaceInvadersGame.COMPLEXITY);
        if (perc > 0) return null;
        int percShip = game.getRandomNumber(ships.size());
        return ships.get(percShip).fire();
    }

    /*
        public void verifyHit(List<Bullet> bullets) {
            for (EnemyShip x : ships) {
                for (Bullet y : bullets) {
                    boolean coll = x.isCollision(y);
                    if (coll && y.isAlive && x.isAlive) {
                        x.kill();
                        y.kill();
                    }
                }
            }
        }
    */
    public void deleteHiddenShips() {
        Iterator iterator = ships.iterator();
        while (iterator.hasNext()) {
            EnemyShip ship = (EnemyShip) iterator.next();
            if (!ship.isVisible()) {
                iterator.remove();
            }
        }
    }

    public double getBottomBorder() {
        double shipsH = 0;
        try {
            if (ships != null && !ships.isEmpty()) {
                shipsH = ships.get(0).y + ships.get(0).height;
                for (EnemyShip ship : ships) {
                    if (shipsH < ship.y + ship.height) {
                        shipsH = ship.y + ship.height;
                    }
                }
                return shipsH;
            } else {
                throw new NoSuchElementException();
            }
        } catch (NoSuchElementException e) {
            return shipsH;
        }
    }

    public int getShipsCount() {
        return ships.size();
    }

    public int verifyHit(List<Bullet> bullets) {
        int score = 0;
        if (!bullets.isEmpty()) {
            for (EnemyShip x : ships) {
                for (Bullet y : bullets) {
                    boolean coll = x.isCollision(y);
                    if (coll && y.isAlive && x.isAlive) {
                        x.kill();
                        y.kill();
                        score += x.score;
                    }
                }
            }
        }
        return score;
    }

}
