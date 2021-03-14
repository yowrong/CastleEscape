package theplayer;

import rooms.HallwayRoom;
import rooms.Room;
import rooms.BlueKeyRoom;
import theitems.Item;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Player {

    Scanner scan = new Scanner(System.in);
    private String playerName;
    private Room currentRoom;
    private Room[] listRooms;
    private ArrayList<Item> inventory;
    private int[] playerCoordinates;

    public Player(String playerName, Room[] listRooms, int[] playerCoordinates) {
        this.playerName = playerName;
        this.listRooms = listRooms;
        this.playerCoordinates = playerCoordinates;
        this.inventory = new ArrayList<>();
    }

    public Room getCurrentRoom() {
        return currentRoom;
    }

    public String getPlayerName() {
        return playerName;
    }

    public ArrayList<Item> getInventory() {
        return this.inventory;
    }

    public int[] getPlayerCoordinates() {
        return playerCoordinates;
    }

    public void setPlayerCoordinates(int[] playerCoordinates) {
        this.playerCoordinates = playerCoordinates;
    }

    public void setCurrentRoom(Room currentRoom) {
        this.currentRoom = currentRoom;
    }

    public void playerMove(String direction) {
        int[] playerOldPos = this.getPlayerCoordinates();

        if (direction.equals("north") && !currentRoom.getMap()[playerOldPos[0] - 1][playerOldPos[1]].equals("X")) {
            int[] playerNewPos = {playerOldPos[0] - 1,playerOldPos[1]};
            currentRoom.updatePlayerPos(playerOldPos, playerNewPos);
            this.getPlayerCoordinates()[0] -= 1;
        }

        else if (direction.equals("south") && !currentRoom.getMap()[playerOldPos[0] + 1][playerOldPos[1]].equals("X")) {

            int[] playerNewPos = {playerOldPos[0] + 1,playerOldPos[1]};
            currentRoom.updatePlayerPos(playerOldPos, playerNewPos);
            this.getPlayerCoordinates()[0] += 1;
        }

        else if (direction.equals("west") && !currentRoom.getMap()[playerOldPos[0]][playerOldPos[1] - 1].equals("X")) {
            int[] playerNewPos = {playerOldPos[0],playerOldPos[1] - 1};
            currentRoom.updatePlayerPos(playerOldPos, playerNewPos);
            this.getPlayerCoordinates()[1] -= 1;
        }

        else if (direction.equals("east") && !currentRoom.getMap()[playerOldPos[0]][playerOldPos[1] + 1].equals("X")) {
            int[] playerNewPos = {playerOldPos[0],playerOldPos[1] + 1};
            currentRoom.updatePlayerPos(playerOldPos, playerNewPos);
            this.getPlayerCoordinates()[1] += 1;
        }

        else {
            System.out.println("There's a wall there");
        }

    }

    public void playerPush(String direction) {
        int[] playerOldPos = this.getPlayerCoordinates();
        int[] obstacleOldPos = this.currentRoom.getObstacle().getObstacleCoordinate();

        if (direction.equals("north") && !currentRoom.getMap()[playerOldPos[0] - 2][playerOldPos[1]].equals("X")) {
            if (currentRoom.getMap()[playerOldPos[0] - 1][playerOldPos[1]].equals("O")) {
                int[] playerNewPos = {playerOldPos[0] - 1, playerOldPos[1]};
                int[] obstacleNewPos = {obstacleOldPos[0] - 1, obstacleOldPos[1]};
                currentRoom.updatePlayerPos(playerOldPos, playerNewPos);
                currentRoom.updateObstaclePos(obstacleOldPos, obstacleNewPos);
                this.getPlayerCoordinates()[0] -= 1;
                this.currentRoom.getObstacle().getObstacleCoordinate()[0] -= 1;
            }
        }

        else if (direction.equals("south") && !currentRoom.getMap()[playerOldPos[0] + 2][playerOldPos[1]].equals("X")) {
            if (currentRoom.getMap()[playerOldPos[0] + 1][playerOldPos[1]].equals("O")) {
                int[] playerNewPos = {playerOldPos[0] + 1, playerOldPos[1]};
                int[] obstacleNewPos = {obstacleOldPos[0] + 1, obstacleOldPos[1]};
                currentRoom.updatePlayerPos(playerOldPos, playerNewPos);
                currentRoom.updateObstaclePos(obstacleOldPos, obstacleNewPos);
                this.getPlayerCoordinates()[0] += 1;
                this.currentRoom.getObstacle().getObstacleCoordinate()[0] += 1;
            }
        }

        else if (direction.equals("west") && !currentRoom.getMap()[playerOldPos[0]][playerOldPos[1] - 2].equals("X")) {
            if (currentRoom.getMap()[playerOldPos[0]][playerOldPos[1] - 1].equals("O")) {
                int[] playerNewPos = {playerOldPos[0], playerOldPos[1] - 1};
                int[] obstacleNewPos = {obstacleOldPos[0], obstacleOldPos[1] - 1};
                currentRoom.updatePlayerPos(playerOldPos, playerNewPos);
                currentRoom.updateObstaclePos(obstacleOldPos, obstacleNewPos);
                this.getPlayerCoordinates()[1] -= 1;
                this.currentRoom.getObstacle().getObstacleCoordinate()[1] -= 1;
            }
        }

        else if (direction.equals("east") && !currentRoom.getMap()[playerOldPos[0]][playerOldPos[1] + 2].equals("X")) {
            if (currentRoom.getMap()[playerOldPos[0]][playerOldPos[1] + 1].equals("O")) {
                int[] playerNewPos = {playerOldPos[0], playerOldPos[1] + 1};
                int[] obstacleNewPos = {obstacleOldPos[0], obstacleOldPos[1] + 1};
                currentRoom.updatePlayerPos(playerOldPos, playerNewPos);
                currentRoom.updateObstaclePos(obstacleOldPos, obstacleNewPos);
                this.getPlayerCoordinates()[1] += 1;
                this.currentRoom.getObstacle().getObstacleCoordinate()[1] += 1;
            }

        }

        else {
            System.out.println("That doesn't work.");
        }
    }

    public void playerPull(String direction) {
        int[] playerOldPos = this.getPlayerCoordinates();
        int[] obstacleOldPos = this.currentRoom.getObstacle().getObstacleCoordinate();

        if (direction.equals("north") && !currentRoom.getMap()[playerOldPos[0] - 1][playerOldPos[1]].equals("X")) {
            if (currentRoom.getMap()[playerOldPos[0] + 1][playerOldPos[1]].equals("O")) {
                int[] playerNewPos = {playerOldPos[0] - 1, playerOldPos[1]};
                int[] obstacleNewPos = {obstacleOldPos[0] - 1, obstacleOldPos[1]};
                currentRoom.updatePlayerPos(playerOldPos, playerNewPos);
                currentRoom.updateObstaclePos(obstacleOldPos, obstacleNewPos);
                this.getPlayerCoordinates()[0] -= 1;
                this.currentRoom.getObstacle().getObstacleCoordinate()[0] -= 1;
            }
        }

        else if (direction.equals("south") && !currentRoom.getMap()[playerOldPos[0] + 1][playerOldPos[1]].equals("X")) {
            if (currentRoom.getMap()[playerOldPos[0] - 1][playerOldPos[1]].equals("O")) {
                int[] playerNewPos = {playerOldPos[0] + 1, playerOldPos[1]};
                int[] obstacleNewPos = {obstacleOldPos[0] + 1, obstacleOldPos[1]};
                currentRoom.updatePlayerPos(playerOldPos, playerNewPos);
                currentRoom.updateObstaclePos(obstacleOldPos, obstacleNewPos);
                this.getPlayerCoordinates()[0] += 1;
                this.currentRoom.getObstacle().getObstacleCoordinate()[0] += 1;
            }
        }

        else if (direction.equals("west") && !currentRoom.getMap()[playerOldPos[0]][playerOldPos[1] - 1].equals("X")) {
            if (currentRoom.getMap()[playerOldPos[0]][playerOldPos[1] + 1].equals("O")) {
                int[] playerNewPos = {playerOldPos[0], playerOldPos[1] - 1};
                int[] obstacleNewPos = {obstacleOldPos[0], obstacleOldPos[1] - 1};
                currentRoom.updatePlayerPos(playerOldPos, playerNewPos);
                currentRoom.updateObstaclePos(obstacleOldPos, obstacleNewPos);
                this.getPlayerCoordinates()[1] -= 1;
                this.currentRoom.getObstacle().getObstacleCoordinate()[1] -= 1;
            }
        }

        else if (direction.equals("east") && !currentRoom.getMap()[playerOldPos[0]][playerOldPos[1] + 1].equals("X")) {
            if (currentRoom.getMap()[playerOldPos[0]][playerOldPos[1] - 1].equals("O")) {
                int[] playerNewPos = {playerOldPos[0], playerOldPos[1] + 1};
                int[] obstacleNewPos = {obstacleOldPos[0], obstacleOldPos[1] + 1};
                currentRoom.updatePlayerPos(playerOldPos, playerNewPos);
                currentRoom.updateObstaclePos(obstacleOldPos, obstacleNewPos);
                this.getPlayerCoordinates()[1] += 1;
                this.currentRoom.getObstacle().getObstacleCoordinate()[1] += 1;
            }

        }

        else {
            System.out.println("There's a wall in the way.");
        }
    }

    public void placeItem(String itemName) {
        for (Item itemInInventory : inventory) {
            if (itemName.equals(itemInInventory.getItemName())) {
                itemInInventory.setItemCoordinate(this.getPlayerCoordinates());
                currentRoom.addItemToRoom(itemInInventory, itemInInventory.getItemCoordinate());
                inventory.remove(itemInInventory);
            }
        }
    }

    public void pickUpItem() {
        Item itemToRemove = null;
        boolean itemExists = false;
        for (Item itemInRoom : currentRoom.getItemsInRoom()) {
            if (Arrays.equals(this.getPlayerCoordinates(), itemInRoom.getItemCoordinate())) {
                this.getInventory().add(itemInRoom);
                itemToRemove = itemInRoom;
                itemExists = true;
            }
        }

        if (itemExists) {
            currentRoom.getItemsInRoom().remove(itemToRemove);
        }
    }

    public void userAction(String userInput) {
        if (userInput == "move north") {
            playerMove("north");
        } else if (userInput == "move south") {
            playerMove("south");
        } else if (userInput == "move west") {
            playerMove("west");
        } else if (userInput == "move east") {
            playerMove("east");
        } else if (userInput == "push north") {
            playerPush("north");
        } else if (userInput == "push south") {
            playerPush("south");
        } else if (userInput == "push west") {
            playerPush("west");
        } else if (userInput == "push east") {
            playerPush("east");
        } else if (userInput == "pull north") {
            playerPull("north");
        } else if (userInput == "pull south") {
            playerPull("south");
        } else if (userInput == "pull west") {
            playerPull("west");
        } else if (userInput == "pull east") {
            playerPull("east");
        } else if (userInput == "place item") {
            System.out.println("Enter the name of the item");
            placeItem(scan.nextLine());
        } else if (userInput == "pick up item") {
            pickUpItem();
        } else if (userInput == "exit" || userInput == "open door") {
            this.getCurrentRoom().exitRoom(this.getPlayerCoordinates(), this, this.listRooms);
        } else if (this.getCurrentRoom() == this.listRooms[0]) {
            if (userInput == "interact") {
                this.listRooms[0].jewelSort(this);
            }
        } else if (this.getCurrentRoom() == this.listRooms[1]) {
            if (userInput == "interact") {
                this.listRooms[1].cutRope(this);
            }
        } else {
            System.out.println("command not recognized (lowercase commands only)");
        }
    }

//    public void openDoor() {
//        for (int i = 0; i < currentRoom.getExitCoordinate().length; i++) {
//            for (int j = 0; j < currentRoom.getExitCoordinate()[i].length; j++) {
//                if ((Math.abs(this.getPlayerCoordinates()[0] - currentRoom.getExitCoordinate()[i][j]) == 1
//                    && Math.abs(this.getPlayerCoordinates()[1] - currentRoom.getExitCoordinate()[i][j]) == 0)
//                    || (Math.abs(this.getPlayerCoordinates()[0] - currentRoom.getExitCoordinate()[i][j]) == 0
//                    && Math.abs(this.getPlayerCoordinates()[1] - currentRoom.getExitCoordinate()[i][j]) == 1)) {
//                    System.out.println("You opened the door and enter the new room");
//                    this.setCurrentRoom()
//                }
//            }
//        }
//    }
}
