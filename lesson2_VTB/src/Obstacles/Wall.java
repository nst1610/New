package Obstacles;

public class Wall implements Obstacle{

    private final int HIGH;

    public Wall(int high){
        HIGH = high;
    }

    public int getHigh(){
        return HIGH;
    }
}
