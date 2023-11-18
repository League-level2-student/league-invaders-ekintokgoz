import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JPanel;
import javax.swing.Timer;

public class GamePanel extends JPanel implements ActionListener, KeyListener {

	final int MENU = 0;
	final int GAME = 1;
	final int END = 2;
	int currentState = MENU;
	Font titleFont;
	Font subTitleFont;
	Timer frameDraw;
	RocketShip rocketShip = new RocketShip(250, 700, 50, 50, LeagueInvaders.WIDTH, LeagueInvaders.HEIGHT);
	ObjectManager objectManager = new ObjectManager(rocketShip);
	

	void updateMenuState() {  }
	void updateGameState() {
		objectManager.update();
	}
	void updateEndState()  {  }

	void drawMenuState(Graphics g) {
		g.setColor(Color.BLUE);
		g.fillRect(0, 0, LeagueInvaders.WIDTH, LeagueInvaders.HEIGHT);
		g.setFont(titleFont);
		g.setColor(Color.YELLOW);
		g.drawString("LEAGUE INVADERS", 25, 200);
		g.setFont(subTitleFont);
		g.drawString("Press ENTER to start", 115, 350);
		g.drawString("Press SPACE for instructions", 75, 500);
	}
	void drawGameState(Graphics g) {
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, LeagueInvaders.WIDTH, LeagueInvaders.HEIGHT);
		rocketShip.updatePos();
		objectManager.draw(g);
	}
	void drawEndState(Graphics g)  {
		g.setColor(Color.RED);
		g.fillRect(0, 0, LeagueInvaders.WIDTH, LeagueInvaders.HEIGHT);
		g.setFont(titleFont);
		g.setColor(Color.BLACK);
		g.drawString("Game Over", 115, 200);
		g.setFont(subTitleFont);
		g.drawString("You killed enemies", 120, 350);
		g.drawString("Press ENTER to Restart", 85, 500);
	}

	GamePanel() {
		titleFont = new Font("Arial", Font.PLAIN, 48);
		subTitleFont = new Font("Arial", Font.PLAIN, 28);
		frameDraw = new Timer(1000/60,this);
		frameDraw.start();
	}

	@Override
	public void paintComponent(Graphics g){
		if(currentState == MENU){
			drawMenuState(g);
		}else if(currentState == GAME){
			drawGameState(g);
		}else if(currentState == END){
			drawEndState(g);
		}
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if(currentState == MENU){
			updateMenuState();
		}else if(currentState == GAME){
			updateGameState();
		}else if(currentState == END){
			updateEndState();
		}
		repaint();
	}
	int counter = 0;
	@Override
	public void keyPressed(KeyEvent e) {
		System.out.println(counter++);
		if (e.getKeyCode()==KeyEvent.VK_ENTER) {
			if (currentState == END) {
				currentState = MENU;
			} else {
				currentState++;
			}
		}
		if(currentState == GAME) {
			if (e.getKeyCode()==KeyEvent.VK_UP) { 
				if(rocketShip.y > 0) {
					rocketShip.isMoving = true;
					rocketShip.direction = "up";
				}
			} else if (e.getKeyCode()==KeyEvent.VK_DOWN) {
				if(rocketShip.y < 800-rocketShip.height) { 
					rocketShip.isMoving = true;
					rocketShip.direction = "down";
				}
			} else if (e.getKeyCode()==KeyEvent.VK_LEFT) {
				if(rocketShip.x > 0) { 			
					rocketShip.isMoving = true;
					rocketShip.direction = "left"; 
				}				
			} else if (e.getKeyCode()==KeyEvent.VK_RIGHT) {
				if(rocketShip.x < 500-rocketShip.width) {
					rocketShip.isMoving = true;
					rocketShip.direction = "right";
				}
			}
		}
	}
	@Override
	public void keyReleased(KeyEvent e) {
		if(e.getKeyCode()==KeyEvent.VK_UP||e.getKeyCode()==KeyEvent.VK_DOWN||
				e.getKeyCode()==KeyEvent.VK_RIGHT||e.getKeyCode()==KeyEvent.VK_LEFT) {
			rocketShip.isMoving = false;
		}
	}
	@Override
	public void keyTyped(KeyEvent e) {

	}

}
