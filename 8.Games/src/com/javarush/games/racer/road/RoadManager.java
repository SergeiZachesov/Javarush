package com.javarush.games.racer.road;

import com.javarush.games.racer.PlayerCar;
import com.javarush.games.racer.RacerGame;
import com.javarush.engine.cell.Game;

import java.util.*;


public class RoadManager {
    public static final int LEFT_BORDER = RacerGame.ROADSIDE_WIDTH;
    public static final int RIGHT_BORDER = RacerGame.WIDTH - LEFT_BORDER;
    private static final int FIRST_LANE_POSITION = 16;
    private static final int FOURTH_LANE_POSITION = 44;
    private List<RoadObject> items = new ArrayList();
    private static final int PLAYER_CAR_DISTANCE = 12;
    private int passedCarsCount = 0;

    private RoadObject createRoadObject(RoadObjectType type, int x, int y) {
        if (type == RoadObjectType.THORN) {
            return new Thorn(x, y);
        } else if (type == RoadObjectType.DRUNK_CAR) {
            return new MovingCar(x, y);
        } else {
            return new Car(type, x, y);
        }
    }

    private void addRoadObject(RoadObjectType type, Game game) {
        int x = game.getRandomNumber(FIRST_LANE_POSITION, FOURTH_LANE_POSITION);
        int y = -1 * RoadObject.getHeight(type);
        RoadObject locRoadObject = createRoadObject(type, x, y);
        if (locRoadObject != null && isRoadSpaceFree(locRoadObject))
            items.add(locRoadObject);
    }

    public void draw(Game game) {
        for (RoadObject x : items) {
            x.draw(game);
        }
    }

    public void move(int boost) {
        for (RoadObject x : items) {
            x.move(boost + x.speed, items);
        }
        deletePassedItems();
    }

    private boolean isThornExists() {
        for (RoadObject x : items) {
            if (x.type == RoadObjectType.THORN) {
                return true;
            }
        }
        return false;
    }

    private void generateThorn(Game game) {
        if (game.getRandomNumber(100) < 10 && !isThornExists()) addRoadObject(RoadObjectType.THORN, game);
    }


    public void generateNewRoadObjects(Game game) {
        generateThorn(game);
        generateRegularCar(game);
        generateMovingCar(game);
    }

    private void deletePassedItems() {
        Iterator iterator = items.iterator();
        while (iterator.hasNext()) {
            RoadObject item = (RoadObject) iterator.next();
            if (item.y >= RacerGame.HEIGHT) {
                iterator.remove();
                if (!(item.type == RoadObjectType.THORN)) passedCarsCount++;
            }
        }

    }

    public boolean checkCrush(PlayerCar playerCar) {
        for (RoadObject x : items) {
            if (x.isCollision(playerCar)) {
                return true;
            }
        }
        return false;
    }

    private void generateRegularCar(Game game) {
        int rand = game.getRandomNumber(100);
        int carTypeNumber = game.getRandomNumber(4);
        if (rand < 30) addRoadObject(RoadObjectType.values()[carTypeNumber], game);
    }

    private boolean isRoadSpaceFree(RoadObject object) {
        for (RoadObject x : items) {
            if (x.isCollisionWithDistance(object, PLAYER_CAR_DISTANCE)) {
                return false;
            }
        }
        return true;
    }

    private boolean isMovingCarExists() {
        for (RoadObject x : items) {
            if (x instanceof MovingCar) {
                return true;
            }
        }
        return false;
    }

    private void generateMovingCar(Game game) {
        int rand = game.getRandomNumber(100);
        if (rand < 10 && !isMovingCarExists()) addRoadObject(RoadObjectType.DRUNK_CAR, game);
    }

    public int getPassedCarsCount() {
        return passedCarsCount;
    }

}
