package game_engine;
import java.awt.*;
import java.awt.Color;
import java.awt.Graphics2D;
import java.util.*;
import game_engine.Consts;

public class Game {
	Player player;
	Ball ball;
	Bricks bricks;
	Score score;

	public Game(GameBoard board) {
		bricks = new Bricks(5, 10);
		player = new Player(350, 600 - 30, 100, 10);
		ball = new Ball(395, 450, 15, 15, bricks);
		score = new Score(bricks);
	} 

	public void update(Keyboard keyboard) {
		player.update(keyboard);
		ball.update(keyboard);
		if(ball.intersect(player)) {
			ball.reverseY();
			ball.speedup();
		}
	}

	public void draw(Graphics2D graphics) {
		bricks.draw(graphics);
		score.drawScore(graphics);
		player.draw(graphics);
		ball.draw(graphics);
		score.win(graphics);
		score.loss(graphics);
		}
}
