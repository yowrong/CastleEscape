//package game.driver;
//
//import rooms.*;
//import theitems.Item;
//import theobstacles.Obstacle;
//import theplayer.Player;
//
//import java.util.ArrayList;
//import java.util.Arrays;
//
//public class Main {
//
//    public static void main(String[] args) {
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
//        HallwayRoom testroomh = new HallwayRoom(hallCoord, testItemsInRoom, testMap, testObstacle);
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
//        player1.getCurrentRoom().populateRoom();
//        player1.getCurrentRoom().displayLayout();
//        player1.pickUpItem();
//        player1.playerMove("west");
//        player1.playerMove("west");
//        player1.playerMove("west");
//        player1.playerMove("west");
//        player1.playerMove("south");
//        player1.playerMove("south");
//        player1.playerMove("south");
//        player1.playerMove("south");
////        System.out.println(player1.getInventory().get(0).getItemName());
////        System.out.println(Arrays.toString(player1.getPlayerCoordinates()));
////        testroom3.cutRope(player1);
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
//        player1.getCurrentRoom().populateRoom();
//        player1.getCurrentRoom().displayLayout();
//
//        int[][] blueRmExitCoord = {{4, 6}};
//        int[] blueRmObsCoord = {1, 4};
//        ArrayList<Item> blueRmItems = new ArrayList<>();
//
//        int[] playerCoord = {blueRmExitCoord[0][0], blueRmExitCoord[0][1]-1};
//
//        String[][] map = new String[7][7];
//        for (int index = 0; index < 7; index++) {
//            for (int innerIndex = 0; innerIndex < 7; innerIndex++) {
//                map[index][innerIndex] = "U";
//            }
//        }
//        Obstacle blueRmObstacle = new Obstacle("Crate", "A movable crate", blueRmObsCoord);
//
//        BlueKeyRoom blueKeyRoom = new BlueKeyRoom(blueRmExitCoord, blueRmItems, map, blueRmObstacle);
//        Player player = new Player("Player", blueKeyRoom, playerCoord);
//        System.out.println(player.getCurrentRoom());
//        player.playerMove("east");
//
//
//
//        int[][] startingRoomExitCoord = {{0, 4}};
//        ArrayList<Item> startingRoomItemsInRoom = new ArrayList<>();
//        String[][] startingRoomMap = new String[7][7];
//        for (int index = 0; index < 7; index++) {
//            for (int innerIndex = 0; innerIndex < 7; innerIndex++) {
//                startingRoomMap[index][innerIndex] = "U";
//            }
//        }
//        StartingRoom startingRoom = new StartingRoom(startingRoomExitCoord, startingRoomItemsInRoom, startingRoomMap);
//
//        player.setCurrentRoom(startingRoom);
//        System.out.println(player.getCurrentRoom());
//
//
//        // write your code here
//        // create an item with its own coordinate
//        // put item in list
//        // create room and pass list
//        // room will have the list
//        // when room is displayed
//        // first fill with X
//        // place whitespace
//        // add symbols
//    }
//}
