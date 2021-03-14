package rooms;

import theitems.Item;
import theplayer.Player;

import java.util.ArrayList;

public class StartingRoom extends Room {
    private int[] torchPlace = {1, 5};


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

    protected void populateRoom() {
        // Might need to change itemsInRoom to this.itemsInRoom
        this.getMap()[this.getExitCoordinate()[0][0] + 1][this.getExitCoordinate()[0][1] + 1] = "H";
        for (Item torch : this.getItemsInRoom()) {
            this.getMap()[torch.getItemCoordinate()[0]][torch.getItemCoordinate()[1]] = "T";
        }
        this.getExitCoordinate();

        //Real door
        this.getMap()[this.getExitCoordinate()[0][0]][this.getExitCoordinate()[0][1]] = "D";

        //Fake player
        this.getMap()[(this.getExitCoordinate()[0][0]) + 4][this.getExitCoordinate()[0][1] - 3] = "P";
    }

    public String TorchLever(Item item) {

        if ((item.getItemName().equals("Torch")) && (item.getItemCoordinate()[0] == torchPlace[0])
                && (item.getItemCoordinate()[1] == torchPlace[1])) {
            //if torch is placed, door opens.
            return "Torch triggered pressure plate successfully";
        } else {
            return "Torch didn't trigger";
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
        System.out.println(testStartingRoom.TorchLever(testItemsInRoom.get(0)));
        testStartingRoom.createLayout();
        testStartingRoom.populateRoom();
        testStartingRoom.displayLayout();


    }
}
