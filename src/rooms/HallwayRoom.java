package rooms;

import theitems.Item;
import theobstacles.Obstacle;
import theplayer.Player;

import java.util.ArrayList;
import java.util.Arrays;

public class HallwayRoom extends Room{

    private int[] escapeCoordinate;
    Obstacle crate;
    private int[] pressPlate = {3, 3};
    private boolean barsRetracted = false;
    private boolean eventTrigger = false;


    private String roomDescription = "After entering the hallway, the torches light up in  blue flames front of thou"
            + "The door behind you disappears and five new doors appear with metal bars blocking each exit"
            + "You notice there is a crate on the ground, seemingly out of place.";

    public HallwayRoom(int[][] exitCoordinates, ArrayList<Item> items, String[][] map, Obstacle crate) {
        super(exitCoordinates, items, map);
        this.escapeCoordinate = new int[]{0, 3};
        this.crate = crate;
    }

    @Override
    public String getRoomDescription() {
        return roomDescription;
    }

    public Obstacle getObstacle() {
        return crate;
    }

    @Override
    protected void createLayout() {
        for (int index = 1; index < 6; index++) {
            for (int innerIndex = 2; innerIndex < 5; innerIndex++) {
                this.getMap()[index][innerIndex] = " ";
            }
        }
    }

    @Override
    protected void populateRoom(Player thePlayer) {
        for (int[] door : this.getExitCoordinate()) {
            this.getMap()[door[0]][door[1]] = "D";
        }
        this.getMap()[this.escapeCoordinate[0]][this.escapeCoordinate[1]] = "E";
        this.getMap()[this.pressPlate[0]][this.pressPlate[1]] = "*";
        this.getMap()[this.getObstacle().getObstacleCoordinate()[0]][this.getObstacle().getObstacleCoordinate()[1]] = "O";
        this.getMap()[thePlayer.getPlayerCoordinates()[0]][thePlayer.getPlayerCoordinates()[1]] = "P";
    }

    public boolean onPressPlate() {

        if (Arrays.equals(this.getObstacle().getObstacleCoordinate(), this.pressPlate)) {
            if (!this.barsRetracted) {
                System.out.println("The bars blocking the doors retract.");
                this.barsRetracted = true;
            }
            return true;
        } else {
            if (this.barsRetracted) {
                System.out.println("Bars extend over the doors, blocking them off.");
                this.barsRetracted = false;
            }
            return false;
        }
    }

    @Override
    public void checkEventTriggers() {
        boolean check = true;
        this.eventTrigger = this.onPressPlate();
        System.out.println(eventTrigger);
    }

    public void setEventTrigger(boolean eventTrigger) {
        this.eventTrigger = eventTrigger;
        if (this.onPressPlate()) {
            this.setEventTrigger(true);
        }
    }

    public void exitCastle(int[] playerCoord, Player thePlayer, Room[] nextRoom) {
        int count = 0;
        if (!thePlayer.getWinGame()) {
            for (Item item : thePlayer.getInventory()) {
                if (item.getItemName() == "Big Green Key") {
                    count++;
                } if (item.getItemName() == "Big Blue Key") {
                    count++;
                } if (item.getItemName() == "Big Red Key") {
                    count++;
                } if (item.getItemName() == "A sword.") {
                    count++;
                }
            }
            if (count == 4) {
                thePlayer.setWinGame(true);
                System.out.println("You win!");
            }
        }
    }

    @Override
    public void exitRoom(int[] playerCoord, Player thePlayer, Room[] nextRoom) {
        if (this.eventTrigger) {
            System.out.println("yes");
            if (Arrays.equals(playerCoord, this.getExitCoordinate()[0])) {
                thePlayer.setCurrentRoom(nextRoom[0]);
            }

            else if (Arrays.equals(playerCoord, this.getExitCoordinate()[1])){
                thePlayer.setCurrentRoom(nextRoom[1]);
            }

            else if (Arrays.equals(playerCoord, this.getExitCoordinate()[2])) {
                thePlayer.setCurrentRoom(nextRoom[3]);
            }

            else if (Arrays.equals(playerCoord, this.getExitCoordinate()[3])){
                thePlayer.setCurrentRoom(nextRoom[2]);
            }

            else {
                System.out.println("There is no door.");
            }
        }

        else {
            for (int[] exitCoord : this.getExitCoordinate()) {
                if (playerCoord == exitCoord) {
                    System.out.println("The bars prevent you from going through the door.");
                }
            }

            System.out.println("You can't go through a door.");
        }
    }
}
