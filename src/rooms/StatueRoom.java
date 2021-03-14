package rooms;

import theitems.Item;
import theplayer.Player;

import java.util.ArrayList;

public class StatueRoom extends Room {

    private String roomName;
    private String[][] map1b;
    private int[][] exitCoordinate;
    private ArrayList<Item> itemsInRoom;
    private boolean eventTrigger;
    private String roomDescription = "You immediately spot a statue behind bars.\n"
            + "If you could just get through the barrier somehow...";

    public StatueRoom(int[][] exitCoordinates, ArrayList<Item> items, String[][] map) {
        super(exitCoordinates, items, map);
        this.exitCoordinate = exitCoordinates;
        this.itemsInRoom = items;
        this.map1b = map;
    }

    @Override
    public String getRoomDescription() {
        return roomDescription;
    }

    @Override
    protected void createLayout() {
        for (int index = 1; index < 6; index++) {
            for (int innerIndex = 1; innerIndex < 6; innerIndex++) {
                this.map1b[index][innerIndex] = " ";
                if (index == 4 && innerIndex >= 3) {
                    this.map1b[index][innerIndex] = "X";
                }
                if (index == 2 && innerIndex <= 3) {
                    this.map1b[index][innerIndex] = "X";
                }
            }
            this.map1b[1][1] = "X";
            // adds a barrier to statue
            this.map1b[1][2] = "X";
        }
    }

    @Override
    protected void populateRoom(Player thePlayer) {
        this.map1b[thePlayer.getPlayerCoordinates()[0]][thePlayer.getPlayerCoordinates()[1]] = "P";
        for (Item eachItem : this.getItemsInRoom()) {
            this.map1b[eachItem.getItemCoordinate()[0]][eachItem.getItemCoordinate()[1]] = "i";
        }
        this.map1b[this.getExitCoordinate()[0][0]][this.getExitCoordinate()[0][1]] = "D";
    }

    // potential code for player to use key to access statue
    protected void useKey(Player thePlayer) {
        for (Item eachItem : thePlayer.getInventory()) {
            if ((eachItem.getItemName().equals("Small key"))) {
                this.map1b[1][2]= " ";
            }
            thePlayer.getInventory().remove("Small Key");
        }
    }

    private boolean hasKey() {
        if (!(this.map1b[5][5] == "i")) {
            System.out.println("A barrier seems to have moved");
            this.map1b[1][2] = " ";
            return true;
        } else {
            return false;
        }
    }

    @Override
    public void checkEventTriggers() {
        this.eventTrigger = this.hasKey();
    }

    @Override
    public void exitRoom(int[] playerCoord, Player thePlayer, Room[] nextRoom) {
        if ((playerCoord[0] == 1) && (playerCoord[1]) == 5) {
            thePlayer.setCurrentRoom(nextRoom[4]);
        }
    }

    public static void main(final String[] args) {
        int[] keyCoord = {5, 5};
        ArrayList<Item> testItemsInRoom = new ArrayList<Item>();
        String keyName = "Small key";
        String keyDesc = "This may open a barrier";
        Item key = new Item(keyCoord, keyName, keyDesc);
        int[][] testExitCoord = {{1, 6}};

        int[] playerCoord = {1, 3};

        int[] statueCoord = {1, 1};
        String statueName = "Statue";
        String statueDesc = "A small statue made of stone.";
        Item statue = new Item(statueCoord, statueName, statueDesc);


        testItemsInRoom.add(key);
        testItemsInRoom.add(statue);
        String[][] testMap = new String[7][7];
        for (int index = 0; index < 7; index++) {
            for (int innerIndex = 0; innerIndex < 7; innerIndex++) {
                testMap[index][innerIndex] = "U";
            }
        }
        StatueRoom testRoom1b = new StatueRoom(testExitCoord, testItemsInRoom, testMap);
        testRoom1b.deleteLayout();
        testRoom1b.createLayout();
//        testRoom1b.populateRoom();
        testRoom1b.displayLayout();

        for (Item items : testItemsInRoom) {
            System.out.println(items.getItemName());
        }

//        testRoom1b.populateRoom();
        testRoom1b.displayLayout();


    }
}
