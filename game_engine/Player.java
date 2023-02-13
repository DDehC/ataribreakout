package game_engine;
import java.awt.*;

public class Player extends Sprite {
    public Player(int x, int y, int width, int height) {
        super(x, y, width, height);
    }

    @Override
    public void update(Keyboard keyboard) {
        if (keyboard.isKeyDown(Key.Right)) {
            if (getX() + 10 + 100 <= 800) {
                setX(getX() + 10);
            }
        }
        if (keyboard.isKeyDown(Key.Left)) {
            if (getX() - 10 >= 0) {
                setX(getX() - 10);
            }
        }
    }

    @Override
    public void draw(Graphics2D graphics) {
        graphics.setColor(Color.pink);
        graphics.fillRect(getX(), getY(), getWidth(), getHeight());
    }

    public Rectangle getBounds() {
        return new Rectangle(getX(), getY(), getWidth(), getHeight());
    }
    
    public boolean intersect(Ball ball) {
    	return this.getBounds().intersects(ball.getBounds());
    }
}
