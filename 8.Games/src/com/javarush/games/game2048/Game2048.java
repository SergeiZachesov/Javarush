package com.javarush.games.game2048;

import com.javarush.engine.cell.*;

public class Game2048 extends Game {

    private static final int SIDE = 4;
    private int[][] gameField = new int[SIDE][SIDE];
    private boolean isGameStopped = false;
    private int score;

    @Override
    public void initialize() {
        setScreenSize(SIDE, SIDE);
        createGame();
        drawScene();
    }

    private void createGame() {
        gameField = new int[SIDE][SIDE];
        score = 0;
        setScore(score);
        createNewNumber();
        createNewNumber();
    }

    private void drawScene() {
        for (int x = 0; x < SIDE; x++) {
            for (int y = 0; y < SIDE; y++) {
                setCellColoredNumber(x, y, gameField[y][x]);
            }
        }
    }

    private void createNewNumber() {
        if (getMaxTileValue() == 2048) {
            win();
        }
        int x, y;
        do {
            x = getRandomNumber(SIDE);
            y = getRandomNumber(SIDE);
        } while (gameField[x][y] != 0);

        if (getRandomNumber(10) == 9) {
            gameField[x][y] = 4;
        } else {
            gameField[x][y] = 2;
        }
    }

    private Color getColorByValue(int value) {
        switch (value) {
            case 0:
                return Color.KHAKI;
            case 2:
                return Color.WHEAT;
            case 4:
                return Color.CORAL;
            case 8:
                return Color.LIGHTSALMON;
            case 16:
                return Color.LIGHTCORAL;
            case 32:
                return Color.ORANGERED;
            case 64:
                return Color.RED;
            case 128:
                return Color.BEIGE;
            case 256:
                return Color.LEMONCHIFFON;
            case 512:
                return Color.LIGHTYELLOW;
            case 1024:
                return Color.GOLD;
            case 2048:
                return Color.YELLOW;
            default:
                return Color.KHAKI;
        }
    }


    private void setCellColoredNumber(int x, int y, int value) {
        String valueStr = "";
        Color color = getColorByValue(value);
        if (value != 0) {
            valueStr = String.valueOf(value);
        } else {
            valueStr = "";
        }
        setCellValueEx(x, y, color, valueStr);
    }

    private boolean compressRow(int[] row) {
        boolean res = false;
        for (int i = 0; i < row.length - 1; i++) {
            if (row[i] == 0 && row[i] < row[i + 1]) {
                row[i] = row[i + 1];
                row[i + 1] = 0;
                res = true;
                i = -1;
            }
        }
        return res;
    }

    private boolean mergeRow(int[] row) {
        boolean res = false;
        for (int i = 0; i < row.length - 1; i++) {
            if (row[i] != 0 && row[i] == row[i + 1]) {
                row[i] += row[i + 1];
                score += row[i];
                setScore(score);
                row[i + 1] = 0;
                res = true;

            }
        }
        return res;
    }

    @Override
    public void onKeyPress(Key key) {
        if (key == Key.SPACE) {
            isGameStopped = false;
            createGame();
            drawScene();
            return;
        }
        if (!isGameStopped) {
            if (!canUserMove()) {
                gameOver();
                return;
            }
            switch (key) {
                case LEFT:
                    moveLeft();
                    drawScene();
                    break;
                case RIGHT:
                    moveRight();
                    drawScene();
                    break;
                case UP:
                    moveUp();
                    drawScene();
                    break;
                case DOWN:
                    moveDown();
                    drawScene();
                    break;
            }
        }
    }

    private void moveLeft() {
        boolean newNunb = false;
        for (int y = 0; y < SIDE; y++) {
            if (compressRow(gameField[y])) newNunb = true;
        }
        for (int y = 0; y < SIDE; y++) {
            if (mergeRow(gameField[y])) newNunb = true;
        }
        for (int y = 0; y < SIDE; y++) {
            if (compressRow(gameField[y])) newNunb = true;
        }
        if (newNunb) createNewNumber();
    }

    private void moveRight() {
        rotateClockwise();
        rotateClockwise();
        moveLeft();
        rotateClockwise();
        rotateClockwise();
    }

    private void moveUp() {
        rotateClockwise();
        rotateClockwise();
        rotateClockwise();
        moveLeft();
        rotateClockwise();
    }

    private void moveDown() {
        rotateClockwise();
        moveLeft();
        rotateClockwise();
        rotateClockwise();
        rotateClockwise();
    }

    private void rotateClockwise() {
        for (int k = 0; k < gameField.length / 2; k++) {
            for (int j = k; j < gameField.length - 1 - k; j++) // left -> right
            {
                int tmp = gameField[k][j];
                gameField[k][j] = gameField[gameField.length - 1 - j][k];
                gameField[gameField.length - 1 - j][k] = gameField[gameField.length - 1 - k][gameField.length - 1 - j];
                gameField[gameField.length - 1 - k][gameField.length - 1 - j] = gameField[j][gameField.length - 1 - k];
                gameField[j][gameField.length - 1 - k] = tmp;
            }
        }
    }

    private int getMaxTileValue() {
        int vaulMax = 0;
        for (int[] i : gameField) {
            for (int j : i) {
                if (j > vaulMax) vaulMax = j;
            }
        }
        return vaulMax;
    }

    private void win() {
        isGameStopped = true;
        showMessageDialog(Color.TRANSPARENT, "Win", Color.GREEN, 50);
    }

    private void gameOver() {
        isGameStopped = true;
        showMessageDialog(Color.TRANSPARENT, "GAME OVER", Color.RED, 50);
    }

    private boolean canUserMove() {
        boolean move = false;
        for (int i = 0; i < gameField.length; i++) {
            for (int j = 0; j < gameField[i].length; j++) {
                if (gameField[i][j] == 0) {
                    move = true;
                } else {
                    for (int m = j - 1; m <= j + 1; m++) {
                        if (m == j) continue;
                        if (m < 0 || m >= gameField[i].length) {
                            continue;
                        }
                        if (gameField[i][j] == gameField[i][m]) {
                            move = true;
                        }
                    }
                    for (int m = i - 1; m <= i + 1; m++) {
                        if (m == i) continue;
                        if (m < 0 || m >= gameField.length) {
                            continue;
                        }
                        if (gameField[i][j] == gameField[m][j]) {
                            move = true;
                        }
                    }
                }
            }
        }
        return move;
    }

}
