import javax.swing.JFrame;

public class LeagueInvaders {
	
	JFrame frame;
	public static final int WIDTH = 500;
	public static final int HEIGHT = 800;
	GamePanel gamePanel;
	
	public static void main(String[] args) {
		LeagueInvaders leagueInvader = new LeagueInvaders();
		leagueInvader.setup(WIDTH, HEIGHT);
	}
	
	LeagueInvaders() {
		frame = new JFrame();
		gamePanel = new GamePanel();
	}
	
	void setup(int width, int height) {
		frame.add(gamePanel);
		frame.setVisible(true);
		frame.setSize(width, height);
		frame.addKeyListener(gamePanel);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
