import java.util.Random;
import java.lang.System;

public class Apple {
    private int difculty;
    private int x;
    private int y;

    private double startTime;
    private double timeLimit;
    private double endTime;

    Random rand = new Random();

    public Apple(int difculty) {
        this.difculty = difculty;
        x = rand.nextInt(512);
        y = rand.nextInt(512);

        startTime = System.currentTimeMillis();
        endTime = startTime + 30000;

        boolean b = true;
        if (b) {
            difculty = difculty + 1;
        }
        if (difculty > 0) {
            if ((endTime - difculty) % 3 == 0) {
                endTime = endTime - 1000;
            }
        }
        StdDraw.picture(x, y, "Apple.png");
    }
}
