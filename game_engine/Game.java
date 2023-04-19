package game_engine;

import game_engine.Consts;
import java.io.*;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Timer;
import java.util.TimerTask;

public class Game {
    Player player;
    Ball ball;
    Bricks bricks;
    HighScoreList highscorelist;
    int ballsLost;
    int ballCount;
    int score;
    boolean gameComplete = false;

    public Game(GameBoard board) {
        bricks = new Bricks(1, 9);
        player = new Player(350, 600 - 30, 100, 10);
        ball = createBall();
        ballsLost = 0;
        ballCount = 3;
    }

    public void update(Keyboard keyboard) {
        player.update(keyboard);
        if (ball == null && keyboard.isKeyDown(Key.Space) && ballsLost < 3) {
            ball = createBall();
        }
        if (ball != null) {
            ball.update(keyboard);
            if (ball.intersect(player)) {
                ball.reverseY();
                ball.speedup();
            }
            if (ball.getY() >= Consts.FRAME_HEIGHT) {
                ball = null;
                ballsLost++;
                ballCount--;
            }
        }
    }

    public void draw(Graphics2D graphics) {
        bricks.draw(graphics);
        bricks.drawScore(graphics);
        player.draw(graphics);
        if (ball != null) {
            ball.draw(graphics);
        } else {
            if (ballsLost < 3) {
                graphics.setColor(Color.red);
                graphics.setFont(new Font("sans-serif", Font.BOLD, 20));
                graphics.drawString(ballCount + " balls left", 350, 450);
                graphics.setColor(Color.white);
                graphics.drawString("Press spacebar for a new ball", 270, 470);
            }
            if (ballCount == 0) {
                graphics.setColor(Color.red);
                graphics.setFont(new Font("atari", Font.PLAIN, 40));
                graphics.drawString("Game Over!", 300, 350);
                graphics.drawString("Your score: " + bricks.getScore(), 290, 400);
            }
        }
        if (bricks.gamecomplete) {
            graphics.setColor(Color.green);
            graphics.setFont(new Font("atari", Font.PLAIN, 40));
            graphics.drawString("Level Complete!", 270, 350);
            graphics.drawString("Your score: " + bricks.getScore(), 290, 400);
            ball = null;
            graphics.setColor(Color.black);
            graphics.fillRect(250, 430, 400, 80);
            gameComplete = true;
        }
    }
 
    private Ball createBall() {
        return new Ball(395, 450, 17, 17, bricks);
    }
}
