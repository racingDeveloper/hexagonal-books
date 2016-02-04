package it.gabrieletondi.hexagonalbooks.app.model;

import java.util.List;

public class RatedBook
{
  private final BookId bookId;
  private final List<Rating> ratings;

  public RatedBook(BookId bookId, List<Rating> ratings)
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
        .mapToInt(Rating::value)
        .average()
        .orElse(0);
  }

  @Override public String toString()
  {
    return "RatedBook{" +
        "bookId=" + bookId +
        ", ratings=" + ratings +
        '}';
  }

  @Override public boolean equals(Object o)
  {
    if (this == o)
      return true;
    if (o == null || getClass() != o.getClass())
      return false;

    RatedBook ratedBook = (RatedBook) o;

    if (!bookId.equals(ratedBook.bookId))
      return false;
    return ratings.equals(ratedBook.ratings);

  }

  @Override public int hashCode()
  {
    int result = bookId.hashCode();
    result = 31 * result + ratings.hashCode();
    return result;
  }
}
