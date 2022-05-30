package project3;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

import project.genres;

public class Test2 {
	//need the array List of shows
	ArrayList<String> shows = new ArrayList<>();
	Random rand = new Random();
	String genre;
	
	public Test2() {
		
	}
	
	public void getGenreInput() {
		Scanner genreInput = new Scanner(System.in);  // Create a Scanner object
	   	 System.out.println("Please entre the genre you want recomendations for");

	    	String genre = genreInput.nextLine();  // Read user input
		//input validation
	    	for (genres g: genres.values()) {
	    		if (g.name().equals(genre)) {
	    			valid = true;
		    		System.out.println("valid genre! Getting a recomendation...");
	    		}
	   	 }
	    	if (valid == false) {
	    		System.out.println("invalid genre, please try again");
	    		getGenreInput();
	    	}    
	    this.genre = genre;  
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
		Test2 test = new Test2();
		test.getGenreInput();
		test.readFile();
		test.selectShow();
	}

}
