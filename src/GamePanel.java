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
	RocketShip rocketShip = new RocketShip(250, 700, 50, 50);

	void updateMenuState() {  }
	void updateGameState() {  }
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
		rocketShip.draw(g);
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

	Font titleFont;
	Font subTitleFont;
	Timer frameDraw;

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
		System.out.println("action");
		repaint();
	}
	@Override
	public void keyPressed(KeyEvent e) {
		if (e.getKeyCode()==KeyEvent.VK_ENTER) {
			if (currentState == END) {
				currentState = MENU;
			} else {
				currentState++;
			}
		}
		if(currentState == GAME) {
			if (e.getKeyCode()==KeyEvent.VK_UP) {
			    System.out.println("UP");
			} else if (e.getKeyCode()==KeyEvent.VK_DOWN) {
			    System.out.println("DOWN");
			} else if (e.getKeyCode()==KeyEvent.VK_LEFT) {
			    System.out.println("LEFT");
			} else if (e.getKeyCode()==KeyEvent.VK_RIGHT) {
			    System.out.println("RIGHT");
			}
		}
	}
	@Override
	public void keyReleased(KeyEvent e) {

	}
	@Override
	public void keyTyped(KeyEvent e) {

	}

}
