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

    public BlueKeyRoom(int[][] exitCoordinates, ArrayList<Item> items, String[][] map, Obstacle obstacleInRoom) {
        super(exitCoordinates, items, map);
        this.obstacleInRoom = obstacleInRoom;
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
    private void populateRoom() {
//        for (Item item : this.getItemsInRoom()) {
//            this.getMap()[item.getItemCoordinate()[0]][item.getItemCoordinate()[1]] = "?";
//        }
        this.getMap()[getExitCoordinate()[0][0]][getExitCoordinate()[0][1]] = "D";
        this.getMap()[getExitCoordinate()[0][0]][(getExitCoordinate()[0][1]-1)] = "P";
        this.getMap()[obstacleInRoom.getObstacleCoordinate()[0]][obstacleInRoom.getObstacleCoordinate()[1]] = "O";
        this.getMap()[pressPlate[0]][pressPlate[1]] = "*";
        this.getMap()[table[0]][table[1]] = "?";
    }

    @Override
    public void checkEventTriggers() {
        boolean eventTrigger = false;
        if (this.onPressPlate()) {
            eventTrigger = true;
        }
    }

    //onPressPlate when the player or obstacle is on the pressure plate, the table item becomes accessible
    public boolean onPressPlate() {
        if (this.getMap()[pressPlate[0]][pressPlate[1]].equals("P")
                || this.getMap()[pressPlate[0]][pressPlate[1]].equals("O")) {
            System.out.println("You see a table with jewels scattered on top at the back of the room");
            return true;
        } else {
            System.out.println("There's a table at the back of the room, but you can't make out what is on the table.");
            return false;
        }
    }

    //generateBigKey generates the Big Blue Key once the player has solved the puzzle
    private void generateBigKey(Player player) {
        int[] blueKeyCoord = {player.getPlayerCoordinates()[0],player.getPlayerCoordinates()[1]};
        Item bigBlueKey = new Item(blueKeyCoord, "Big Blue Key", "A large shiny blue key");
        this.getItemsInRoom().add(bigBlueKey);
        this.getMap()[blueKeyCoord[0]][blueKeyCoord[1]] = "!";
    }

    //jewelSort is a sequence puzzle triggered when the player is in the adjacent position to the table item
    public void jewelSort(Player player) {
        String chestSlots = "ruby emerald sapphire";
        Scanner scan = new Scanner(System.in);

        int[] tableAccessPt1 = {table[0], table[1]+1};
        int[] tableAccessPt2 = {table[0]-1, table[1]};

        if (Arrays.equals(player.getPlayerCoordinates(), tableAccessPt1)
                || Arrays.equals(player.getPlayerCoordinates(), tableAccessPt2)) {
            System.out.println("There are three jewels on the table, a ruby, a sapphire, and an emerald."
                + "\nYou notice there is a chest with 3 colored slots in the order: red, green, blue"
                + "\nEnter the order you place the jewels in to unlock the chest:");
            while (!scan.nextLine().equals(chestSlots)) {
                    System.out.println("The jewels did not fit into the chest, try again?");
            }
            System.out.println("The jewels clicked into the chest. The chest opens and reveals a key.");
            generateBigKey(player);
        }
        scan.close();
    }



    public static void main(final String[] args) {
        int[][] testExitCoord = {{4, 6}};
        int[] testItemCoord = {5, 1};
//        String testItemName = "Table";
//        String testItemDesc = "A table";
        int[] testObsCoord = {1, 4};
        int[] testPlayCoord = {5, 2};

        Obstacle testObstacle = new Obstacle("crate", "I'm a crate", testObsCoord);

//        Item testItem = new Item(testItemCoord, testItemName, testItemDesc);

        ArrayList<Item> testItemsInRoom = new ArrayList<>();
//        testItemsInRoom.add(testItem);
        String[][] testMap = new String[7][7];
        for (int index = 0; index < 7; index++) {
            for (int innerIndex = 0; innerIndex < 7; innerIndex++) {
                testMap[index][innerIndex] = "U";
            }
        }
        BlueKeyRoom testRoom = new BlueKeyRoom(testExitCoord, testItemsInRoom, testMap, testObstacle);

        Player testPlayer = new Player("Player", testRoom, testPlayCoord);

        testRoom.deleteLayout();
        testRoom.createLayout();
        testRoom.populateRoom();
        testRoom.displayLayout();

        testRoom.jewelSort(testPlayer);
        testRoom.displayLayout();
        testPlayer.pickUpItem();
        for (Item items : testItemsInRoom) {
            System.out.println(items.getItemName());
        }





//        for (Item items : testItemsInRoom) {
//            System.out.println(items.getItemName());
//        }
//
//        for (Item items : testItemsInRoom) {
//            System.out.println(Arrays.toString(items.getItemCoordinate()));
//        }
//
        System.out.println(testPlayer.getInventory().size());
        for (Item items : testPlayer.getInventory()) {
            System.out.println(items.getItemName());
        }
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

    }


}
