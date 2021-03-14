package theobstacles;

public class Obstacle {

    private String obstacleName;
    private String obstacleDescription;
    private int[] obstacleCoordinate;

    public Obstacle(String obstacleName, String obstacleDescription, int[] obstacleCoordinate) {
        this.obstacleName = obstacleName;
        this.obstacleDescription = obstacleDescription;
        this.obstacleCoordinate = obstacleCoordinate;
    }

    public String getObstacleName() {
        return obstacleName;
    }

    public String getObstacleDescription() {
        return obstacleDescription;
    }

    public int[] getObstacleCoordinate() {
        return obstacleCoordinate;
    }

    public void setObstacleDescription(String obstacleDescription) {
        this.obstacleDescription = obstacleDescription;
    }

    public void setObstacleCoordinate(int[] obstacleCoordinate) {
        this.obstacleCoordinate = obstacleCoordinate;
    }

    public void shiftObstacle(String direction) {

        if (direction.equals("north")) {
            this.getObstacleCoordinate()[0] -=1;
        }

        else if (direction.equals("south")) {
            this.getObstacleCoordinate()[0] += 1;
        }

        else if (direction.equals("west")) {
            this.getObstacleCoordinate()[1] -= 1;
        }

        else if (direction.equals("east")) {
            this.getObstacleCoordinate()[1] += 1;
        }
    }
}
