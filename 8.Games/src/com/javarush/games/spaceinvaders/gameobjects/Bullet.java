package com.javarush.games.spaceinvaders.gameobjects;

import com.javarush.games.spaceinvaders.*;

public class Bullet extends GameObject {

    private int dy;
    public boolean isAlive = true;

    public Bullet(double x, double y, Direction direction) {
        super(x, y);
        super.setMatrix(ShapeMatrix.BULLET);
        if (direction == Direction.UP) dy = -1;
        if (direction != Direction.UP) dy = 1;
    }

    public void move() {
        y += dy;
    }

    public void kill() {
        isAlive = false;
    }


}
