package rooms;

import theitems.Item;
import theplayer.Player;

import java.util.ArrayList;

public class StartingRoom extends Room {
    private int[][] exitCoordinate;
    private ArrayList<Item> itemsInRoom;
    private String[][] StartingRoom;
    private int[] torchPlace = {1, 5};


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
                if(innerIndex > 3 || index > 3){
                    this.StartingRoom[index][innerIndex] = " ";
                }
            }
        }
    }

    protected void populateRoom() {
        // Might need to change itemsInRoom to this.itemsInRoom
        this.StartingRoom[this.getExitCoordinate()[0][0] + 1][this.getExitCoordinate()[0][1] + 1] = "H";
        for (Item torch : itemsInRoom) {
            this.StartingRoom[torch.getItemCoordinate()[0]][torch.getItemCoordinate()[1]] = "T";
        }
        this.getExitCoordinate();

        //Real door
        this.StartingRoom[this.getExitCoordinate()[0][0]][this.getExitCoordinate()[0][1]] = "D";

//        this.StartingRoom[(this.getExitCoordinate()[0][0]) + 1][this.getExitCoordinate()[0][1]] = "P";

        //EXPERIMENTAL -- This is where player spawns, Door behind starting point should be dysfunctional.
        //User should be prompted something along the lines "door is shut with a magical force"

        //Locked door
        this.StartingRoom[(this.getExitCoordinate()[0][0]) + 4][this.getExitCoordinate()[0][1] - 4] = "D";

        //Fake player
        this.StartingRoom[(this.getExitCoordinate()[0][0]) + 4][this.getExitCoordinate()[0][1] - 3] = "P";
    }




    //Experimental Torch Lever 1 / 2 are incomplete, and need to go over logic to fix how items should be detected.
    // Only one of two should ideally be used.
    public void experimentalTorchLever(Player player) {
        for (Item itemInInventory : player.getInventory()) {
            this.StartingRoom[this.getExitCoordinate()[0][0] + 1][this.getExitCoordinate()[0][1] + 1] = "H";
            if (player.getPlayerCoordinates() == torchPlace && itemInInventory.getItemName() == "Torch") {
                //Player places item.

            }
        }
    }


    public String experimentalTorchLever2(Item item) {

        if ((item.getItemName().equals("Torch")) && (item.getItemCoordinate()[0] == torchPlace[0])
                && (item.getItemCoordinate()[1] == torchPlace[1])) {
            //if torch is placed, door opens.
            return "Torch triggered pressure plate successfully";
        } else {
            return "Torch didn't trigger";
        }
    }

    private void generateTorch() {
        int[] torchCoord1 = {5, 3};
        String itemName1 = "Torch";
        String torchDesc1 = "It's a torch... Seems to light the way";
        Item torch = new Item(torchCoord1, itemName1, torchDesc1);
        this.getItemsInRoom().add(torch);
    }



//    private void onPressPlate(Item item) {
//        if ((item.getItemName().equals("Statue")) && (item.getItemCoordinate()[0] == this.pressPlate[0])
//                && (item.getItemCoordinate()[1] == this.pressPlate[1])) {
//            generateBigKey();
//        }
//    }

    public static void main(final String[] args) {
        int[][] testExitCoord = {{0, 4}};

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
        testStartingRoom.deleteLayout();
        testStartingRoom.createLayout();
        testStartingRoom.generateTorch();
//        testStartingRoom.displayLayout();
        testStartingRoom.populateRoom();

        //Room desc

        testStartingRoom.displayLayout();
        for (Item items : testItemsInRoom) {
            System.out.println(items.getItemName());
        }

        //Testing if player placed torch on pressure plate successfully
        int[] torchNewCoord = {1, 5};
        testItemsInRoom.get(0).setItemCoordinate(torchNewCoord);

        //Prints if the pressureplate
        System.out.println(testStartingRoom.experimentalTorchLever2(testItemsInRoom.get(0)));
        testStartingRoom.createLayout();
        testStartingRoom.populateRoom();
        testStartingRoom.displayLayout();


    }
}