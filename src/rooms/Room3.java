package rooms;

import theitems.Item;
import theobstacles.Obstacle;
import theplayer.Player;

import java.util.ArrayList;


public class Room3 extends Room{

    private String[][] map3;
    private int[] rope = {1, 1};
    private int[] key = {3, 1};
    private int[] spot = {1 ,2, 2, 2, 2,1};

    public Room3(int[][] exitCoordinates, ArrayList<Item> items, String[][] map) {
        super(exitCoordinates, items, map);
        this.map3 = map;
    }
    protected void createitems (){
        for (Item items : getItemsInRoom()) {
            if (!items.getItemName().equals("A green key.")) {
                this.map3[items.getItemCoordinate()[0]][items.getItemCoordinate()[1]] = "S";
            }
        }
        this.map3[this.getExitCoordinate()[0][0]][this.getExitCoordinate()[0][1]] = "D";
        this.map3[rope[1]][rope[1]] = "R";
    }

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

    protected void cutRope(Player thePlayer) {
        int[] keycoordinate = {3, 1};
        for (Item itemInventory : thePlayer.getInventory()) {
            if (itemInventory.getItemName().equals("A sword.") && (thePlayer.getPlayerCoordinates() == spot)){
                this.map3[key[3]][key[1]] = "K";
                this.map3[rope[1]][rope[1]] = " ";
                for (Item itemInRoom : this.getItemsInRoom()) {
                    if (itemInRoom.getItemName().equals("A green key.")) {
                        itemInRoom.setItemCoordinate(keycoordinate);
                    }
                }
            }
        }
    }


    public static void main(final String[] args) {
        int[][] exitCoord = {{5, 0}};

        int[] itemCoord1 = {1, 5};
        String itemSword = "A sword.";
        String testSwordDesc = "It's sharp.";
        Item swordItem = new Item(itemCoord1, itemSword, testSwordDesc);

        int[] itemkeyCoord = {0, 0};
        String itemGreenKey = "A green key.";
        String keyDesc = "It's a green key.";
        Item keyItem = new Item(itemkeyCoord, itemGreenKey, keyDesc);

        ArrayList<Item> testItemsInRoom = new ArrayList<Item>();
        String[][] testMap = new String[7][7];
        for (int index = 0; index < 7; index++) {
            for (int innerIndex = 0; innerIndex < 7; innerIndex++) {
                testMap[index][innerIndex] = "U";
            }
        }

        Room3 testroom3 = new Room3(exitCoord, testItemsInRoom, testMap);
        testroom3.deleteLayout();
        testroom3.createLayout();

        testroom3.addItemToRoom(swordItem, itemCoord1);
        testroom3.addItemToRoom(keyItem, itemkeyCoord);
        testroom3.createitems();
        testroom3.displayLayout();

        for (Item items : testItemsInRoom){
            System.out.println(items.getItemName());
        }
    }

}
