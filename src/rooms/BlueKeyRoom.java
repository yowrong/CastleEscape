package rooms;

import theitems.Item;
import theobstacles.Obstacle;
import theplayer.Player;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class BlueKeyRoom extends Room {

    private Obstacle obstacleInRoom;
    private int[] pressPlate = {4, 4};
    private int[] table = {5, 1};
    private boolean wallsOpened = false;
    private boolean eventTrigger;
    private String roomDescription = "Thou enter a dimly lit room\n.There seems to be a table at "
            + "the back of the room yet thou just canst not see what it is.\n"
            + "Ere thou compose a move, thou notice a most loose tile  in front of thou.\n"
            + "It looks like it could be pushed in\n.There seems to be a couple boxes towards the north.";

    public BlueKeyRoom(int[][] exitCoordinates, ArrayList<Item> items, String[][] map, Obstacle obstacleInRoom) {
        super(exitCoordinates, items, map);
        this.obstacleInRoom = obstacleInRoom;
    }

    @Override
    public String getRoomDescription() {
        return roomDescription;
    }

    @Override
    protected void createLayout() {
        for (int index = 1; index < 6; index++) {
            for (int innerIndex = 1; innerIndex < 6; innerIndex++) {
                if (index > 2 || innerIndex > 3) {
                    this.getMap()[index][innerIndex] = " ";
                }
            }
        }
    }

    //populateRoom creates the room
    @Override
    protected void populateRoom() {
        this.getMap()[getExitCoordinate()[0][0]][getExitCoordinate()[0][1]] = "D";
        this.getMap()[getExitCoordinate()[0][0]][(getExitCoordinate()[0][1]-1)] = "P";
        this.getMap()[obstacleInRoom.getObstacleCoordinate()[0]][obstacleInRoom.getObstacleCoordinate()[1]] = "O";
        this.getMap()[pressPlate[0]][pressPlate[1]] = "*";
        this.getMap()[table[0]][table[1]] = "?";
    }

    @Override
    public void exitRoom(int[] playerCoord, Player thePlayer, Room[] nextRoom) {
        if (playerCoord[0] == 4 && playerCoord[1] == 5){
            thePlayer.setCurrentRoom(nextRoom[4]);
        } else {
            System.out.println("You are not close enough to the door!");
        }
    }

    @Override
    public void checkEventTriggers() {
        this.eventTrigger = this.onPressPlate();
    }

    public boolean onPressPlate() {
        if (this.getMap()[pressPlate[0]][pressPlate[1]].equals("P")
                || this.getMap()[pressPlate[0]][pressPlate[1]].equals("O")) {
            if (!this.wallsOpened) {
                System.out.println("The wall behind the table opens revealing a hidden chest.");
                this.wallsOpened = true;
            }
            return true;
        } else {
            if (this.wallsOpened) {
                System.out.println("The wall closes around the hidden chest.");
                this.wallsOpened = false;
            }
            return false;
        }
    }

    private void generateBigKey(Player thePlayer) {
        int[] blueKeyCoord = {thePlayer.getPlayerCoordinates()[0], thePlayer.getPlayerCoordinates()[1]};
        Item bigBlueKey = new Item(blueKeyCoord, "Big Blue Key", "A large shiny blue key");
        this.getItemsInRoom().add(bigBlueKey);
        this.getMap()[blueKeyCoord[0]][blueKeyCoord[1]] = "!";
    }

    public void jewelSort(Player thePlayer) {
        String chestSlots = "ruby emerald sapphire";
        Scanner scan = new Scanner(System.in);

        int[] tableAccessPt1 = {table[0], table[1]+1};
        int[] tableAccessPt2 = {table[0]-1, table[1]};

        if (Arrays.equals(thePlayer.getPlayerCoordinates(), tableAccessPt1)
                || Arrays.equals(thePlayer.getPlayerCoordinates(), tableAccessPt2)) {
            System.out.println("There are three jewels on the table, a sapphire, a ruby, and an emerald."
                + "\nYou notice the chest has 3 colored slots in the order: red, green, and blue"
                + "\nEnter the order (without commas), to place the jewels in, to unlock the chest:");
            while (!scan.nextLine().equals(chestSlots)) {
                    System.out.println("The jewels did not fit into the chest, try again?");
            }
            System.out.println("The jewels clicked into the chest. The chest opens and reveals a key.");
            generateBigKey(thePlayer);
        }
        scan.close();
    }



//    public static void main(final String[] args) {
//        int[][] testExitCoord = {{4, 6}};
//        int[] testItemCoord = {5, 1};
//        String testItemName = "Table";
//        String testItemDesc = "A table";
//        int[] testObsCoord = {1, 4};
//        int[] testPlayCoord = {5, 2};
//
//        Obstacle testObstacle = new Obstacle("crate", "I'm a crate", testObsCoord);
//
//        Item testItem = new Item(testItemCoord, testItemName, testItemDesc);
//
//        ArrayList<Item> testItemsInRoom = new ArrayList<>();
//        testItemsInRoom.add(testItem);
//        String[][] testMap = new String[7][7];
//        for (int index = 0; index < 7; index++) {
//            for (int innerIndex = 0; innerIndex < 7; innerIndex++) {
//                testMap[index][innerIndex] = "U";
//            }
//        }
//        BlueKeyRoom testRoom = new BlueKeyRoom(testExitCoord, testItemsInRoom, testMap, testObstacle);

//        Player testPlayer = new Player("Player", testRoom, testPlayCoord);

//        testRoom.deleteLayout();
//        testRoom.createLayout();
//        testRoom.populateRoom();
//        testRoom.displayLayout();
//
//        testRoom.jewelSort(testPlayer);
//        testRoom.displayLayout();
//        testPlayer.pickUpItem();
//        for (Item items : testItemsInRoom) {
//            System.out.println(items.getItemName());
//        }





//        for (Item items : testItemsInRoom) {
//            System.out.println(items.getItemName());
//        }
//
//        for (Item items : testItemsInRoom) {
//            System.out.println(Arrays.toString(items.getItemCoordinate()));
//        }
//
//        System.out.println(testPlayer.getInventory().size());
//        for (Item items : testPlayer.getInventory()) {
//            System.out.println(items.getItemName());
//        }
//
//
//        for (Item items : testItemsInRoom) {
//            System.out.println(items.getItemName());
//        }
//        System.out.println(testPlayer.getInventory());

//        String chestSlots = "ruby sapphire emerald";
//        Scanner scan = new Scanner(System.in);
//
//        System.out.println("There are three jewels on the table, a ruby, a sapphire, and an emerald."
//                + " You notice there is a chest with 3 colored slots in the order: red, green, blue"
//                + " Enter the order you place the jewels in the chest slots:");
//        while (scan.hasNextLine()) {
//            if (scan.nextLine().equals(chestSlots)) {
//                System.out.println("The jewels clicked into the chest");
//            } else {
//                System.out.println("The jewels did not fit into the chest, try again?");
//            }
//        }
//    }



}
