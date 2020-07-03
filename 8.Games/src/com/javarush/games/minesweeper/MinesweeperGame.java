package com.javarush.games.minesweeper;

import com.javarush.engine.cell.Color;
import com.javarush.engine.cell.Game;

import java.util.ArrayList;
import java.util.List;

public class MinesweeperGame extends Game {
    private static final int SIDE = 9;
    private GameObject[][] gameField = new GameObject[SIDE][SIDE];
    private int countMinesOnField;
    private static final String MINE = "\uD83D\uDCA3";
    private static final String FLAG = "\uD83D\uDEA9";
    private int countFlags;
    private boolean isGameStopped;
    private int countClosedTiles = SIDE * SIDE;
    private int score;

    @Override
    public void initialize() {
        setScreenSize(SIDE, SIDE);
        createGame();
    }

    private void createGame() {
        for (int y = 0; y < SIDE; y++) {
            for (int x = 0; x < SIDE; x++) {
                boolean isMine = getRandomNumber(10) < 1;
                if (isMine) {
                    countMinesOnField++;
                }
                gameField[y][x] = new GameObject(x, y, isMine);
                setCellColor(x, y, Color.ORANGE);
                setCellValue(x, y, "");
            }
        }
        countFlags = countMinesOnField;
        countMineNeighbors();
    }

    private List<GameObject> getNeighbors(GameObject gameObject) {
        List<GameObject> result = new ArrayList<>();
        for (int y = gameObject.y - 1; y <= gameObject.y + 1; y++) {
            for (int x = gameObject.x - 1; x <= gameObject.x + 1; x++) {
                if (y < 0 || y >= SIDE) {
                    continue;
                }
                if (x < 0 || x >= SIDE) {
                    continue;
                }
                if (gameField[y][x] == gameObject) {
                    continue;
                }
                result.add(gameField[y][x]);
            }
        }
        return result;
    }

    private void countMineNeighbors() {
        for (int y = 0; y < SIDE; y++) {
            for (int x = 0; x < SIDE; x++) {
                if (gameField[y][x].isMine == true) {
                    continue;
                }
                for (GameObject noMine : getNeighbors(gameField[y][x])) {
                    if (noMine.isMine == true) {
                        gameField[y][x].countMineNeighbors++;
                    }
                }
            }
        }
    }

    private void openTile(int x, int y) {
        if (isGameStopped == false && gameField[y][x].isOpen == false && gameField[y][x].isFlag == false) {
            if (gameField[y][x].isMine == true) {
                gameField[y][x].isOpen = true;
                setCellValueEx(x, y, Color.RED, MINE);
                gameOver();
            } else if (gameField[y][x].countMineNeighbors == 0) {
                setCellValue(x, y, "");
                gameField[y][x].isOpen = true;
                countClosedTiles--;
                setCellColor(x, y, Color.GREEN);
                score += 5;
                setScore(score);
                for (GameObject noMine : getNeighbors(gameField[y][x])) {
                    if (!noMine.isOpen) {
                        openTile(noMine.x, noMine.y);
                    }
                }
            } else {
                setCellNumber(x, y, gameField[y][x].countMineNeighbors);
                gameField[y][x].isOpen = true;
                countClosedTiles--;
                setCellColor(x, y, Color.GREEN);
                score += 5;
                setScore(score);
            }
            if (countClosedTiles == countMinesOnField) {
                win();
            }
        }
    }

    private void markTile(int x, int y) {
        if (!gameField[y][x].isOpen && countFlags > 0 && !gameField[y][x].isFlag) {
            gameField[y][x].isFlag = true;
            countFlags--;
            setCellValue(x, y, FLAG);
            setCellColor(x, y, Color.YELLOW);
        } else if (gameField[y][x].isFlag) {
            gameField[y][x].isFlag = false;
            countFlags++;
            setCellValue(x, y, "");
            setCellColor(x, y, Color.ORANGE);
        }

    }

    private void gameOver() {
        isGameStopped = true;
        showMessageDialog(Color.TRANSPARENT, "Game Over", Color.RED, 50);
    }

    private void win() {
        isGameStopped = true;
        showMessageDialog(Color.TRANSPARENT, "Win", Color.GREEN, 50);
    }

    private void restart() {
        isGameStopped = false;
        countClosedTiles = SIDE * SIDE;
        score = 0;
        countMinesOnField = 0;
        setScore(score);
        createGame();
    }

    public void onMouseLeftClick(int x, int y) {
        if (isGameStopped == false) {
            openTile(x, y);
        } else {
            restart();
        }
    }

    public void onMouseRightClick(int x, int y) {
        markTile(x, y);
    }

}