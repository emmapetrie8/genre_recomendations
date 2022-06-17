import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class getDescriptionWindow implements ActionListener{
	
	JFrame frame = new JFrame();
	Font myFont = new Font("SansSerif", Font.BOLD,10);
	JTextField userInputShow, outputDescription;
	JButton go;
	
	
	String description;
	
	
	HashMap<String, String> showInformation = new HashMap<String, String>();

	
	public getDescriptionWindow() {
		
		JLabel label = new JLabel("Enter show title:");
		label.setBounds(0,0,100,50);
		label.setFont(myFont);
		
		userInputShow = new JTextField();
		userInputShow.setBounds(50, 40, 300, 50);
		userInputShow.setFont(myFont);
		userInputShow.setEditable(true);
		
		go = new JButton("Get description");
		go.addActionListener(this);
		go.setSize(50,50);
		go.setBounds(10, 100, 150, 50);
		go.setFont(myFont);
		go.setBackground(Color.ORANGE);
		go.setBorderPainted(false);
		go.setOpaque(true);
		
		outputDescription = new JTextField();
		outputDescription.setBounds(50,150,300,50);
		outputDescription.setFont(myFont);
		outputDescription.setEditable(false);
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(400,500);
		frame.setLayout(null);
		frame.setVisible(true);
		frame.add(label);
		frame.add(go);
		frame.add(outputDescription);
		frame.add(userInputShow);
	}
	
	public String getUserDescription() throws FileNotFoundException, IOException {
		readFile("/Users/emmapetrie/eclipse-workspace/genre_recomendations/JFrame/descriptions.txt");
		String input = userInputShow.getText();
		String description = getDescription(input);
		System.out.println(description);
		return description;
	}
	
	public void readFile(String filePath) throws FileNotFoundException, IOException {
		String line;
		
		try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
	        while ((line = reader.readLine()) != null) {
	            String[] keyValuePair = line.split(":", 2);
	            if (keyValuePair.length > 1) {
	                String key = keyValuePair[0];
	                String value = keyValuePair[1];
	                System.out.println(key + ":" + value);
	                showInformation.put(key, value);
	            }
	        }
		}catch (IOException e) {
	        e.printStackTrace();
	    }
	}
	
	public String getDescription(String showTitle) {
		
		for (String key : showInformation.keySet()) {
			if (key == showTitle) {
				System.out.println("WORKING");
				System.out.println("TITLE: " + key + " description: " + showInformation.get(key));
				this.description = showInformation.get(key);
			}
		}
		
//		for (HashMap.Entry<String, String> set : showInformation.entrySet()) {
//			if (set.getKey() == showTitle) {
//				System.out.println("WORKING");
//				this.description = set.getValue();
//			}
//		}
		return description;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String description;
		if (e.getSource() == go) {
			try {
				description = getUserDescription();
				outputDescription.setText(description);
				
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
		}
	}
	
	
	

}
