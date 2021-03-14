package rooms;

import theitems.Item;
import theobstacles.Obstacle;
import theplayer.Player;
import java.util.Arrays;
import java.util.ArrayList;


public class GreenKeyRoom extends Room{

    // Not sure if necessary.
    private int[][] exitCoordinate;
    private int[] itemCoord1 = {1, 5};
    private int[] itemkeyCoord = {0, 0};
    private ArrayList<Item> itemsInRoom;
    private String[][] map3;
//    private String itemSword;
//    private String itemGreenKey;
//    private String testSwordDesc = "It's sharp.";
//    private String keyDesc = "It's a green key.";
    private int[] rope = {1, 1};
    private int[] spawn = {5, 1};
    private int[] key = {3, 1};
    private int[] spot1 = {1, 2};
    private int[] spot2 = {2, 2};
    private int[] spot3 = {1, 5};
    private String roomDescription = "Thou see a rope pulley system bearing a key over the ceiling.\n"
            + "The pulley seems most unstable. Maybe thou could disrupt it somehow.";


    //Constuctor for room3.
    public GreenKeyRoom(int[][] exitCoordinates, ArrayList<Item> items, String[][] map) {
        super(exitCoordinates, items, map);
    }

    @Override
    public String getRoomDescription() {
        return roomDescription;
    }

    @Override
    public void exitRoom(int[] playerCoord, Player thePlayer, Room[] nextRoom) {
                int[] var = {2, 4};
                if (playerCoord[0] == 5 && playerCoord[1] == 1){
                    thePlayer.setCurrentRoom(nextRoom[4]);
                    thePlayer.setPlayerCoordinates(var);
                } else {
                    System.out.println("You are not close enough to the door!");
        }
    }

    //Populates room not sure if these letters can be interacted with.
    @Override
    public void populateRoom (Player thePlayer){
        this.getMap()[this.getExitCoordinate()[0][0]][this.getExitCoordinate()[0][1]] = "D";
        this.getMap()[rope[0]][rope[1]] = "R";
        for (Item items : getItemsInRoom()) {
            if (!items.getItemName().equals("Big Green Key")) {
                this.getMap()[items.getItemCoordinate()[0]][items.getItemCoordinate()[1]] = "S";
            }
        }
        System.out.println("In the room you see a sword, and a rope attached to the ceiling with a key tied to the end of it.");
    }
    //Supposed to generate a key if player coordinate and player inventory contains a sword.
    @Override
    public void cutRope(Player thePlayer) {

        System.out.println("You swing your sword and cut the rope.");
        for (Item itemInventory : thePlayer.getInventory()) {
            if ((itemInventory.getItemName().equals("A sword."))
                    && ((Arrays.equals(thePlayer.getPlayerCoordinates(),spot1))
                    || (Arrays.equals(thePlayer.getPlayerCoordinates(),spot2))
                    || (Arrays.equals(thePlayer.getPlayerCoordinates(),spot3)))){
                generateGreenKey();
            }
        }
    }

    private void generateGreenKey() {
        Item itemGreenKey = new Item(key, "Big Green Key", "It's a big green key.");
        this.getItemsInRoom().add(itemGreenKey);
        for (Item itemInRoom : getItemsInRoom()) {
            if (itemInRoom.getItemName().equals("Big Green Key")) {
                this.getMap()[key[0]][key[1]] = "&";
                System.out.println(Arrays.toString(itemGreenKey.getItemCoordinate()));
            }
        }
        this.getMap()[rope[0]][rope[1]] = " ";
        System.out.println("The key drops to the floor, and lands with a \"tink\".");
    }


    //Layout for room.
    @Override
    public void createLayout() {
        for (int index = 1; index < 6; index++) {
            for (int innerIndex = 1; innerIndex < 6; innerIndex++) {
                if (index < 3 || innerIndex < 3) {
                    this.getMap()[index][innerIndex] = " ";
                }
            }
        }
    }


//    public static void main(final String[] args) {
//        int[][] exitCoord = {{5, 0}};
//        int[][] hallCoord = {{2, 1},{2, 5},{4, 1},{4, 5}};
//
//        int[] itemCoord1 = {1, 5};
//        String itemSword = "A sword.";
//        String testSwordDesc = "It's sharp.";
//        Item swordItem = new Item(itemCoord1, itemSword, testSwordDesc);
//
//        ArrayList<Item> testItemsInRoom = new ArrayList<Item>();
//        String[][] testMap = new String[7][7];
//        for (int index = 0; index < 7; index++) {
//            for (int innerIndex = 0; innerIndex < 7; innerIndex++) {
//                testMap[index][innerIndex] = "U";
//            }
//        }
//
//        int[] testObsCoord = {1, 4};
//        GreenKeyRoom testroomg = new GreenKeyRoom(exitCoord, testItemsInRoom, testMap);
//        Obstacle testObstacle = new Obstacle("crate", "I'm a crate", testObsCoord);
//        BlueKeyRoom testroomb = new BlueKeyRoom(exitCoord, testItemsInRoom,testMap, testObstacle);
//        RedKeyRoom testroomr = new RedKeyRoom(exitCoord, testItemsInRoom, testMap);
//        StatueRoom testrooms = new StatueRoom(exitCoord, testItemsInRoom, testMap);
//
//        HallwayRoom testroomh = new HallwayRoom(hallCoord, testItemsInRoom, testMap, testObstacle);
//
//
//
////        for (Item items : testItemsInRoom){
////            System.out.println(items.getItemName());
////        }
//
//        Room[] roomlist = new Room[]{testroomb,testroomg,testroomr,testrooms,testroomh};
//        System.out.println();
//        System.out.println("after");
//        System.out.println();
//        Player player1 = new Player("Sup",roomlist, new int[]{1, 5});
//        player1.setCurrentRoom(roomlist[1]);
//        player1.getCurrentRoom().deleteLayout();
//        player1.getCurrentRoom().createLayout();
//        player1.getCurrentRoom().addItemToRoom(swordItem, itemCoord1);
//        player1.getCurrentRoom().populateRoom(player1);
//        player1.getCurrentRoom().displayLayout();
//        player1.pickUpItem();
//        player1.playerMove("west");
//        player1.playerMove("west");
//        player1.playerMove("west");
//        testroomg.cutRope(player1);
//        player1.playerMove("west");
//        player1.playerMove("south");
//        player1.playerMove("south");
//        player1.pickUpItem();
//        player1.playerMove("south");
//        player1.playerMove("south");
////        System.out.println(testroomg.getItemsInRoom());
////        System.out.println(Arrays.toString(player1.getPlayerCoordinates()));
////        testroom3.cutRope(player1);
////        System.out.println(item);
//        System.out.println(player1.getInventory().get(1).getItemName());
//        System.out.println(Arrays.deepToString(testroomg.getExitCoordinate()));
//        System.out.println(Arrays.toString(player1.getPlayerCoordinates()));
//
//
//
//        player1.getCurrentRoom().displayLayout();
//        player1.getCurrentRoom().exitRoom(player1.getPlayerCoordinates(), player1, roomlist);
//        System.out.println(player1.getCurrentRoom());
//        player1.getCurrentRoom().deleteLayout();
//        player1.getCurrentRoom().createLayout();
//        player1.getCurrentRoom().populateRoom(player1);
//        player1.getCurrentRoom().displayLayout();
//        System.out.println(Arrays.toString(player1.getPlayerCoordinates()));
//        player1.playerPull("south");
//        player1.playerPull("south");
//        player1.playerMove("west");
//        player1.playerMove("north");
//        player1.getCurrentRoom().checkEventTriggers();
//        player1.playerPull("west");
//        player1.playerMove("south");
//        player1.getCurrentRoom().checkEventTriggers();
//        player1.playerMove("west");
//        player1.getCurrentRoom().exitRoom(player1.getPlayerCoordinates(), player1, roomlist);
//        player1.getCurrentRoom().deleteLayout();
//        player1.getCurrentRoom().createLayout();
//        player1.getCurrentRoom().populateRoom(player1);
//        player1.getCurrentRoom().displayLayout();
//        System.out.println(player1.getCurrentRoom());
//        System.out.println(Arrays.toString(player1.getPlayerCoordinates()));

//        System.out.println(testroom3.getItemsInRoom());
//        for (Item items : testItemsInRoom){
//            System.out.println(items.getItemName());
//        }
//    }

}
