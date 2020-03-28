package lesson1;

public class Track extends Barrier {
    double length;

    @Override
    public String toString() {
        return "Дорожка длиной = "+ length;
    }

    public void setLength(double length) {
        this.length = length;
    }

    public double getLength() {
        return length;
    }
    public int setPlayer(Player player){
        if(player.getRunningDistance()>=this.length) {
            player.run();
            return 0;
        }
        else{
            System.out.println("Не пробегу!");
            return 1;
        }
    }


    public Track(double length) {
        this.length = length;

    }
}
