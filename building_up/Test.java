package project3;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

public class Test {
	//need the array List of shows
	ArrayList<String> shows = new ArrayList<>();
	Random rand = new Random();
	
	public Test() {
		
	}
	
	public void readFile() throws IOException {
		
		BufferedReader bufReader = new BufferedReader(new FileReader("/Users/emmapetrie/genre_recomendations/horror.txt")); 
		ArrayList<String> shows = new ArrayList<>(); 
		String line = bufReader.readLine(); 
		while (line != null) { 
			shows.add(line); 
			line = bufReader.readLine(); 
		} 
		bufReader.close();
		this.shows = shows;

	}
	
	public void selectShow() {
		int size = shows.size();
		Random rand = new Random();
		int int_random = rand.nextInt(size);
				
		String recomendatedShow = shows.get(int_random); 
		System.out.println("The randomly selected recomendation is: " + recomendatedShow + " enjoy!");

	}
	
	public static void main (String args[]) throws IOException {
		Test test = new Test();
		test.readFile();
		test.selectShow();
	}

}
