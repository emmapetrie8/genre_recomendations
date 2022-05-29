
public interface genre_recomendation {
	//reads in the file of shows of the specified genre
	public String[] readList(String genre);
	
	//takes the list of shows of the specific genre and randomly selects one to recommend 
	public genres selection(String[] shows);
	
	//parameter of the randomly selected recommendation 
	public void returnRecomendation();
}
