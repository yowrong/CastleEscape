package rooms;

import theitems.Item;
import theobstacles.Obstacle;
import theplayer.Player;

import java.util.ArrayList;
import java.util.Arrays;

public class Room {

    private int[][] exitCoordinate;
    private ArrayList<Item> itemsInRoom;
    private String[][] map;
    private String lastSquare = " ";
    private Obstacle obstacle;


    public Room(int[][] exitCoordinates, ArrayList<Item> items, String[][] map) {
        this.exitCoordinate = exitCoordinates;
        this.itemsInRoom = items;
        this.map = map;
    }

    protected void populateRoom(Player thePlayer) {
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

    public Obstacle getObstacle() {
        return obstacle;
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


    public void updatePlayerPos(int[] currentPlayerPos, int[] newPlayerPos) {
        this.getMap()[currentPlayerPos[0]][currentPlayerPos[1]] = lastSquare;
        lastSquare = this.getMap()[newPlayerPos[0]][newPlayerPos[1]];
        this.getMap()[newPlayerPos[0]][newPlayerPos[1]] = "P";
    }

    public String getLastSquare() {
        return lastSquare;
    }

    public void setLastSquare(String lastSquare) {
        this.lastSquare = lastSquare;
    }

    public void updateItemPos(int[] currentItemPos, int[] newItemPos) {
        this.getMap()[currentItemPos[0]][currentItemPos[1]] = " ";
        this.getMap()[newItemPos[0]][newItemPos[1]] = "i";
    }

    public void updateObstaclePos(int[] currentObstaclePos, int[] newObstaclePos) {
        this.getMap()[currentObstaclePos[0]][currentObstaclePos[1]] = " ";
        this.getMap()[newObstaclePos[0]][newObstaclePos[1]] = "O";
    }

    public void addItemToRoom(Item itemToDrop, int[] currentPosition) {
       this.itemsInRoom.add(itemToDrop);
       itemToDrop.setItemCoordinate(currentPosition);
    }


    public void playerEntersRoom(int[] playerCoord) {
        playerCoord[0] = 0;
        playerCoord[1] = 0;
    }


    public void checkEventTriggers() {
        boolean eventTrigger = false;
        System.out.println("This will be overridden.");
    }

//    private void moveRooms(Room newRoom) {
//
//    }

    //Room[] = {blue, green, red, statue, hallway, starting}

    public void exitRoom(int[] playerCoord, Player thePlayer, Room[] nextRoom) {
        for (int i = 0; i < this.getExitCoordinate().length; i++) {
            for (int j = 0; j < this.getExitCoordinate()[i].length; j++) {
                if ((Math.abs(playerCoord[0] - this.getExitCoordinate()[i][j]) == 1
                        && Math.abs(playerCoord[1] - this.getExitCoordinate()[i][j]) == 0)
                        || (Math.abs(playerCoord[0] - this.getExitCoordinate()[i][j]) == 0
                        && Math.abs(playerCoord[1] - this.getExitCoordinate()[i][j]) == 1)) {
                    if (Arrays.equals(this.getExitCoordinate()[i], new int[]{2, 1})) {
                        thePlayer.setCurrentRoom(nextRoom[0]);
                    } else if (Arrays.equals(this.getExitCoordinate()[i], new int[]{2, 5})) {
                        thePlayer.setCurrentRoom(nextRoom[1]);
                    } else if (Arrays.equals(this.getExitCoordinate()[i], new int[]{4, 5})) {
                        thePlayer.setCurrentRoom(nextRoom[2]);
                    } else if (Arrays.equals(this.getExitCoordinate()[i], new int[]{4, 1})) {
                        thePlayer.setCurrentRoom(nextRoom[3]);
                    } else {
                        thePlayer.setCurrentRoom(nextRoom[4]);
                    }
                } else {
                    System.out.println("You are not close enough to the door!");
                }
            }
        }
    }
//        if (playerCoord == this.exitCoordinate[0]) {
//            thePlayer.setCurrentRoom();
//            deleteLayout();
//            newRoom.createLayout();
//        }


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
        String keyName = "red key";
        String keyDesc = "The key";
        int[] keyCoord = {16, 16};
        Item redKey = new Item(keyCoord, keyName, keyDesc);
        ArrayList<Item> itemsStartingInRoom = new ArrayList<>();
        itemsStartingInRoom.add(redKey);
        Room newRoom = new Room(testExitCoord, itemsStartingInRoom, testMap);

    }


}
