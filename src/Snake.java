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

    private Apple[] apples = new Apple[7];

    private int points;

    int snakeLength = xIntegers.length;

    public Snake() {

        StdDraw.clear(StdDraw.GREEN);
        StdDraw.setXscale(0, WIDTH);
        StdDraw.setYscale(0, HEIGHT);

        StdDraw.setPenColor(255,255,255);
    }
    private void checkApple() {
        for (int i = 0; i < apples.length; i ++) {
            if (xIntegers[0] == apples[i].getX() && yIntegers[0] == apples[i].getY()) {
                points++;
                draw();
            }
        }
    }
    private void draw() {
        for (Apple apple : apples) {
            StdDraw.picture(apple.getX(), apple.getY(), "Apple.png");
        }

        for (int i = 0; i < xIntegers.length; i++) {
            StdDraw.picture(xIntegers[i], yIntegers[i], "Snake_body.webp");
        }
        StdDraw.picture(xIntegers[0], yIntegers[0], "Snake.png");
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
        for(int i = snakeLength; i >= 1; i--) {
            xIntegers[i] = xIntegers[i - 1];
            yIntegers[i] = yIntegers[i - 1];
        }
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

    private void checks() {
        checkKey();
        move();
        draw();
        checkApple();    }
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
