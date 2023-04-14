package game_engine;

import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;
import game_engine.Consts;

public class GameBoard extends JComponent {
	private final int FPS = 40; 
	private Game game;
	private Keyboard keyboard;
	public GameBoard() {
		keyboard = new Keyboard();
		game = new Game(this);
		
		JComponent scorePanel;
		JComponent JPanel = scorePanel = new JPanel();
		scorePanel.setBackground(Color.red);
		scorePanel.setBounds(Consts.FRAME_WIDTH, 0, 150, Consts.FRAME_HEIGHT);
		this.add(scorePanel);
		
	}
	
	 @Override
	    public Dimension getPreferredSize() {
	        return new Dimension(Consts.FRAME_WIDTH + 150, Consts.FRAME_HEIGHT);
	    }

	@Override
	protected void paintComponent(Graphics arg0) {
		super.paintComponent(arg0);
		Graphics2D graphics = (Graphics2D)arg0;
		graphics.setColor(Color.black);
		graphics.fillRect(0, 0, getWidth(), getHeight());
			
		game.draw(graphics);
	}
	
	@Override
	protected void processKeyEvent(KeyEvent e) {
		super.processKeyEvent(e);
		if (e.getID() == KeyEvent.KEY_PRESSED)
			keyboard.processKeyEvent(e.getKeyCode(), true);
		else if (e.getID() == KeyEvent.KEY_RELEASED)
			keyboard.processKeyEvent(e.getKeyCode(), false);
	}

	public void start() {
		while(true) {
			game.update(keyboard);
			try {
				Thread.sleep(1000 / FPS); //Throttle thread
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			this.repaint();
		}
	}
}
