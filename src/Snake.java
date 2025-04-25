import java.applet.Applet;

public class Snake extends Applet {
    private final int WIDTH = 512;
    private final int HEIGHT = 512;

    int[] xIntegers = new int[]

    public Snake() {

        StdDraw.clear(StdDraw.GREEN);
        StdDraw.setXscale(0, WIDTH);
        StdDraw.setYscale(0, HEIGHT);

        StdDraw.setPenColor(255,255,255);
    }

    public void gameStart() {

    }
}
