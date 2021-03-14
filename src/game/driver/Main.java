package game.driver;

import rooms.BlueKeyRoom;
import theitems.Item;
import theobstacles.Obstacle;
import theplayer.Player;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        int[][] blueRmExitCoord = {{4, 6}};
        int[] blueRmObsCoord = {1, 4};
        ArrayList<Item> blueRmItems = new ArrayList<>();

        int[] playerCoord = {blueRmExitCoord[0][0], blueRmExitCoord[0][1]};

        String[][] map = new String[7][7];
        for (int index = 0; index < 7; index++) {
            for (int innerIndex = 0; innerIndex < 7; innerIndex++) {
                map[index][innerIndex] = "U";
            }
        }
        Obstacle blueRmObstacle = new Obstacle("Crate", "A moveable crate", blueRmObsCoord);

        BlueKeyRoom blueKeyRoom = new BlueKeyRoom(blueRmExitCoord, blueRmItems, map, blueRmObstacle);
        Player player = new Player("Player", blueKeyRoom, playerCoord);

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
