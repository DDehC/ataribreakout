package game_engine; 

import game_engine.Consts;
import java.awt.*;
import java.util.Timer;
import java.util.TimerTask;

public class Ball extends Sprite {
    Player player;
    Bricks bricks;
    private int startmoving = 0;
    private int yDirection = 3;
    private int xDirection = 1;
    private int change = 0;
    private Color ballColor = Color.RED;
    private Timer timer;

    public Ball(int x, int y, int width, int height, Bricks bricks) {
        super(x, y, width, height);
        this.bricks = bricks;
        
        
        timer = new Timer();
        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                if (ballColor.equals(MyColor.yelo)) {
                    ballColor = MyColor.blu;
                } else if (ballColor.equals(MyColor.blu)) {
                    ballColor = MyColor.tangelo;
                } else {
                    ballColor = MyColor.yelo;
                }
            }
        }, 1000, 100);
       
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
    
    @Override
    public void draw(Graphics2D graphics) {
        graphics.setColor(ballColor);
        graphics.fillOval(getX(), getY(), getWidth(), getHeight());   
    }
    
    public void reverseY() {
        yDirection *= -1;
    }

    public void reverseX() {
        xDirection *= -1;
    }
    
    public void speedup() {
        if(change <3) {
            xDirection *= 1.4;
            yDirection *= 1.4;
            change++;
        }
    }

    public Rectangle getBounds() {
        return new Rectangle(getX(), getY(), getWidth(), getHeight());
    }

    public boolean intersect(Player player) {
        return this.getBounds().intersects(player.getBounds());
    }
}
