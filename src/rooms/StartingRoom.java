package rooms;

import theitems.Item;
import theplayer.Player;

import java.util.ArrayList;

public class StartingRoom extends Room {
    private int[] pressPlate = {1, 5};
    private boolean eventTrigger;
    private boolean doorOpen = false;

    public StartingRoom(int[][] exitCoordinates, ArrayList<Item> items, String[][] map) {
        super(exitCoordinates, items, map);

    }

    @Override
    protected void createLayout() {
        for (int index = 1; index < 6; index++) {
            for (int innerIndex = 1; innerIndex < 6; innerIndex++) {
                if(innerIndex > 3 || index > 3){
                    this.getMap()[index][innerIndex] = " ";
                }
            }
        }
    }
    @Override
    protected void populateRoom(Player thePlayer) {
        // Might need to change itemsInRoom to this.itemsInRoom
        this.getMap()[this.pressPlate[0]][this.pressPlate[1]] = "*";
        for (Item torch : this.getItemsInRoom()) {
            this.getMap()[torch.getItemCoordinate()[0]][torch.getItemCoordinate()[1]] = "T";
        }
        this.getExitCoordinate();

        //Real door
        this.getMap()[this.getExitCoordinate()[0][0]][this.getExitCoordinate()[0][1]] = "D";

        //Fake player
        this.getMap()[(this.getExitCoordinate()[0][0]) + 4][this.getExitCoordinate()[0][1] - 3] = "P";
    }

//    public boolean TorchLever(Item item) {
//
//        if ((item.getItemName().equals("Torch")) && (item.getItemCoordinate()[0] == torchPlace[0])
//                && (item.getItemCoordinate()[1] == torchPlace[1])) {
//            //if torch is placed, door opens.
//            return true;
//        } else {
//            return false;
//        }
//    }

    public boolean onPressPlate() {

        if (this.getMap()[this.pressPlate[0]][this.pressPlate[1]].equals("T")) {
            System.out.println("Hello!");
            if (!this.doorOpen) {
                System.out.println("You hear the door click open.");
                this.doorOpen = true;
            }
            return true;
        } else {
            System.out.println("Bye!!!!");
            if (this.doorOpen) {
                System.out.println("You hear the door click, locking itself.");
                this.doorOpen = false;
            }
            return false;
        }
    }

    @Override
    public void exitRoom(int[] playerCoord, Player thePlayer, Room[] nextRoom) {
        if (this.eventTrigger) {
            if (playerCoord == this.getExitCoordinate()[0]) {
                thePlayer.setCurrentRoom(nextRoom[0]);
            } else if (playerCoord == this.getExitCoordinate()[1]) {
                thePlayer.setCurrentRoom(nextRoom[1]);
            } else if (playerCoord == this.getExitCoordinate()[2]) {
                thePlayer.setCurrentRoom(nextRoom[3]);
            } else if (playerCoord == this.getExitCoordinate()[3]) {
                thePlayer.setCurrentRoom(nextRoom[2]);
            } else {
                System.out.println("There is no door.");
            }
        }
    }
    public void generateLockedDoor() {
        int[] lockedDoorCoord = {4, 0};
        this.getMap()[(this.getExitCoordinate()[0][0]) + 4][this.getExitCoordinate()[0][1] - 4] = "D";

    }
    private void generateTorch() {
        int[] torchCoord1 = {5, 3};
        String itemName1 = "Torch";
        String torchDesc1 = "It's a torch... Seems to light the way";
        Item torch = new Item(torchCoord1, itemName1, torchDesc1);
        this.getItemsInRoom().add(torch);
    }

    @Override
    public void checkEventTriggers() {
        this.eventTrigger = this.onPressPlate();
    }

    public static void main(final String[] args) {
        int[][] testExitCoord = {{0, 4}};

        ArrayList<Item> testItemsInRoom = new ArrayList<Item>();
        String[][] testMap = new String[7][7];
        for (int index = 0; index < 7; index++) {
            for (int innerIndex = 0; innerIndex < 7; innerIndex++) {
                testMap[index][innerIndex] = "U";
            }
        }

        StartingRoom testStartingRoom = new StartingRoom(testExitCoord, testItemsInRoom, testMap);
        testStartingRoom.deleteLayout();
        testStartingRoom.createLayout();
        testStartingRoom.generateTorch();
        testStartingRoom.generateLockedDoor();
//        testStartingRoom.populateRoom();

        //Room desc

        testStartingRoom.displayLayout();
        for (Item items : testItemsInRoom) {
            System.out.println(items.getItemName());
        }
        //Before torch move
        testStartingRoom.checkEventTriggers();
        System.out.println(testStartingRoom.onPressPlate());

        //Testing if player placed torch on pressure plate successfully
        int[] torchNewCoord = {1, 5};

        testItemsInRoom.get(0).setItemCoordinate(torchNewCoord);
        System.out.println(testStartingRoom.getMap()[1][5]);
        //Prints if the pressureplate
        testStartingRoom.checkEventTriggers();
        System.out.println(testStartingRoom.onPressPlate());
        testStartingRoom.createLayout();
//        testStartingRoom.populateRoom();
        testStartingRoom.displayLayout();


    }
}
