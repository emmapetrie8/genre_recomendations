import javax.swing.JFrame;

public class GameFrame extends JFrame{
	public GameFrame(){
		GamePanel panel = new GamePanel();
		
		this.add(panel);
		this.setTitle("Recomendations");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
		this.pack();
		this.setVisible(true);
		this.setLocationRelativeTo(null); //appear in middle of screen
	}
}
