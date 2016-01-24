package it.gabrieletondi.hexagonalbooks.app.model;

public class BookRating
{
  private final BookId bookId;
  private final Rating rating;

  public BookRating(BookId bookId, Rating rating)
  {
    this.bookId = bookId;
    this.rating = rating;
  }

  @Override public String toString()
  {
    return "BookRating{" +
        "bookId=" + bookId +
        ", rating=" + rating +
        '}';
  }

  @Override public boolean equals(Object o)
  {
    if (this == o)
      return true;
    if (o == null || getClass() != o.getClass())
      return false;

    BookRating bookRating = (BookRating) o;

    if (!bookId.equals(bookRating.bookId))
      return false;
    return rating.equals(bookRating.rating);
  }

  @Override public int hashCode()
  {
    int result = bookId.hashCode();
    result = 31 * result + rating.hashCode();
    return result;
  }
}
