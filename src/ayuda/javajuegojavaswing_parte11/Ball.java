package ayuda.javajuegojavaswing_parte11;

import java.awt.Graphics2D;
import java.awt.Rectangle;

public class Ball {
	private static final int DIAMETER = 30;
	int x = 0;
	int y = 0;
	int vx = 1;
	int vy = 1;
	private Game game;

	public Ball(Game game, int x, int y) {
		this.game= game;
                this.x = x;
                this.y = y;
	}

	void move() {
		if (x + vx < 0)
			vx = 1;
		if (x + vx > game.getWidth() - DIAMETER)
			vx = -1;
		if (y + vy < 0)
			vy = 1;
		if (y + vy > game.getHeight() - DIAMETER)
			game.gameOver();
		if (collision()){
			vy = -1;
			y = game.racquet.getTopY() - DIAMETER;
		}
		x = x + vx;
		y = y + vy;
	}

	private boolean collision() {
		return game.racquet.getBounds().intersects(getBounds());
	}

	public void paint(Graphics2D g) {
		g.fillOval(x, y, DIAMETER, DIAMETER);
	}
	
	public Rectangle getBounds() {
		return new Rectangle(x, y, DIAMETER, DIAMETER);
	}
}

