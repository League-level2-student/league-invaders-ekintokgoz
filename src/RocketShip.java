import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;

public class RocketShip extends GameObject{
	boolean isMoving = false;
	int maxX;
	int maxY;
	String direction = "";
	public static BufferedImage image;
	public static boolean needImage = true;
	public static boolean gotImage = false;	
	RocketShip(int x, int y, int width, int height, int maxX, int maxY) {
		super(x, y, width, height);
		this.maxX = maxX;
		this.maxY = maxY;
		speed = 10;
		if (needImage) {
			loadImage ("rocket.png");
		}
	}

	void draw(Graphics g) {
		if (gotImage) {
			g.drawImage(image, x, y, width, height, null);
		} else {
			g.setColor(Color.BLUE);
			g.fillRect(x, y, width, height);
		}
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

	void loadImage(String imageFile) {
		if (needImage) {
			try {
				image = ImageIO.read(this.getClass().getResourceAsStream(imageFile));
				gotImage = true;
			} catch (Exception e) {

			}
			needImage = false;
		}
	}

	public Projectile getProjectile() {
		return new Projectile(x+width/2, y, 10, 10);
	} 
}
