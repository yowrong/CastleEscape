package rooms;

import theitems.Item;
import theplayer.Player;

import java.util.ArrayList;

public class Room1b extends Room {

    private String roomName;
    private String[][] map1b;
    private int[][] exitCoordinate;
    private ArrayList<Item> itemsInRoom;

    public Room1b(int[][] exitCoordinates, ArrayList<Item> items, String[][] map) {
        super(exitCoordinates, items, map);
        this.exitCoordinate = exitCoordinates;
        this.itemsInRoom = items;
        this.map1b = map;
    }

    @Override
    protected void createLayout() {
        for (int index = 1; index < 6; index++) {
            for (int innerIndex = 1; innerIndex < 6; innerIndex++) {
                this.map1b[index][innerIndex] = " ";
                if (index == 4 && innerIndex >= 3) {
                    this.map1b[index][innerIndex] = "X";
                }
            }
        }
    }

    protected void populateRoom() {
        for (Item eachItem : this.getItemsInRoom()) {
            this.map1b[eachItem.getItemCoordinate()[0]][eachItem.getItemCoordinate()[1]] = "i";
        }
        this.map1b[this.getExitCoordinate()[0][0]][this.getExitCoordinate()[0][1]] = "D";
    }

//    protected void useKey(Player thePlayer) {
//        for (Item eachItem : thePlayer.getInventory()) {
//            if (eachItem.getItemName().equals("Small key")) {
//
//            }
//        }
//    }

    public static void main(final String[] args) {
        int[][] testExitCoord = {{1, 6}};
        int[] keyCoord = {5, 5};
        String keyName = "Small key";
        String keyDesc = "Opens a lock";
        Item key = new Item(keyCoord, keyName, keyDesc);

        int[] statueCoord = {1, 1};
        String statueName = "Statue";
        String statueDesc = "A small statue made of stone.";
        Item statue = new Item(statueCoord, statueName, statueDesc);

        ArrayList<Item> testItemsInRoom = new ArrayList<Item>();
        testItemsInRoom.add(key);
        testItemsInRoom.add(statue);
        String[][] testMap = new String[7][7];
        for (int index = 0; index < 7; index++) {
            for (int innerIndex = 0; innerIndex < 7; innerIndex++) {
                testMap[index][innerIndex] = "U";
            }
        }
        Room1b testRoom1b = new Room1b(testExitCoord, testItemsInRoom, testMap);
        testRoom1b.deleteLayout();
        testRoom1b.createLayout();
        testRoom1b.populateRoom();
        testRoom1b.displayLayout();

        for (Item items : testItemsInRoom) {
            System.out.println(items.getItemName());
        }

    }
}
