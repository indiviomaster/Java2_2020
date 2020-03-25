package lesson1;

public class Trails {
    public static void main(String[] args) {

        Player [] players = {new Cat(4, 4),new Robot(8,8),new Human(2,10)};
        Barrier [] tracks = {new Track(2), new Wall(3), new Wall(5),new Track(4), new Wall(2),new Track(8)};

        for(int j=0; j<players.length; j++) {
            System.out.println(players[j].toString());
            for (int i = 0; i < tracks.length; i++) {
                if (tracks[i].setPlayer(players[j])==1) break;
            }
        }

    }
}

