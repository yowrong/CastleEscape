package game.driver;

import rooms.*;
import theitems.Item;
import theobstacles.Obstacle;
import theplayer.Player;
import theenemy.Enemy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int[][] blueExitCoord = {{4, 6}};
        int[][] greenExitCoord = {{5, 0}};
        int[][] redExitCoord = {{1, 0}};
        int[][] statueExitCoord = {{1, 6}};
        int[][] hallExitCoord = {{2, 1},{2, 5},{4, 1},{4, 5}};
        int[][] startExitCoord = {{0, 4}};
        int[] blueObsCoord = {1, 4};
        int[] hallObsCoord = {1, 4};
        int[] swordCoord = {1, 5};
        int[] statueCoord = {1, 1};
        int[] smallKeyCoord = {5, 5};
        int[] torchCoord = {5, 3};
        int[] spawnCoord = {5, 5};

        Item sword = new Item(swordCoord, "Sword", "It's sharp.");
        Item statue = new Item(statueCoord, "Statue", "A small statue made of stone.");
        Item smallKey = new Item(smallKeyCoord, "Small key", "This may open a barrier.");
        Item torch = new Item(torchCoord, "Torch", "It's a torch... Seems to light the way.");

        ArrayList<Item> blueItems = new ArrayList<>();
        ArrayList<Item> greenItems = new ArrayList<>();
        greenItems.add(sword);
        ArrayList<Item> redItems = new ArrayList<>();
        ArrayList<Item> statueItems = new ArrayList<>();
        statueItems.add(statue);
        statueItems.add(smallKey);
        ArrayList<Item> hallItems = new ArrayList<>();
        ArrayList<Item> startItems = new ArrayList<>();
        startItems.add(torch);

        String[][] map = new String[7][7];
        for (int index = 0; index < 7; index++) {
            for (int innerIndex = 0; innerIndex < 7; innerIndex++) {
                map[index][innerIndex] = "U";
            }
        }

        Obstacle blueCrate = new Obstacle("Crate", "a movable crate", blueObsCoord);
        Obstacle hallwayCrate = new Obstacle("Crate", "a movable crate", hallObsCoord);

        BlueKeyRoom blueKeyRoom = new BlueKeyRoom(blueExitCoord, blueItems, map, blueCrate);
        GreenKeyRoom greenKeyRoom = new GreenKeyRoom(greenExitCoord, greenItems, map);
        RedKeyRoom redKeyRoom = new RedKeyRoom(redExitCoord, redItems, map);
        StatueRoom statueRoom = new StatueRoom(statueExitCoord, statueItems, map);
        HallwayRoom hallwayRoom = new HallwayRoom(hallExitCoord, hallItems, map, hallwayCrate);
        StartingRoom startingRoom = new StartingRoom(startExitCoord, startItems, map);

        Room[] listRooms = new Room[]{blueKeyRoom, greenKeyRoom, redKeyRoom, statueRoom, hallwayRoom, startingRoom};

        Player thePlayer = new Player("Player 1", listRooms, spawnCoord);
        thePlayer.setCurrentRoom(startingRoom);





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
//
//
//
//        Room[] roomlist = new Room[]{testroomb,testroomg,testroomr,testrooms,testroomh};
//
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
//
//        StartingRoom startingRoom = new StartingRoom(startingRoomExitCoord, startingRoomItemsInRoom, startingRoomMap);
//
//        player.setCurrentRoom(startingRoom);
//        System.out.println(player.getCurrentRoom());


        // write your code here
        // create an item with its own coordinate
        // put item in list
        // create room and pass list
        // room will have the list
        // when room is displayed
        // first fill with X
        // place whitespace
        // add symbols
        
    }
}
