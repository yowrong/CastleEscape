package rooms;

import theitems.Item;

import java.util.ArrayList;

public class Room2 extends Room {

    private String[][] map2;

    public Room2(int[][] exitCoordinates, ArrayList<Item> items, String[][] map) {
        super(exitCoordinates, items, map);
        this.map2 = map;

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
            item.getItemCoordinate();
            this.map2[item.getItemCoordinate()[0]][item.getItemCoordinate()[1]] = "i";
        }
        this.map2[getExitCoordinate()[0][0]][getExitCoordinate()[0][1]] = "D";
        this.map2[(getExitCoordinate()[0][0]-1)][(getExitCoordinate()[0][1]-1)] = "P";
    }


    public static void main(final String[] args) {
        int[][] testExitCoord = {{0, 0}};
        int[] testItemCoord = {1, 2};
        String testItemName = "A rock";
        String testItemDesc = "I am error.";

        Item testItem = new Item(testItemCoord, testItemName, testItemDesc);
        ArrayList<Item> testItemsInRoom = new ArrayList<Item>();
        testItemsInRoom.add(testItem);
        String[][] testMap = new String[7][7];
        for (int index = 0; index < 7; index++) {
            for (int innerIndex = 0; innerIndex < 7; innerIndex++) {
                testMap[index][innerIndex] = "U";
            }
        }
        Room2 testRoom = new Room2(testExitCoord, testItemsInRoom, testMap);
        testRoom.deleteLayout();
        testRoom.createLayout();
        testRoom.displayLayout();

    }


}
