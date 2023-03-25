package Obstacles;

public class RaceTrack implements Obstacle{

    private final int DISTANCE;

    public RaceTrack(int distance){
        DISTANCE = distance;
    }

    public int getDistance(){
        return DISTANCE;
    }

}
