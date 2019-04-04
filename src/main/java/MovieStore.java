import model.Movie;

import java.util.LinkedList;
import java.util.List;

import static java.util.Arrays.asList;

public class MovieStore {
    List<Movie> movies = new LinkedList<Movie>();
    
    public List<Movie> findByPartialTitle(String partialTitle) {
        List<Movie> results = new LinkedList<Movie>();

        for (Movie movie : movies) {
            if (movie.getTitle().toUpperCase().contains(partialTitle.toUpperCase())){
                results.add(movie);
            }
        }

        return results;
    }

    public void add(Movie movie){
        movies.add(movie);
    }

    public List<Movie> findByDirector(String director) {
        List<Movie> results = new LinkedList<Movie>();

        for (Movie movie : movies) {
            if (movie.getDirector().toUpperCase().equals(director.toUpperCase())){
                results.add(movie);
            }
        }

        return results;
    }

    public List<Movie> findByReleaseYear(int from, int to) {
        return null;
    }
}
