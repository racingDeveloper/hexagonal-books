package it.gabrieletondi.hexagonalbooks.repository;

import it.gabrieletondi.hexagonalbooks.app.model.*;
import org.junit.Test;

import java.util.ArrayList;

import static java.util.Arrays.asList;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class InMemoryBookRatingRepositoryTest
{
  private static final BookId A_BOOK_ID = new BookId("A BOOK ID");
  private static final BookRatingId A_BOOK_RATING_ID = new BookRatingId();
  private static final BookRatingId ANOTHER_BOOK_RATING_ID = new BookRatingId();

  private final InMemoryBookRatingRepository repository = new InMemoryBookRatingRepository(new ArrayList<>());

  @Test
  public void storeRating() throws Exception
  {
    repository.add(new BookRating(A_BOOK_RATING_ID, A_BOOK_ID, Rating.value(3)));
    repository.add(new BookRating(ANOTHER_BOOK_RATING_ID, A_BOOK_ID, Rating.value(4)));

    assertThat(repository.allRatings(), is(asList(
        new BookRating(A_BOOK_RATING_ID, A_BOOK_ID, Rating.value(3)),
        new BookRating(ANOTHER_BOOK_RATING_ID, A_BOOK_ID, Rating.value(4))
    )));
  }
}
