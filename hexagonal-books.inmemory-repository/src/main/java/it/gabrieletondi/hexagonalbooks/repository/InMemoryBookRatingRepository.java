package it.gabrieletondi.hexagonalbooks.repository;

import it.gabrieletondi.hexagonalbooks.app.model.BookRating;
import it.gabrieletondi.hexagonalbooks.app.repository.BookRatingRepository;

import java.util.ArrayList;
import java.util.List;

public class InMemoryBookRatingRepository implements BookRatingRepository
{
  private List<BookRating> bookRatings = new ArrayList<>();

  @Override public void add(BookRating bookRating)
  {
    this.bookRatings.add(bookRating);
  }

  public List<BookRating> allRatings()
  {
    return bookRatings;
  }
}
