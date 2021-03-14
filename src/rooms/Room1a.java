package rooms;

import theitems.Item;

import java.util.ArrayList;

public class Room1a extends Room {

    private String[][] map1a;
    private int[] pressPlate = {4, 4};

    public Room1a(int[][] exitCoordinates, ArrayList<Item> items, String[][] map) {
        super(exitCoordinates, items, map);
        this.map1a = map;
    }

    @Override
    protected void createLayout() {
        for (int index = 1; index < 6; index++) {
            for (int innerIndex = 1; innerIndex < 6; innerIndex++) {
                if (index < 2 || innerIndex < 4) {
                    this.map1a[index][innerIndex] = " ";
                }
            }
        }
    }

    private void populateRoom() {
        for (Item eachItem : this.getItemsInRoom()) {
            this.map1a[eachItem.getItemCoordinate()[0]][eachItem.getItemCoordinate()[1]] = "i";
        }
        this.map1a[this.getExitCoordinate()[0][0]][this.getExitCoordinate()[0][1]] = "D";
        this.map1a[this.pressPlate[0]][this.pressPlate[1]] = "*";
    }

    private void generateBigKey() {
        int[] redKeyCoord = {1, 5};
        Item bigRedKey = new Item(redKeyCoord, "Big Red Key", "A large shiny red key");
        this.getItemsInRoom().add(bigRedKey);

    }

    private void onPressPlate(Item item) {
        if ((item.getItemName().equals("Statue")) && (item.getItemCoordinate()[0] == this.pressPlate[0])
            && (item.getItemCoordinate()[1] == this.pressPlate[1])) {
            generateBigKey();
        }
    }


    public static void main(final String[] args) {
        int[][] testExitCoord = {{1, 0}};
        int[] itemCoord = {5, 1};
        String itemName = "A piece of Paper";
        String itemDesc = "A written letter addressed to 'Mr Smith'";
        Item paper = new Item(itemCoord, itemName, itemDesc);

        ArrayList<Item> testItemsInRoom = new ArrayList<Item>();
        testItemsInRoom.add(paper);

        String[][] testMap = new String[7][7];
        for (int index = 0; index < 7; index++) {
            for (int innerIndex = 0; innerIndex < 7; innerIndex++) {
                testMap[index][innerIndex] = "U";
            }
        }
        Room1a testRoom1a = new Room1a(testExitCoord, testItemsInRoom, testMap);
        testRoom1a.deleteLayout();
        testRoom1a.createLayout();
//        testRoom1a.populateRoom();
//        testRoom1a.displayLayout();

        int[] statueCoord = {4, 3};
        String statueName = "Statue";
        String statusDesc = "A written letter addressed to 'Mr Smith'";
        Item statue = new Item(statueCoord, statueName, statusDesc);
        testItemsInRoom.add(statue);

        testRoom1a.deleteLayout();
        testRoom1a.createLayout();
        testRoom1a.onPressPlate(statue);
        testRoom1a.populateRoom();
        System.out.println("Before statue placed");
        testRoom1a.displayLayout();
        for (Item items : testItemsInRoom) {
            System.out.println(items.getItemName());
        }
        System.out.println();


        int[] statueNewCoord = {4, 4};
        testRoom1a.deleteLayout();
        testRoom1a.createLayout();
        statue.setItemCoordinate(statueNewCoord);
        testRoom1a.onPressPlate(statue);
        testRoom1a.populateRoom();
        System.out.println("After statue placed");
        testRoom1a.displayLayout();


        for (Item items : testItemsInRoom) {
            System.out.println(items.getItemName());
        }

    }
}
