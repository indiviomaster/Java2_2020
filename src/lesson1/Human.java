package lesson1;

public class Human implements Player {
    @Override
    public String toString() {
        return "Человек максиальная высота прыжка = "+jumpingHeight+ " максимальная дальность бега = "+ runningDistance;
    }

    public void setJumpingHeight(double jumpingHeight) {
        this.jumpingHeight = jumpingHeight;
    }

    public void setRunningDistance(double runningDistance) {
        this.runningDistance = runningDistance;
    }

    @Override
    public double getJumpingHeight() {
        return jumpingHeight;
    }
    @Override
    public double getRunningDistance() {
        return runningDistance;
    }

    double jumpingHeight;
    double runningDistance;
    public Human(double jumpingHeight, double runningDistance) {
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
}
