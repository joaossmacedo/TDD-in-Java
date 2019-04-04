import model.Movie;
import org.junit.Test;

import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.contains;
import static org.hamcrest.Matchers.containsInAnyOrder;

public class MovieStoreTest {
    @Test
    public void returnsNoResultsWhenNoTitlePartiallyMatchSearch() {
        MovieStore movieStore = new MovieStore();

        List<Movie> results = movieStore.findByPartialTitle("abc");

        assertThat(results.size(), is(0));
    }

    @Test
    public void findsMoviesWhenTitleArePartiallyMatched() {
        MovieStore movieStore = new MovieStore();

        Movie harry_potter = new Movie("Harry Potter");
        movieStore.add(harry_potter);

        Movie shawshank_redemption = new Movie("Shawshank Redemption");
        movieStore.add(shawshank_redemption);

        Movie star_wars = new Movie("Star Wars");
        movieStore.add(star_wars);

        Movie star_trek = new Movie("STAR Trek");
        movieStore.add(star_trek);


        List<Movie> results = movieStore.findByPartialTitle("tar");

        assertThat(results.size(), is(2));
        assertThat(results, containsInAnyOrder(star_trek, star_wars));
    }

}
