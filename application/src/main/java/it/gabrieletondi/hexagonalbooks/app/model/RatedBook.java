package it.gabrieletondi.hexagonalbooks.app.model;

import java.util.List;

public class RatedBook
{
  private final BookId bookId;
  private final List<BookRating> ratings;

  public RatedBook(BookId bookId, List<BookRating> ratings)
  {
    this.bookId = bookId;
    this.ratings = ratings;
  }

  public BookId bookId()
  {
    return bookId;
  }

  public double avgRating()
  {
    return ratings
        .stream()
        .mapToInt(r -> r.rating().value())
        .average()
        .orElse(0);
  }
}
