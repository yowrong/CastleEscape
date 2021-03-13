package rooms;

import theitems.Item;

import java.util.ArrayList;


public class Room3 extends Room{

    private String[][] map3;

    public Room3(int[][] exitCoordinates, ArrayList<Item> items, String[][] map) {
        super(exitCoordinates, items, map);
        this.map3 = map;
    }

    @Override
    protected void createLayout() {
        for (int index = 1; index < 6; index++) {
            for (int innerIndex = 1; innerIndex < 6; innerIndex++) {
                this.map3[index][innerIndex] = " ";
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
//        Room testRoom = new Room(testExitCoord, testItemsInRoom, testMap);
//        testRoom.deleteLayout();
//        testRoom.createLayout();
//        testRoom.displayLayout();

        Room3 testroom3 = new Room3(testExitCoord, testItemsInRoom, testMap);
        testroom3.deleteLayout();
        testroom3.createLayout();
        testroom3.displayLayout();

    }

}
