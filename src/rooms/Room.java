package rooms;

import theitems.Item;
import theplayer.Player;

import java.util.ArrayList;
import java.util.Arrays;

public class Room {

    private int[][] exitCoordinate;
    private ArrayList<Item> itemsInRoom;
    private String[][] map;

    public Room(int[][] exitCoordinates, ArrayList<Item> items, String[][] map) {
        this.exitCoordinate = exitCoordinates;
        this.itemsInRoom = items;
        this.map = map;
    }


    public ArrayList<Item> getItemsInRoom() {
        return itemsInRoom;
    }

    public int[][] getExitCoordinate() {
        return exitCoordinate;
    }

    public String[][] getMap() {
        return map;
    }


    protected void createLayout() {
        for (int index = 1; index < 6; index++) {
            for (int innerIndex = 2; innerIndex < 5; innerIndex++) {
                this.map[index][innerIndex] = " ";
            }
        }
    }


    protected void deleteLayout() {
        for (int index = 0; index < 7; index++) {
            for (int innerIndex = 0; innerIndex < 7; innerIndex++) {
                if (!this.map[index][innerIndex].equals("X")) {
                    this.map[index][innerIndex] = "X";
                }
            }
        }
    }


    protected void displayLayout() {
        for (int index = 0; index < 7; index++) {
            for (int innerIndex = 0; innerIndex < 7; innerIndex++) {
                System.out.print(map[index][innerIndex]);
                System.out.print(" ");
            }
            System.out.println();
        }
    }


    protected void updatePlayerPos(int[] currentPlayerPos, int[] newPlayerPos) {
        this.map[currentPlayerPos[0]][currentPlayerPos[1]] = " ";
        this.map[newPlayerPos[0]][newPlayerPos[1]] = "P";
    }

    protected void updateItemPos(int[] currentItemPos, int[] newItemPos) {
        this.map[currentItemPos[0]][currentItemPos[1]] = " ";
        this.map[newItemPos[0]][newItemPos[1]] = "i";
    }

    protected void updateObstaclePos(int[] currentObstaclePos, int[] newObstaclePos) {
        this.map[currentObstaclePos[0]][currentObstaclePos[1]] = " ";
        this.map[newObstaclePos[0]][newObstaclePos[1]] = "O";
    }

    protected void addItemToRoom(Item itemToDrop, int[] currentPosition) {
       this.itemsInRoom.add(itemToDrop);
       itemToDrop.setItemCoordinate(currentPosition);
    }


    public void playerEntersRoom(int[] playerCoord) {
        playerCoord[0] = 0;
        playerCoord[1] = 0;
    }



//    private void moveRooms(Room newRoom) {
//
//    }

//    private void playerExitsRoom(int[] playerCoord, Player thePlayer) {
//        if (playerCoord == this.exitCoordinate[0]) {
//            thePlayer.setCurrentRoom();
//            deleteLayout();
//            newRoom.createLayout();
//        }
//    }


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
        Room testRoom = new Room(testExitCoord, testItemsInRoom, testMap);
        testRoom.deleteLayout();
        testRoom.createLayout();
        testRoom.displayLayout();

    }


}
