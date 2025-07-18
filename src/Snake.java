import java.awt.*;
import java.awt.event.KeyEvent;

public class Snake {
    private final int WIDTH = 512;
    private final int HEIGHT = 512;

    private int[] xIntegers = new int[WIDTH*HEIGHT];
    private int[] yIntegers= new int[WIDTH*HEIGHT];

    private final int left = KeyEvent.VK_LEFT;
    private final int up = KeyEvent.VK_UP;
    private final int down = KeyEvent.VK_DOWN;
    private final int right = KeyEvent.VK_RIGHT;

    private boolean leftDirection = false;
    private boolean rightDirection = false;
    private boolean upDirection = false;
    private boolean downDirection = false;

    private boolean inGame = true;

    private Apple[] apples = new Apple[3];

    private int points = 0;

    private boolean firstMove = false;

    int snakeLength = 15;

    private final Font endGame = new Font("Times New Roman", Font.BOLD, 32);


    public Snake() {
        xIntegers[0] = 256;
        yIntegers[0] = 256;

        StdDraw.clear(StdDraw.GREEN);
        StdDraw.setXscale(0, WIDTH);
        StdDraw.setYscale(0, HEIGHT);
        StdDraw.setPenColor(StdDraw.GREEN);
        StdDraw.picture(xIntegers[0], yIntegers[0], "Snake head.png", 40, 40);


        for (int i = 0; i < 3; i++) {
            apples[i] = new Apple(1);
        }
        for (int i = 0; i < apples.length; i++) {
            StdDraw.picture(apples[i].getX(), apples[i].getY(), "Apple.png", 15,15);
        }

        StdDraw.setPenColor(255,255,255);

        gameStart();
    }
    private void checkApple() {
        for (int i = 0; i < apples.length; i ++) {
            if (xIntegers[0] == apples[i].getX() && yIntegers[0] == apples[i].getY()) {
                points++;
                snakeLength++;
                draw();
            }
        }
    }

    private void gameOver() {
        StdDraw.setPenColor(StdDraw.BLACK);
        StdDraw.setFont(endGame);
        StdDraw.text(256, 256, "Game Over");
    }

    private void collisonDetection() {
        if (xIntegers[0] <= 0 || xIntegers[0] >= 512) {
            inGame = false;
            gameOver();
        }

        if (yIntegers[0] <= 0 || yIntegers[0] >= 512) {
            inGame = false;
            gameOver();
        }

        for (int i = 2; i < snakeLength; i++){
            if (xIntegers[0] == xIntegers[i] && yIntegers[0] == yIntegers[i]) {
                inGame = false;
                gameOver();
            }
        }
    }

    private void draw() {
        for (int i = 0; i < apples.length; i++) {
            StdDraw.picture(apples[i].getX(), apples[i].getY(), "Apple.png",10, 10);
        }

        for (int i = 1; i < snakeLength; i++) {
            StdDraw.picture(xIntegers[i], yIntegers[i], "Snake head.png", 40, 40);
        }
        StdDraw.picture(xIntegers[0], yIntegers[0], "Snake head.png", 40, 40);
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
        if (!upDirection && downDirection == true) {
            yIntegers[0] = yIntegers[0] - 20;
        }
        else if (!downDirection && upDirection == true) {
            yIntegers[0] = yIntegers[0] + 20;
        }

        else if (!leftDirection && rightDirection == true) {
            xIntegers[0] = xIntegers[0] + 20;
        }

        else if (!rightDirection && leftDirection == true) {
            xIntegers[0] = xIntegers[0] - 20;
        }
        for(int i = snakeLength-1; i >= 1; i--) { // head is not working properly
            xIntegers[i] = xIntegers[i - 1];
            yIntegers[i] = yIntegers[i - 1];
        }
    }

    private void checks() {
        checkKey();
        move();
        draw();
        checkApple();
        collisonDetection();
    }

    public void gameStart() {

        while (inGame) {
            if (StdDraw.isKeyPressed(left) || StdDraw.isKeyPressed(right) || StdDraw.isKeyPressed(up) || StdDraw.isKeyPressed(down)) {
                checks();
                firstMove = true;
            }
            while (firstMove) {
                StdDraw.show(50);
                StdDraw.clear(StdDraw.GREEN);
                checks();
            }
        }
    }
}
