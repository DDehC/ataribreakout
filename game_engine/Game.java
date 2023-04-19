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

import javax.swing.JOptionPane;

public class Game {
    Player player;
    Ball ball;
    Bricks bricks;
    HighScoreList highscorelist;
    LatestRuns latestruns;
    int ballsLost;
    int ballCount;
    int score;
    private boolean gameComplete = false;
    private boolean gameUpdateExecuted = false;

    public Game(GameBoard board) {
        bricks = new Bricks(1, 9);
        player = new Player(350, 600 - 30, 100, 10);
        ball = createBall();
        ballsLost = 0;
        ballCount = 3;
        
        highscorelist = new HighScoreList();
        latestruns = new LatestRuns();
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
        gameupdate();
    }
    
    public void gameupdate() {
    	if(ballCount == 0 || bricks.gamecomplete) {
        	gameUpdateExecuted = true;
        	while(Consts.stateOfGame < 0) {
        		
            	Consts.name = JOptionPane.showInputDialog(null, "Please enter a 3 letter ID", "Info", JOptionPane.INFORMATION_MESSAGE);
	        	if(Consts.name == null) {
	        		JOptionPane.showInputDialog(null, "No input recieved", "Info");
	        	} else if (Consts.name.length() != 3) {
	        		JOptionPane.showMessageDialog(null, "Please enter a name ID consisting of 3 letters!", "Error", JOptionPane.INFORMATION_MESSAGE);
	        	} else if(Consts.name.length() == 3) {
	        		highscorelist.newScore(Consts.name.toUpperCase(),bricks.getScore());
	        		JOptionPane.showMessageDialog(null, "Score submitted, press OK to restart the game!", "Success", JOptionPane.INFORMATION_MESSAGE);
	        		Consts.stateOfGame++;
	        		
	        		restartGame();
	        	}
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
    
    public void restartGame() {
    	bricks = new Bricks(1, 9);
        player = new Player(350, 600 - 30, 100, 10);
        ball = createBall();
        ballsLost = 0;
        ballCount = 3;
        gameComplete = false;
        gameUpdateExecuted = false; 
    }
}
