package rooms;

import theitems.Item;
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
    private int[] key = {3, 1};
    private int[] spot1 = {1, 2};
    private int[] spot2 = {2, 2};
    private int[] spot3 = {2, 1};

    //Constuctor for room3.
    public GreenKeyRoom(int[][] exitCoordinates, ArrayList<Item> items, String[][] map) {
        super(exitCoordinates, items, map);
        this.exitCoordinate = exitCoordinates;
        this.itemsInRoom = items;
        this.map3 = map;
    }

    //Populates room not sure if these letters can be interacted with.
    protected void populateRoom (){
        for (Item items : getItemsInRoom()) {
            if (!items.getItemName().equals("Big Green Key")) {
                this.map3[items.getItemCoordinate()[0]][items.getItemCoordinate()[1]] = "S";
            }
        }
        this.getMap()[this.getExitCoordinate()[0][0]][this.getExitCoordinate()[0][1]] = "D";
        this.getMap()[rope[0]][rope[1]] = "R";
    }

    private void generateGreenKey() {
        Item itemGreenKey = new Item(itemkeyCoord, "Big Green Key", "It's a big green key.");
        this.getItemsInRoom().add(itemGreenKey);
        for (Item itemInRoom : getItemsInRoom()) {
            if (itemInRoom.getItemName().equals("Big Green Key")) {
                this.map3[key[0]][key[1]] = "&";
            }
        }
        this.map3[rope[0]][rope[1]] = " ";
    }

    //Layout for room.
    @Override
    protected void createLayout() {
        for (int index = 1; index < 6; index++) {
            for (int innerIndex = 1; innerIndex < 6; innerIndex++) {
                if (index < 3 || innerIndex < 3) {
                    this.map3[index][innerIndex] = " ";
                }
            }
        }
    }

    //Supposed to generate a key if player coordinate and player inventory contains a sword.
    protected void cutRope(Player thePlayer) {
        for (Item itemInventory : thePlayer.getInventory()) {
            if (itemInventory.getItemName().equals("A sword.")
                    && ((Arrays.equals(thePlayer.getPlayerCoordinates(),spot1))
                    || Arrays.equals(thePlayer.getPlayerCoordinates(),spot2)
                    || Arrays.equals(thePlayer.getPlayerCoordinates(),spot3))){
                    generateGreenKey();
                }
            }
    }


    public static void main(final String[] args) {
        int[][] exitCoord = {{5, 0}};

        int[] itemCoord1 = {1, 5};
        String itemSword = "A sword.";
        String testSwordDesc = "It's sharp.";
        Item swordItem = new Item(itemCoord1, itemSword, testSwordDesc);

        ArrayList<Item> testItemsInRoom = new ArrayList<Item>();
        String[][] testMap = new String[7][7];
        for (int index = 0; index < 7; index++) {
            for (int innerIndex = 0; innerIndex < 7; innerIndex++) {
                testMap[index][innerIndex] = "U";
            }
        }

        GreenKeyRoom testroom3 = new GreenKeyRoom(exitCoord, testItemsInRoom, testMap);
        testroom3.deleteLayout();
        testroom3.createLayout();

        testroom3.addItemToRoom(swordItem, itemCoord1);
        testroom3.populateRoom();
        testroom3.displayLayout();
        for (Item items : testItemsInRoom){
            System.out.println(items.getItemName());
        }
        System.out.println("after");
        //what map should look like after key generated, the S needs to be able to be taken first though.
        testroom3.generateGreenKey();
        testroom3.displayLayout();

        for (Item items : testItemsInRoom){
            System.out.println(items.getItemName());
        }
    }

}