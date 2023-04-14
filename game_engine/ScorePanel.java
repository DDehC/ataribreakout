package game_engine;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;

public class ScorePanel extends JPanel {
    private int score;
    Bricks bricks;

    public ScorePanel() {
        super();
        this.score = 0;
    }

    public void setScore(int score) {
        this.score = score;
        repaint();
    }

    protected void paintComponent(Graphics arg0) {
        super.paintComponent(arg0);
		Graphics2D g = (Graphics2D)arg0;
        g.setColor(Color.WHITE);
        g.setFont(new Font("sans-serif", Font.BOLD, 16));
        g.drawString("Score: " + bricks.getScore(), 10, 20);
    }
}
