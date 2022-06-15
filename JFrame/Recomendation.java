import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Recomendation implements ActionListener{

	ArrayList<String> shows = new ArrayList<>();
	Random rand = new Random();

	JFrame frame;
	JTextField textField;
	JButton[] genreButton = new JButton[5];
	JButton actionButton, comedyButton, horrorButton, realityButton, romanceButton;
	JPanel panel;
	Font myFont = new Font("SansSerif", Font.BOLD,10);
	
	
	public Recomendation() {
		frame = new JFrame("Recomendations");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(400,500);
		frame.setLayout(null);
		
		JLabel label1 = new JLabel("Recomendation generator");
		label1.setSize(50,50);
		label1.setBounds(5,0,300,50);

		textField = new JTextField();
		textField.setBounds(50, 40, 300, 50);
		textField.setFont(myFont);
		textField.setEditable(false);

		actionButton = new JButton("Action");
		genreButton[0] = actionButton;
		comedyButton = new JButton("Comedy");
		genreButton[1] = comedyButton;
		horrorButton = new JButton("Horror");
		genreButton[2] = horrorButton;
		realityButton = new JButton("Reality");
		genreButton[3] = realityButton;
		romanceButton = new JButton("Romance");
		genreButton[4] = romanceButton;
		for (int i = 0; i<5; i++) {
			genreButton[i].addActionListener(this);
			genreButton[i].setFont(myFont);
			genreButton[i].setFocusable(false);
			genreButton[i].setBackground(Color.BLUE);
			genreButton[i].setOpaque(true);
		}
		
		
		panel = new JPanel();
		panel.setBounds(50, 100, 300, 200);
		panel.setLayout(new GridLayout(2,2,10,10));
		panel.add(genreButton[0]);
		panel.add(genreButton[1]);
		panel.add(genreButton[2]);
		panel.add(genreButton[3]);
		panel.add(genreButton[4]);
		
		frame.add(label1);
		frame.add(textField);
		frame.add(panel);
		frame.setVisible(true);	
		
		
	}
	
	
	public static void main(String[] args) {
		Recomendation recomendation = new Recomendation();
	}
	
	public void readFile(String file) throws IOException {
		
		BufferedReader bufReader = new BufferedReader(new FileReader(file)); 
		ArrayList<String> shows = new ArrayList<>(); 
		String line = bufReader.readLine(); 
		while (line != null) { 
			shows.add(line); 
			line = bufReader.readLine(); 
		} 
		bufReader.close();
		this.shows = shows;

	}
	
	public String selectShow() {
		int size = shows.size();
		//Random rand = new Random();
		int int_random = rand.nextInt(size);
				
		String recomendatedShow = shows.get(int_random); 
		return recomendatedShow;
	}
	
	public String getRecomendation(String genre) throws IOException {
		if (genre == "action") {
			readFile("/Users/emmapetrie/eclipse-workspace/Genre JFrame/src/action.txt");
			return selectShow();
		} else if (genre == "comedy") {
			readFile("/Users/emmapetrie/eclipse-workspace/Genre JFrame/src/comedy.txt");
			return selectShow();
		}else if (genre == "horror") {
			readFile("/Users/emmapetrie/eclipse-workspace/Genre JFrame/src/horror.txt");
			return selectShow();
		}else if (genre == "reality") {
			readFile("/Users/emmapetrie/eclipse-workspace/Genre JFrame/src/reality.txt");
			return selectShow();
		}else if (genre == "romance") {
			readFile("/Users/emmapetrie/eclipse-workspace/Genre JFrame/src/romance.txt");
			return selectShow();
		}
		return null;
	}
	
	@Override
	public void actionPerformed(ActionEvent e){
		// TODO Auto-generated method stub
		String recomendation;
		if (e.getSource() == actionButton) {
			try {
				recomendation = getRecomendation("action");
				textField.setText(recomendation);
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		} else if (e.getSource() == comedyButton) {
			try {
				recomendation = getRecomendation("comedy");
				textField.setText(recomendation);
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}else if (e.getSource() == horrorButton) {
			try {
				recomendation = getRecomendation("horror");
				textField.setText(recomendation);
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		} else if (e.getSource() == realityButton) {
			try {
				recomendation = getRecomendation("reality");
				textField.setText(recomendation);
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		} else if (e.getSource() == romanceButton) {
			try {
				recomendation = getRecomendation("romance");
				textField.setText(recomendation);
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}	
	}
}
