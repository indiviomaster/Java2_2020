package lesson1;

public class Robot implements Player{
    @Override
    public String toString() {
        return "Robot maxJump = "+jumpingHeight+ " maxRun = "+ runningDistance;
    }

    double jumpingHeight;
    double runningDistance;
    public Robot(double jumpingHeight, double runningDistance) {
        this.jumpingHeight = jumpingHeight;
        this.runningDistance = runningDistance;
    }
    @Override
    public void jump() {
        System.out.println("Прыгаю через стену");
    }

    @Override
    public void run() {
        System.out.println("Бегу по дорожке");
    }

    @Override
    public double getJumpingHeight() {
        return jumpingHeight;
    }
    @Override
    public double getRunningDistance() {
        return runningDistance;
    }
}
