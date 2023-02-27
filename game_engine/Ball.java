package game_engine;
import game_engine.Consts;
import java.awt.*;


public class Ball extends Sprite {
    Player player;
    Bricks bricks;
    private int startmoving = 0;
    private int yDirection = 2;
    private int xDirection = 1;
    private int change = 0;

    public Ball(int x, int y, int width, int height, Bricks bricks) {
        super(x, y, width, height);
        this.bricks = bricks;
    }

    public void reverseY() {
    	yDirection *= -1;
    }

    public void reverseX() {
        xDirection *= -1;
    }

    @Override
    public void update(Keyboard keyboard) {
        if (startmoving == 0) {
            if (keyboard.isKeyDown(Key.Right)) {
                startmoving = 1;
            } else if (keyboard.isKeyDown(Key.Left)) {
                startmoving = 1;
            }
        } else {
            int x = getX() + 2 * xDirection;
            int y = getY() + 2 * yDirection;
            setX(x);
            setY(y);

            if (x + getWidth() >= Consts.FRAME_WIDTH || x <= 0) {
                reverseX();
            }
            if (y <= 0) {
                reverseY();
            }

            if (bricks.checkCollision(x, y, xDirection, yDirection)) {
                reverseY();
            }
        }
    }
    
    public void speedup() {
    	if(change <3) {
    	xDirection *= 1.5;
    	yDirection *= 1.5;
    	change++;
    	}
    }
    
    public void levelComplete() {
    	xDirection = 0;
    	yDirection = 0;
    }
    
    @Override
    public void draw(Graphics2D graphics) {
        graphics.setColor(Color.red);
        graphics.fillOval(getX(), getY(), getWidth(), getHeight());   
    }
    
    public int returnY() {
    	int y = getY();
    	return y;
    }

    public Rectangle getBounds() {
        return new Rectangle(getX(), getY(), getWidth(), getHeight());
    }

    public boolean intersect(Player player) {
    	return this.getBounds().intersects(player.getBounds());
    }

}
