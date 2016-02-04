package it.gabrieletondi.hexagonalbooks.repository;

import it.gabrieletondi.hexagonalbooks.app.model.BookRating;
import it.gabrieletondi.hexagonalbooks.app.repository.BookRatingRepository;

import java.util.List;

public class InMemoryBookRatingRepository implements BookRatingRepository
{
  private final List<BookRating> bookRatings;

  public InMemoryBookRatingRepository(List<BookRating> bookRatings)
  {
    this.bookRatings = bookRatings;
  }

  @Override public void add(BookRating bookRating)
  {
    bookRatings.add(bookRating);
  }

  public List<BookRating> allRatings()
  {
    return bookRatings;
  }
}
