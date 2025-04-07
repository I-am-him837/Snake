import java.util.Random;
import java.lang.System;

public class Apple {
    private int x;
    private int y;

    private double startTime;
    private double timeLimit;
    private double endTime;

    int appleCounter; // when the snake eats the apple then the apple counter will be affected by one, this is added inside.

    Random rand = new Random();

    public Apple() {
        x = rand.nextInt(512);
        y = rand.nextInt(512);

        startTime = System.currentTimeMillis();
        endTime = 30;
        StdDraw.picture(x, y, "Apple.png");
    }
}
