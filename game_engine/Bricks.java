package game_engine;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import javax.swing.DefaultListModel;

public class Bricks {

    Ball ball;
    Game game;
    private int brickRows;
    private int brickColumns;
    private int brickWidth = 85;
    private int brickHeight = 25;
    public int[][] map;
    public int score = 0;
    public int brickCount = brickRows * brickColumns;
    public boolean gamecomplete = false;

    public Bricks(int brickRows, int brickColumns) {
        this.brickRows = brickRows;
        this.brickColumns = brickColumns;
        this.game = game;
        map = new int[brickRows][brickColumns];
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[0].length; j++) {
                map[i][j] = 1;
                brickCount = brickRows * brickColumns;
            }
        }
    }

    public void draw(Graphics2D graphics) {
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[0].length; j++) {
                if (map[i][j] > 0) {
                    graphics.setColor(MyColor.columbia);
                    graphics.fillRect(20 + j * brickWidth, i * brickHeight + 45, brickWidth, brickHeight);
                    graphics.setStroke(new BasicStroke(2));
                    graphics.setColor(Color.BLACK);
                    graphics.drawRect(20 + j * brickWidth, i * brickHeight + 45, brickWidth, brickHeight);
                }
            }
        }
    }

    public boolean checkCollision(int ballPositionX, int ballPositionY, int ballXDirection, int ballYDirection) {
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[0].length; j++) {
                if (map[i][j] > 0) {
                    int brickX = 20 + j * brickWidth;
                    int brickY = 20 + i * brickHeight + 45;
                    int brickWidth = this.brickWidth;
                    int brickHeight = this.brickHeight;

                    Rectangle brickRectangle = new Rectangle(brickX, brickY, brickWidth, brickHeight);
                    Rectangle ballRectangle = new Rectangle(ballPositionX, ballPositionY, 20, 20);

                    if (ballRectangle.intersects(brickRectangle)) {
                        map[i][j] = 0;
                        score += 5;
                        brickCount--;
                        if (brickCount == 0) {
                            gamecomplete = true;
                        } else {
                            gamecomplete = false;
                        }
                      
                        return true;
                    }
                }
            }
        }
        return false;
    }
    public void drawScore(Graphics2D graphics) {
        graphics.setColor(Color.white);
        graphics.setFont(new Font("Sans-serif", Font.PLAIN, 20));
        graphics.drawString("Score: " + score, 10, 30);
    }
    public boolean levelcomplete(Graphics2D graphics) {
        return gamecomplete;
    }
    public int getScore() {
    	return score;
    }
}

