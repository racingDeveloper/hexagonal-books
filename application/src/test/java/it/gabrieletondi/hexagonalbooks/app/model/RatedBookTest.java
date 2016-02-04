package it.gabrieletondi.hexagonalbooks.app.model;

import org.junit.Test;

import static java.util.Arrays.asList;
import static java.util.Collections.emptyList;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class RatedBookTest
{
  @Test
  public void calculatesAverageRating() throws Exception
  {
    RatedBook ratedBook = new RatedBook(null, asList(
        new BookRating(null, null, Rating.value(3)),
        new BookRating(null, null, Rating.value(4)),
        new BookRating(null, null, Rating.value(2)),
        new BookRating(null, null, Rating.value(10))
    ));

    assertThat(ratedBook.avgRating(), is(4.75));
  }

  @Test
  public void notRatedBookAverageRating() throws Exception
  {
    RatedBook ratedBook = new RatedBook(null, emptyList());

    assertThat(ratedBook.avgRating(), is(0.0));
  }
}
