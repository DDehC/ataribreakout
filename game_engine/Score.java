/*package game_engine;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import game_engine.Consts;

public class Score {
    private Bricks bricks;

    public Score(Bricks bricks) {
        this.bricks = bricks;
    }

    public void drawScore(Graphics2D graphics) {
        graphics.setColor(Color.white);
        graphics.setFont(new Font("Sans-serif", Font.PLAIN, 20));
        graphics.drawString("Score: " + bricks.getScore(), 10, 30);
    }
    
   
    
    public void loss(Graphics2D graphics) {
    	if(bricks.getballY() == true) {
    		 graphics.setColor(Color.red);
             graphics.setFont(new Font("sans-serif", Font.BOLD, 32));
             graphics.drawString("Game Over! Highscore: "+ bricks.getballY(), (700/2) - 200, 300);		
    	}
    }
}
*/