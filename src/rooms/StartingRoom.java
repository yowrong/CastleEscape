package rooms;

import theitems.Item;

import java.util.ArrayList;

public class StartingRoom extends Room {
    private int[][] exitCoordinate;
    private ArrayList<Item> itemsInRoom;
    private String[][] StartingRoom;

    public StartingRoom(int[][] exitCoordinates, ArrayList<Item> items, String[][] map) {
        super(exitCoordinates, items, map);
        this.exitCoordinate = exitCoordinates;
        this.itemsInRoom = items;
        this.StartingRoom = map;
    }

    @Override
    protected void createLayout() {
        for (int index = 1; index < 6; index++) {
            for (int innerIndex = 1; innerIndex < 6; innerIndex++) {
                if(innerIndex > 3){
                    this.StartingRoom[index][innerIndex] = " ";
                }
                if(index > 3) {
                    this.StartingRoom[index][innerIndex] = " ";
                }
            }
        }
    }

    protected void addItemToRoom(Item itemToDrop, int[] currentPosition) {
        this.itemsInRoom.add(itemToDrop);
        itemToDrop.setItemCoordinate(currentPosition);
    }


    protected void populateRoom() {
        for (Item torch : itemsInRoom) {
            this.StartingRoom[torch.getItemCoordinate()[0]][torch.getItemCoordinate()[1]] = "T";
        }
    }
    public static void main(final String[] args) {
        int[][] testExitCoord = {{0, 0}};
        int[] testItemCoord = {5, 3};
        String testItemName = "A torch";
        String testItemDesc = "I am a torch.";

        Item torch = new Item(testItemCoord, testItemName, testItemDesc);
        ArrayList<Item> testItemsInRoom = new ArrayList<Item>();
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

        StartingRoom testStartingRoom = new StartingRoom(testExitCoord, testItemsInRoom, testMap);
//        testStartingRoom.getItemsInRoom().add(torch, testItemCoord);
        testStartingRoom.deleteLayout();
        testStartingRoom.createLayout();
        testStartingRoom.displayLayout();
        testStartingRoom.populateRoom();


    }
}
