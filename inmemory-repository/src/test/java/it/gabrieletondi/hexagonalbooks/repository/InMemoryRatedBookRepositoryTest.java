package it.gabrieletondi.hexagonalbooks.repository;

import it.gabrieletondi.hexagonalbooks.app.model.*;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static java.util.Arrays.asList;
import static java.util.Collections.singletonList;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class InMemoryRatedBookRepositoryTest
{
  private static final BookId BOOK_A = new BookId("BOOK_A");
  private static final BookId BOOK_B = new BookId("BOOK_B");

  private InMemoryRatedBookRepository repository;

  @Before
  public void setUp()
  {
    List<BookRating> ratings = asList(
        new BookRating(new BookRatingId(), BOOK_A, Rating.value(1)),
        new BookRating(new BookRatingId(), BOOK_B, Rating.value(2)),
        new BookRating(new BookRatingId(), BOOK_A, Rating.value(3))
    );

    this.repository = new InMemoryRatedBookRepository(ratings);
  }

  @Test
  public void multipleRatedBooks() throws Exception
  {
    List<RatedBook> ratedBooks = repository.listAll();
    List<RatedBook> expectedRatedBooks = asList(
        new RatedBook(BOOK_A, asList(Rating.value(1), Rating.value(3))),
        new RatedBook(BOOK_B, singletonList(Rating.value(2)))
    );
    assertThat(ratedBooks, is(expectedRatedBooks));
  }
}
