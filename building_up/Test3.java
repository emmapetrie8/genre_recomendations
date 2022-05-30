package project3;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

import project.genres;

public class Test3 {
	//need the array List of shows
	ArrayList<String> shows = new ArrayList<>();
	Random rand = new Random();
	String genre;
	Genres validGenre;
	boolean valid;
	
	public Test3() {
		this.valid = false;
	}
	
	public void getGenreInput() {
		Scanner genreInput = new Scanner(System.in);  // Create a Scanner object
	    System.out.println("Please entre the genre you want recomendations for");

	    String genre = genreInput.nextLine();  // Read user input
	    
	    //input validation
	    for (Genres g: Genres.values()) {
	    	if (g.name().equals(genre)) {
	    		valid = true;
	    		validGenre = g;
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
		String filePath = null;
		if (validGenre.equals(Genres.horror)) {
			filePath = "/Users/emmapetrie/genre_recomendations/horror.txt" ;
		} else if (validGenre.equals(Genres.comedy)) {
			filePath = "/Users/emmapetrie/genre_recomendations/comedy.txt" ;
		} else if (validGenre.equals(Genres.romance)) {
			filePath = "/Users/emmapetrie/genre_recomendations/romance.txt" ;
		}else if (validGenre.equals(Genres.action)) {
			filePath = "/Users/emmapetrie/genre_recomendations/action.txt" ;
		}else if (validGenre.equals(Genres.reality)) {
			filePath = "/Users/emmapetrie/genre_recomendations/reality.txt" ;
		}
		
		BufferedReader bufReader = new BufferedReader(new FileReader(filePath)); 
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
		System.out.println("The randomly selected recomendation is: " + recomendatedShow + ", enjoy!");

	}
	
	public static void main (String args[]) throws IOException {
		Test3 test = new Test3();
		test.getGenreInput();
		test.readFile();
		test.selectShow();
	}
}
