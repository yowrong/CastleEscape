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
            for (int innerIndex = 2; innerIndex < 5; innerIndex++) {
                this.map2[index][innerIndex] = " ";
            }
        }
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
