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
}
