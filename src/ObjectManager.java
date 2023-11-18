import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Random;

public class ObjectManager {
	
	RocketShip rocketship;
	ArrayList<Projectile> projectiles = new ArrayList<>();
	ArrayList<Alien> aliens = new ArrayList<>();
	Random random = new Random();
	
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
				aliens.remove(i);
			}
		}
	}
}
