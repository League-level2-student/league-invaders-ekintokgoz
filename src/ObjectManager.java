import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;

public class ObjectManager implements ActionListener {

	RocketShip rocketship;
	ArrayList<Projectile> projectiles = new ArrayList<>();
	ArrayList<Alien> aliens = new ArrayList<>();
	Random random = new Random();
	int score = 0;
	

	ObjectManager(RocketShip rocketship) {
		this.rocketship = rocketship;
	}

	void addProjectile(Projectile projectile) {
		projectiles.add(projectile);
	}

	void addAlien() {
		aliens.add(new Alien(random.nextInt(LeagueInvaders.WIDTH),0,50,50));
	}

	void update() {
		for(int i = 0; i<aliens.size(); i++) {
			aliens.get(i).update();
		}
		for(int i = 0; i<projectiles.size(); i++) {
			projectiles.get(i).update();
		}
		checkCollision();
		purgeObjects();
	}

	void draw(Graphics g) {
		for(int i = 0; i<aliens.size(); i++) {
			aliens.get(i).draw(g); 
		}
		for(int i = 0; i<projectiles.size(); i++) {
			projectiles.get(i).draw(g);
		}
		rocketship.draw(g);
	}

	void purgeObjects() {
		for(int i = 0; i<aliens.size(); i++) {
			if(!(aliens.get(i).isActive)) {
				aliens.remove(i);
			}
		} for(int i = 0; i<projectiles.size(); i++) {
			if(!(projectiles.get(i).isActive)) {
				projectiles.remove(i);
			}
		}
	}

	void checkCollision() {
		for(int i = 0; i<aliens.size(); i++) {
			if(rocketship.collisionBox.intersects(aliens.get(i).collisionBox)) {
				GamePanel.currentState = GamePanel.END;
				break;
			}
			for(int k = 0; k<projectiles.size(); k++)	{
				if(projectiles.get(k).collisionBox.intersects(aliens.get(i).collisionBox)) {
					projectiles.get(k).isActive = false;
					aliens.get(i).isActive = false;
					score+=1;
				}
			}
		}
		if(GamePanel.currentState== GamePanel.END) {
			aliens = new ArrayList<>();
			projectiles = new ArrayList<>();
		}
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		addAlien();

	}
}
