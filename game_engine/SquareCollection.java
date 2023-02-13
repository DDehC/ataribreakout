package game_engine;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.util.ArrayList;

public class SquareCollection {
	private ArrayList<BlueBox> blue;
	private ArrayList<RedBox> red;
	private ArrayList<GreenBox> green;
	
	public SquareCollection(GameBoard board) {
		
		blue = new ArrayList<BlueBox>();
		red = new ArrayList<RedBox>();
		green = new ArrayList<GreenBox>();
		for(int i = 0; i < 10; i++) {
			blue.add(new BlueBox(5 + i * 80, 50, 70, 20));
		}
		for(int i = 0; i < 10; i++) {
			red.add(new RedBox(5 + i * 80, 20, 70, 20));
		}
		for(int i = 0; i < 10; i++) {
			green.add(new GreenBox(5 + i * 80, 80, 70, 20));
		}
	}
	
	public void update(Keyboard keyboard) {
		for(BlueBox Blue: blue) {
			Blue.update(keyboard); 
		}
		for(RedBox Red: red) {
			Red.update(keyboard);
		}				
		for(GreenBox Green: green) {
			Green.update(keyboard);
		}			
	}
	public void draw(Graphics2D graphics) {
		for(BlueBox Blue: blue) {
			Blue.draw(graphics);
		}
		for(RedBox Red: red) {
			Red.draw(graphics);
		}
		for(GreenBox Green: green) {
			Green.draw(graphics);
		}
	}
}


