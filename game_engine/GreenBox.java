package game_engine;

import java.awt.*;

public class GreenBox extends ColorBox{	
	ColorBox cerulian;
	public GreenBox (int x, int y, int width, int height) {
		super(x, y, width, height, MyColor.cerulian);
	}
	public Rectangle getBounds() {
        return new Rectangle(getX(), getY(), getWidth(), getHeight());
	}
}

