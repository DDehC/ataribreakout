package game_engine;

import java.awt.*;

public class BlueBox extends ColorBox{
	ColorBox crystal;
	public BlueBox (int x, int y, int width, int height) {
		super(x, y, width, height, MyColor.columbia);
	}
	public Rectangle getBounds() {
        return new Rectangle(getX(), getY(), getWidth(), getHeight());
	}
}

