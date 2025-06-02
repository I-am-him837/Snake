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

    private boolean leftDirection = true;
    private boolean rightDirection = false;
    private boolean upDirection = false;
    private boolean downDirection = false;

    private boolean inGame = true;

    int snakeLength = xIntegers.length;

    public Snake() {

        StdDraw.clear(StdDraw.GREEN);
        StdDraw.setXscale(0, WIDTH);
        StdDraw.setYscale(0, HEIGHT);

        StdDraw.setPenColor(255,255,255);
    }
    private void checkKey() {
        if (!rightDirection && StdDraw.isKeyPressed(left)) {
            leftDirection = true;
            downDirection = false;
            upDirection = false;
        }

        if (!leftDirection && StdDraw.isKeyPressed(right)) {
            rightDirection = true;
            upDirection = false;
            downDirection = false;
        }

        if (!downDirection && StdDraw.isKeyPressed(up)) {
            upDirection = true;
            rightDirection = false;
            leftDirection = false;
        }

        if (!upDirection && StdDraw.isKeyPressed(down)) {
            downDirection = true;
            rightDirection = false;
            leftDirection = false;
        }
    }

    private void move() {
        for(int i = snakeLength; i > 1; i--) {
            xIntegers[i] = xIntegers[i-1];
            yIntegers[i] = yIntegers[i-1];

            if (!upDirection && downDirection == true); {
                yIntegers[0] = yIntegers[0] - 1;
            }

            if (!downDirection && upDirection == true); {
                yIntegers[0] = yIntegers[0] + 1;
            }

            if (!leftDirection && rightDirection == true); {
                xIntegers[0] = xIntegers[0] + 1;
            }

            if (!rightDirection && leftDirection == true); {
                xIntegers[0] = xIntegers[0] - 1;
            }
        }
    }

    private void checks() {
        checkKey();
        move();
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
