package com.javarush.games.spaceinvaders.gameobjects;

import com.javarush.games.spaceinvaders.*;

import java.util.List;

public class PlayerShip extends Ship {

    private Direction direction = Direction.UP;


    public PlayerShip() {
        super(SpaceInvadersGame.WIDTH / 2.0, SpaceInvadersGame.HEIGHT - ShapeMatrix.PLAYER.length - 1);
        setStaticView(ShapeMatrix.PLAYER);
    }

    public void verifyHit(List<Bullet> bullets) {
        if (bullets.size() != 0) {
            for (Bullet x : bullets) {
                if (x.isAlive && isAlive) {
                    if (isCollision(x)) {
                        kill();
                        x.kill();
                    }
                }
            }
        }
    }

    @Override
    public void kill() {
        if (!this.isAlive) return;
        isAlive = false;
        setAnimatedView(false, ShapeMatrix.KILL_PLAYER_ANIMATION_FIRST, ShapeMatrix.KILL_PLAYER_ANIMATION_SECOND, ShapeMatrix.KILL_PLAYER_ANIMATION_THIRD, ShapeMatrix.DEAD_PLAYER);
    }

    public void setDirection(Direction newDirection) {
        if (newDirection != Direction.DOWN) {
            this.direction = newDirection;
        }
    }

    public void move() {
        if (isAlive) {
            if (this.direction == Direction.LEFT) {
                this.x--;
            } else if (this.direction == Direction.RIGHT) {
                this.x++;
            }
            if (this.x < 0) {
                this.x = 0;
            }
            if (x + width > SpaceInvadersGame.WIDTH) {
                this.x = SpaceInvadersGame.WIDTH - width;
            }
        }
    }

    public Direction getDirection() {
        return direction;
    }

    @Override
    public Bullet fire() {
        if (!this.isAlive) {
            return null;
        } else {
            return new Bullet(x + 2, y - ShapeMatrix.BULLET.length, Direction.UP);
        }
    }

    public void win() {
        setStaticView(ShapeMatrix.WIN_PLAYER);
    }

}
