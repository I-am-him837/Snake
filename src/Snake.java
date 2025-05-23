import java.applet.Applet;
import java.awt.event.KeyEvent;

public class Snake extends Applet {
    private final int WIDTH = 512;
    private final int HEIGHT = 512;

    private int[] xIntegers = new int[WIDTH*HEIGHT];
    private int[] yIntegers= new int[WIDTH*HEIGHT];

    private final int left = KeyEvent.VK_LEFT;
    private final int up = KeyEvent.VK_UP;
    private final int down = KeyEvent.VK_DOWN;
    private final int right = KeyEvent.VK_RIGHT;

    private boolean inGame = true;

    public Snake() {

        StdDraw.clear(StdDraw.GREEN);
        StdDraw.setXscale(0, WIDTH);
        StdDraw.setYscale(0, HEIGHT);

        StdDraw.setPenColor(255,255,255);
    }

    public void gameStart() {
        xIntegers[0] = 256;
        yIntegers[0] = 256;

        Apple[] appleCoordinates = new Apple[20];

        while (inGame) {
            if (StdDraw.isKeyPressed(left) || StdDraw.isKeyPressed(right) || StdDraw.isKeyPressed(up) || StdDraw.isKeyPressed(down)) {
                // make checks function
            }
        }
    }
}
