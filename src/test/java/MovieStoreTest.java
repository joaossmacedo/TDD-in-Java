import model.Movie;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.contains;
import static org.hamcrest.Matchers.containsInAnyOrder;

public class MovieStoreTest {
    private final MovieStore movieStore = new MovieStore();
    private final Movie harry_potter = new Movie("Harry Potter", "Rowling", 2000);
    private final Movie star_wars = new Movie("Star Wars", "Shwimmer", 1999);
    private final Movie star_trek = new Movie("STAR Trek", "Shwimmer", 2002);
    private final Movie shawshank_redemption = new Movie("Shawshank Redemption", "Bob", 2001);
    private final Movie take_that = new Movie("Take That", "Shwimmer", 2010);

    @Before
    public void setUp() throws Exception {
        movieStore.add(shawshank_redemption);
        movieStore.add(harry_potter);
        movieStore.add(star_wars);
        movieStore.add(star_trek);
        movieStore.add(take_that);
    }


    @Test
    public void returnsNoResultsWhenNoTitlePartiallyMatchSearch() {
        MovieStore movieStore = new MovieStore();

        List<Movie> results = movieStore.findByPartialTitle("abc");

        assertThat(results.size(), is(0));
    }

    @Test
    public void findsMoviesWhenTitleArePartiallyMatchedCaseInsensitive() {
        List<Movie> results = movieStore.findByPartialTitle("tar");

        assertThat(results.size(), is(2));
        assertThat(results, containsInAnyOrder(star_trek, star_wars));
    }

    @Test
    public void findsMoviesWhenDirectorExactlyMatches() {
        List<Movie> results = movieStore.findByDirector("Shwimmer");

        assertThat(results.size(), is(3));
        assertThat(results, containsInAnyOrder(star_trek, star_wars, take_that));
    }

    @Test
    public void findsMoviesWhenReleaseYearIsBetweenTwoValues() {
        List<Movie> results = movieStore.findByReleaseYear(1999, 2002);

        assertThat(results.size(), is(2));
        assertThat(results, containsInAnyOrder(harry_potter, shawshank_redemption));
    }

}
