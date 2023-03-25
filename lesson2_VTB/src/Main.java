import Obstacles.Obstacle;
import Obstacles.RaceTrack;
import Obstacles.Wall;
import Participants.Cat;
import Participants.Human;
import Participants.Participant;
import Participants.Robot;

public class Main {

//    1. Создайте три класса Человек,
//    Кот, Робот, которые не наследуются от одного класса. Эти классы должны уметь бегать и
//    прыгать, все также с выводом информации о действии в консоль.

//    2. Создайте два класса: беговая дорожка и стена, при прохождении через которые, участники
//    должны выполнять соответствующие действия (бежать или прыгать), результат выполнения печатаем в
//    консоль (успешно пробежал, не смог пробежать и т.д.). У препятствий есть длина
//    (для дорожки) или высота (для стены), а участников ограничения на бег и прыжки.

//    3. Создайте два массив: с участниками и препятствиями, и заставьте всех участников пройти
//    этот набор препятствий. Если участник не смог пройти одно из препятствий, то дальше по
//    списку он препятствий не идет.
    public static void main(String[] args) {

        Participant[] participants = {
                new Cat("Murzik", 200, 1),
                new Human("Alex", 700, 2),
                new Robot("Robo", 400, 1)
        };

        Obstacle[] obstacles = {
                new RaceTrack(400),
                new Wall(1)
        };

        for(Participant participant : participants){
            for(Obstacle obstacle : obstacles){
                if(obstacle instanceof RaceTrack){
                    participant.run((RaceTrack) obstacle);
                }else {
                    participant.jump((Wall) obstacle);
                }
            }
        }

    }
}