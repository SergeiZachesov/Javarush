package com.javarush.games.snake;

import com.javarush.engine.cell.*;

import java.util.ArrayList;
import java.util.List;

public class Snake {

    private List<GameObject> snakeParts = new ArrayList<GameObject>();
    private static final String HEAD_SIGN = "\uD83D\uDC7E";
    private static final String BODY_SIGN = "\u26AB";
    public boolean isAlive = true;
    private Direction direction = Direction.LEFT;

    Snake(int x, int y) {
        for (int i = 0; i < 3; i++) {
            snakeParts.add(new GameObject(x + i, y));
        }
    }

    public void draw(Game game) {
        Color color;
        String sing;
        if (this.isAlive) {
            color = Color.BLACK;
        } else {
            color = Color.RED;
        }
        for (int i = 0; i < snakeParts.size(); i++) {
            if (i == 0) {
                sing = HEAD_SIGN;
            } else {
                sing = BODY_SIGN;
            }
            game.setCellValueEx(snakeParts.get(i).x, snakeParts.get(i).y, Color.NONE, sing, color, 75);
        }
    }

    public void setDirection(Direction direction) {
        if ((this.direction == Direction.DOWN || this.direction == Direction.UP) && snakeParts.get(0).y == snakeParts.get(1).y)
            return;
        if (this.direction == Direction.DOWN && direction == Direction.UP) return;
        if (this.direction == Direction.UP && direction == Direction.DOWN) return;
        if ((this.direction == Direction.LEFT || this.direction == Direction.RIGHT) && snakeParts.get(0).x == snakeParts.get(1).x)
            return;
        if (this.direction == Direction.LEFT && direction == Direction.RIGHT) return;
        if (this.direction == Direction.RIGHT && direction == Direction.LEFT) return;
        this.direction = direction;
    }

    public GameObject createNewHead() {

        int i, j;
        switch (direction) {
            case LEFT:
                i = -1;
                break;
            case RIGHT:
                i = 1;
                break;
            default:
                i = 0;
        }

        switch (direction) {
            case DOWN:
                j = 1;
                break;
            case UP:
                j = -1;
                break;
            default:
                j = 0;
        }

        /*JAVA12
        switch (direction) {
            case LEFT -> i=-1;
            case RIGHT -> i=1;
            default -> i=0;
        };
        int j = switch (direction) {
            case DOWN -> j=1;
            case UP -> j=-1;
            default -> j=0;
        };
         */


        return new GameObject(snakeParts.get(0).x + i, snakeParts.get(0).y + j);
    }

    public void removeTail() {
        snakeParts.remove(snakeParts.size() - 1);
    }

    public void move(Apple apple) {
        GameObject head = createNewHead();
        if (head.x < 0 || head.x >= SnakeGame.WIDTH || head.y < 0 || head.y >= SnakeGame.HEIGHT) {
            isAlive = false;
        } else {
            if (!checkCollision(head)) {
                snakeParts.add(0, head);
            } else {
                isAlive = false;
                return;
            }
            if (apple.x == head.x && apple.y == head.y) {
                apple.isAlive = false;
            } else {
                removeTail();
            }
        }
    }

    public boolean checkCollision(GameObject gameObject) {
        boolean collis = false;
        for (GameObject body : snakeParts) {
            if (body.x == gameObject.x && body.y == gameObject.y) {
                collis = true;
                break;
            } else {
                collis = false;
            }
        }
        return collis;
    }

    public int getLength() {
        return snakeParts.size();
    }

}
