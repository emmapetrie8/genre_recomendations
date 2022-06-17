import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map.Entry;
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
	JTextField recomendedShowField;
	JButton[] genreButton = new JButton[5];
	JButton actionButton, comedyButton, horrorButton, realityButton, romanceButton;
	JButton getDescription;
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

		recomendedShowField = new JTextField();
		recomendedShowField.setBounds(50, 40, 300, 50);
		recomendedShowField.setFont(myFont);
		recomendedShowField.setEditable(false);
		
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
			genreButton[i].setForeground(Color.green);
			genreButton[i].setFocusable(false);
			genreButton[i].setBackground(Color.BLUE);
			genreButton[i].setBorderPainted(false);
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
		
		getDescription = new JButton("Get description");
		getDescription.addActionListener(this);
		getDescription.setSize(50,50);
		getDescription.setBounds(50, 350, 100, 50);
		getDescription.setFont(myFont);
		getDescription.setBackground(Color.red);
		getDescription.setOpaque(true);
		
		frame.add(label1);
		frame.add(recomendedShowField);
		frame.add(panel);
		frame.add(getDescription);
		frame.setVisible(true);	
	}
		
	public static void main(String[] args) {
//		HashMapFromTextFile("/Users/emmapetrie/eclipse-workspace/Genre JFrame/src/action.txt");
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
//	
//	public void read(String file) throws IOException{
//		
//	}
//	
//	public static void HashMapFromTextFile(String toRead){
//  
//        HashMap<String, String> shows = new HashMap<String, String>();
//        BufferedReader br = null;
//  
//        try {
//  
//            // create file object
//            File file = new File(toRead);
//  
//            // create BufferedReader object from the File
//            br = new BufferedReader(new FileReader(file));
//  
//            String line = null;
//  
//            // read file line by line
//            while ((line = br.readLine()) != null) {
//  
//                // split the line by :
//                String[] parts = line.split(":");
//  
//                // first part is name, second is number
//                String name = parts[0].trim();
//                String number = parts[1].trim();
//  
//                // put name, number in HashMap if they are
//                // not empty
//                if (!name.equals("") && !number.equals(""))
//                    shows.put(name, number);
//            }
//        }
//        catch (Exception e) {
//            e.printStackTrace();
//        }
//        finally {
//  
//            // Always close the BufferedReader
//            if (br != null) {
//                try {
//                    br.close();
//                }
//                catch (Exception e) {
//                };
//            }
//        }
//        
//        for (Entry<String, String> entry : shows.entrySet()) {
//           System.out.println(entry.getKey() + " : " + entry.getValue());
//       }
//  
//    }
	
	public String selectShow() {
		int size = shows.size();
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
		String recomendation;
		if (e.getSource() == actionButton) {
			try {
				recomendation = getRecomendation("action");
				recomendedShowField.setText(recomendation);
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		} else if (e.getSource() == comedyButton) {
			try {
				recomendation = getRecomendation("comedy");
				recomendedShowField.setText(recomendation);
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}else if (e.getSource() == horrorButton) {
			try {
				recomendation = getRecomendation("horror");
				recomendedShowField.setText(recomendation);
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		} else if (e.getSource() == realityButton) {
			try {
				recomendation = getRecomendation("reality");
				recomendedShowField.setText(recomendation);
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		} else if (e.getSource() == romanceButton) {
			try {
				recomendation = getRecomendation("romance");
				recomendedShowField.setText(recomendation);
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}else if (e.getSource() == getDescription) {
			getDescriptionWindow newWindow = new getDescriptionWindow();
		}
	}
}