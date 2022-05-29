import java.util.Scanner;

public class recomendations {

	
	public void inputGenre() {
		Scanner genreInput = new Scanner(System.in);  // Create a Scanner object
	    System.out.println("Please entre the genre you want recomendations for");

	    String genre = genreInput.nextLine();  // Read user input
	    System.out.println("the genre for recomendations is: " + genre);  // Output user input
	}
	
	//calling the correct interface to get the random recommendation
	
	//calling the correct interface to get the top 5
	
	public static void main(String args[]) {

	}
}
