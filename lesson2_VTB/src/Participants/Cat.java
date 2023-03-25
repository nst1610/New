package Participants;

import Obstacles.RaceTrack;
import Obstacles.Wall;

public class Cat implements Participant {

    private String name;
    private int maxDistance;
    private int maxHigh;
    private boolean status = true;

    public Cat(String name, int maxDistance, int maxHigh){
        this.name = name;
        this.maxDistance = maxDistance;
        this.maxHigh = maxHigh;
    }

    @Override
    public void run(RaceTrack raceTrack) {
        if (status == true){
            if(raceTrack.getDistance() <= maxDistance){
                System.out.println(name + " преодолел беговую дорожку длиной " + raceTrack.getDistance() + " м.");
            }else {
                System.out.println(name + " не смог преодолеть беговую дорожку длиной " + raceTrack.getDistance() + " м.");
                status = false;
            }
        }
    }

    @Override
    public void jump(Wall wall) {
        if (status == true){
            if(wall.getHigh() <= maxHigh){
                System.out.println(name + " преодолел стену высотой " + wall.getHigh() + " м.");
            }else {
                System.out.println(name + " не смог преодолеть стену высотой " + wall.getHigh() + " м.");
                status = false;
            }
        }
    }
}
