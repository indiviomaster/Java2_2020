package lesson1;

public class Wall extends Barrier {
    @Override
    public String toString() {
        return "Стена высотой = "+height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public double getHeight() {
        return height;
    }
    public int setPlayer(Player player){
        if(player.getJumpingHeight()>=this.height) {
            player.jump();
            return 0;
        }
        else{
            System.out.println("Не могу перепрыгнуть");
            return 1;
        }

    }
    private double height;

    public Wall( double height) {
        this.height = height;
    }
}
