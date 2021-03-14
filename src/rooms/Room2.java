package rooms;

import theitems.Item;
import theobstacles.Obstacle;
import theplayer.Player;

import java.util.ArrayList;
import java.util.Scanner;

public class Room2 extends Room {

    private String[][] map2;
    private Obstacle obstacleInRoom;
    private int[] pressPlate = {4 ,4};

    public Room2(int[][] exitCoordinates, ArrayList<Item> items, String[][] map, Obstacle obstacleInRoom) {
        super(exitCoordinates, items, map);
        this.map2 = map;
        this.obstacleInRoom = obstacleInRoom;
    }

    @Override
    protected void createLayout() {
        for (int index = 1; index < 6; index++) {
            for (int innerIndex = 1; innerIndex < 6; innerIndex++) {
                if (index > 2 || innerIndex > 3) {
                    this.map2[index][innerIndex] = " ";
                }
            }
        }
    }

    private void populateRoom() {
        for (Item item : this.getItemsInRoom()) {
            this.map2[item.getItemCoordinate()[0]][item.getItemCoordinate()[1]] = "i";
        }
        this.map2[getExitCoordinate()[0][0]][getExitCoordinate()[0][1]] = "D";
        this.map2[getExitCoordinate()[0][0]][(getExitCoordinate()[0][1]-1)] = "P";
        this.map2[obstacleInRoom.getObstacleCoordinate()[0]][obstacleInRoom.getObstacleCoordinate()[1]] = "O";
        this.map2[pressPlate[0]][pressPlate[1]] = "*";
    }

    public void onPressPlate(Player player) {
        if (player.getPlayerCoordinates() == pressPlate || obstacleInRoom.getObstacleCoordinate() == pressPlate) {
            System.out.println("You see a table with jewels scattered on top at the back of the room");
        } else {
            System.out.println("There's a table at the back of the room, but you can't make out what is on the table.");
        }
    }

    public void jewelSort(Player player) {
        int[] tablePos = new int[2];
        String chestSlots = "ruby sapphire emerald";
        Scanner scan = new Scanner(System.in);

        for (Item item : this.getItemsInRoom()) {
            tablePos[0] = item.getItemCoordinate()[0];
            tablePos[1] = item.getItemCoordinate()[1];
        }

        if (player.getPlayerCoordinates() == tablePos) {
            System.out.println("There are three jewels on the table, a ruby, a sapphire, and an emerald."
                + " You notice there is a chest with 3 colored slots in the order: red, green, blue"
                + " Enter the order you place the jewels in to unlock the chest:");
            while (scan.hasNextLine()) {
                if (scan.nextLine().equals(chestSlots)) {
                    System.out.println("The jewels clicked into the chest");
                } else {
                    System.out.println("The jewels did not fit into the chest, try again?");
                }
            }

        }

    }



    public static void main(final String[] args) {
        int[][] testExitCoord = {{4, 6}};
        int[] testItemCoord = {5, 1};
        String testItemName = "A rock";
        String testItemDesc = "I am error.";
        int[] testObsCoord = {1, 4};



        Obstacle testObstacle = new Obstacle("crate", "I'm a crate", testObsCoord);

        Item testItem = new Item(testItemCoord, testItemName, testItemDesc);
        ArrayList<Item> testItemsInRoom = new ArrayList<Item>();
        testItemsInRoom.add(testItem);
        String[][] testMap = new String[7][7];
        for (int index = 0; index < 7; index++) {
            for (int innerIndex = 0; innerIndex < 7; innerIndex++) {
                testMap[index][innerIndex] = "U";
            }
        }
        Room2 testRoom = new Room2(testExitCoord, testItemsInRoom, testMap, testObstacle);
        testRoom.deleteLayout();
        testRoom.createLayout();
        testRoom.populateRoom();
        testRoom.displayLayout();
        String chestSlots = "ruby sapphire emerald";
        Scanner scan = new Scanner(System.in);

        System.out.println("There are three jewels on the table, a ruby, a sapphire, and an emerald."
                + " You notice there is a chest with 3 colored slots in the order: red, green, blue"
                + " Enter the order you place the jewels in the chest slots:");
        while (scan.hasNextLine()) {
            if (scan.nextLine().equals(chestSlots)) {
                System.out.println("The jewels clicked into the chest");
            } else {
                System.out.println("The jewels did not fit into the chest, try again?");
            }
        }

    }


}
