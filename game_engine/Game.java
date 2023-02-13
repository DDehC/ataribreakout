package game_engine;
import java.awt.*;
import java.awt.Color;
import java.awt.Graphics2D;
import java.util.*;
import game_engine.Consts;

public class Game {
	Player player;
	Ball ball;
	SquareCollection squareCollection;

	public Game(GameBoard board) {
		init(board);
		player = new Player(350, 600 - 30, 100, 10);
		ball = new Ball(395, 450, 15, 15);
	} 

	public void init(GameBoard board) {
		squareCollection = new SquareCollection (board);
	}
	public void update(Keyboard keyboard) {
		player.update(keyboard);
		ball.update(keyboard);
		squareCollection.update(keyboard);
		if(ball.intersect(player)) {
			ball.reverseX();
			ball.reverseY();
			ball.speedup();
		}
	}

	public void draw(Graphics2D graphics) {
		squareCollection.draw(graphics);
		player.draw(graphics);
		ball.draw(graphics);
		}
}
