package rooms;

import theitems.Item;
import theobstacles.Obstacle;
import theplayer.Player;

import java.util.ArrayList;

public class Room2 extends Room {

    private String[][] map2;
    private Obstacle obstacleInRoom;
    private int[] pressPlate = {4 ,4};

    public Room2(int[][] exitCoordinates, ArrayList<Item> items, String[][] map, Obstacle obstacleInRoom) {
        super(exitCoordinates, items, map);
        this.map2 = map;
        this.obstacleInRoom = obstacleInRoom;
    }

    @Override
    protected void createLayout() {
        for (int index = 1; index < 6; index++) {
            for (int innerIndex = 1; innerIndex < 6; innerIndex++) {
                if (index > 3 || innerIndex > 3) {
                    this.map2[index][innerIndex] = " ";
                }
            }
        }
    }

    private void populateRoom() {
        for (Item item : this.getItemsInRoom()) {
            this.map2[item.getItemCoordinate()[0]][item.getItemCoordinate()[1]] = "i";
        }
        this.map2[getExitCoordinate()[0][0]][getExitCoordinate()[0][1]] = "D";
        this.map2[getExitCoordinate()[0][0]][(getExitCoordinate()[0][1]-1)] = "P";
        this.map2[obstacleInRoom.getObstacleCoordinate()[0]][obstacleInRoom.getObstacleCoordinate()[1]] = "O";
        this.map2[pressPlate[0]][pressPlate[1]] = "*";
    }

//    public void onPressPlate() {
//        if ()
//    }



    public static void main(final String[] args) {
        int[][] testExitCoord = {{4, 6}};
        int[] testItemCoord = {5, 1};
        String testItemName = "A rock";
        String testItemDesc = "I am error.";
        int[] testObsCoord = {1, 4};


        Obstacle testObstacle = new Obstacle("crate", "I'm a crate", testObsCoord);

        Item testItem = new Item(testItemCoord, testItemName, testItemDesc);
        ArrayList<Item> testItemsInRoom = new ArrayList<Item>();
        testItemsInRoom.add(testItem);
        String[][] testMap = new String[7][7];
        for (int index = 0; index < 7; index++) {
            for (int innerIndex = 0; innerIndex < 7; innerIndex++) {
                testMap[index][innerIndex] = "U";
            }
        }
        Room2 testRoom = new Room2(testExitCoord, testItemsInRoom, testMap, testObstacle);
        testRoom.deleteLayout();
        testRoom.createLayout();
        testRoom.populateRoom();
        testRoom.displayLayout();

    }


}
