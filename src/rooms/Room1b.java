package rooms;

import theitems.Item;

import java.util.ArrayList;

public class Room1b extends Room {

    private String roomName;
    private String[][] map1b;

    public Room1b(int[][] exitCoordinates, ArrayList<Item> items, String[][] map) {
        super(exitCoordinates, items, map);
        this.map1b = map;
    }

    @Override
    protected void createLayout() {
        for (int index = 1; index < 6; index++) {
            for (int innerIndex = 1; innerIndex < 6; innerIndex++) {
                this.map1b[index][innerIndex] = " ";
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
        Room testRoom1b = new Room1b(testExitCoord, testItemsInRoom, testMap);
        testRoom1b.deleteLayout();
        testRoom1b.createLayout();
        testRoom1b.displayLayout();

    }
}
