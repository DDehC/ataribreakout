package game_engine;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Rectangle;

public class Bricks {

	Ball ball;
    private int brickRows;
    private int brickColumns;
    private int brickWidth = 77;
    private int brickHeight = 20;
    public int[][] map;
    public int score = 0;
    public int brickCount = brickRows * brickColumns;

    public Bricks(int brickRows, int brickColumns) {
        this.brickRows = brickRows;
        this.brickColumns = brickColumns;
        map = new int[brickRows][brickColumns];
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[0].length; j++) {
                map[i][j] = 1;
                brickCount = brickRows * brickColumns;
            }
        }
    }
    
    private boolean gameWon = false;
    private boolean gameLost = false;

    public void draw(Graphics2D graphics) {
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[0].length; j++) {
                if (map[i][j] > 0) {
                    graphics.setColor(MyColor.columbia);
                    graphics.fillRect(15 + j * brickWidth, i * brickHeight + 50, brickWidth, brickHeight);
                    graphics.setColor(Color.BLACK);
                    graphics.drawRect(15 + j * brickWidth, i * brickHeight + 50, brickWidth, brickHeight);
                }
            }
        }
    }

    public boolean checkCollision(int ballPositionX, int ballPositionY, int ballXDirection, int ballYDirection) {
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[0].length; j++) {
                if (map[i][j] > 0) {
                    int brickX = 15 + j * brickWidth;
                    int brickY = i * brickHeight + 50;
                    int brickWidth = this.brickWidth;
                    int brickHeight = this.brickHeight;

                    Rectangle brickRectangle = new Rectangle(brickX, brickY, brickWidth, brickHeight);
                    Rectangle ballRectangle = new Rectangle(ballPositionX, ballPositionY, 20, 20);

                    if (ballRectangle.intersects(brickRectangle)) {
                        map[i][j] = 0;
                        score+=5;
                        brickCount--;   
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
    
	 public void win(Graphics2D graphics) {
    	 if (brickCount == 0) {
             graphics.setColor(Color.WHITE);
             graphics.setFont(new Font("sans-serif", Font.BOLD, 32));
             graphics.drawString("Level Complete! Hightscore: "+ brickCount, (700/2) - 300, 300);
             ball.levelComplete();
         }
    }
	
	/* public void loss(Graphics2D graphics) {
	    	if(ballPositionY == Consts.FRAME_HEIGHT) {
	    		 graphics.setColor(Color.red);
	             graphics.setFont(new Font("sans-serif", Font.BOLD, 32));
	             graphics.drawString("Game Over! Highscore: "+ bricks.getballY(), (700/2) - 200, 300);		
	    	}
	    }
    */

}
