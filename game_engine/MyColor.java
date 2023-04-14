package game_engine;

import java.awt.Color;
import java.util.Timer;
import java.util.TimerTask;

public class MyColor extends ColorBox {
	public MyColor(int x, int y, int width, int height, Color color) {
		super(x, y, width, height, color);
	}
	public static final Color crystal = new Color(94, 169, 190);
	public static final Color cerulian = new Color(203, 225, 239);
	public static final Color columbia = new Color(154, 205, 224);
	public static final Color tangelo = new Color(255, 56, 0);
	public static final Color blu = new Color(0, 166, 237);
	public static final Color yelo = new Color(247, 231, 51);
	
	/* timer = new Timer();
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
        }, 1000, 100); */


}
