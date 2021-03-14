package rooms;

import theitems.Item;
import theobstacles.Obstacle;
import theplayer.Player;

import java.util.ArrayList;

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
        this.getMap()[this.getObstacle().getObstacleCoordinate()[0]][this.getObstacle().getObstacleCoordinate()[1]] = "O";
        this.getMap()[this.pressPlate[0]][this.pressPlate[1]] = "*";
        this.getMap()[thePlayer.getPlayerCoordinates()[0]][thePlayer.getPlayerCoordinates()[1]] = "P";
    }

    public boolean onPressPlate() {
        if (this.getMap()[this.pressPlate[0]][this.pressPlate[1]].equals("P")
                || this.getMap()[this.pressPlate[0]][this.pressPlate[1]].equals("O")) {
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
        this.eventTrigger = this.onPressPlate();
    }

    @Override
    public void exitRoom(int[] playerCoord, Player thePlayer, Room[] nextRoom) {
        if (this.eventTrigger) {
            if (playerCoord == this.getExitCoordinate()[0]) {
                thePlayer.setCurrentRoom(nextRoom[0]);
            }

            else if (playerCoord == this.getExitCoordinate()[1]) {
                thePlayer.setCurrentRoom(nextRoom[1]);
            }

            else if (playerCoord == this.getExitCoordinate()[2]) {
                thePlayer.setCurrentRoom(nextRoom[3]);
            }

            else if (playerCoord == this.getExitCoordinate()[3]) {
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
