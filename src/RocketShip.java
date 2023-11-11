import java.awt.Color;
import java.awt.Graphics;

public class RocketShip extends GameObject{
	boolean isMoving = false;
	int maxX;
	int maxY;
	String direction = "";
	RocketShip(int x, int y, int width, int height, int maxX, int maxY) {
		super(x, y, width, height);
		this.maxX = maxX;
		this.maxY = maxY;
		speed = 10;
	}

	void draw(Graphics g) {
		g.setColor(Color.BLUE);
		g.fillRect(x, y, width, height);
	}

	public void right() {
		x+=speed;
	}
	public void left() {
		x-=speed;
	}
	public void up() {
		y-=speed;
	}
	public void down() {
		y+=speed;
	}

	public void updatePos() {
		if(isMoving) {
			if(direction.equals("right")) {
				right();
				if(x >= maxX-width) {
					isMoving = false;
				}
			} else if(direction.equals("left")) {
				left();
				if(x <= 0) {
					isMoving = false;
				}
			} else if(direction.equals("up")) {
				up();
				if(y <= 0) {
					isMoving = false;
				}
			} else if(direction.equals("down")) {
				if(y >= maxY-height) {
					isMoving = false;
				}else {
					down();
				}
			}
		}
	}
}
