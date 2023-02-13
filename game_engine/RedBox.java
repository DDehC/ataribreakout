package game_engine;

import java.awt.*;

public class RedBox extends ColorBox{	
	ColorBox columbia;
	public RedBox (int x, int y, int width, int height) {
		super(x, y, width, height, MyColor.crystal);
	}
	public Rectangle getBounds() {
        return new Rectangle(getX(), getY(), getWidth(), getHeight());
	}
}

