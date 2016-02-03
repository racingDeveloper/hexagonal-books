package it.gabrieletondi.hexagonalbooks.app.model;

public class BookRating
{
  private final BookRatingId bookRatingId;
  private final BookId bookId;
  private final Rating rating;

  public BookRating(BookRatingId bookRatingId, BookId bookId, Rating rating)
  {
    this.bookRatingId = bookRatingId;
    this.bookId = bookId;
    this.rating = rating;
  }

  public BookId bookId()
  {
    return this.bookId;
  }

  public Rating rating()
  {
    return rating;
  }

  @Override public String toString()
  {
    return "BookRating{" +
        "bookRatingId=" + bookRatingId +
        ", bookId=" + bookId +
        ", rating=" + rating +
        '}';
  }

  @Override public boolean equals(Object o)
  {
    if (this == o)
      return true;
    if (o == null || getClass() != o.getClass())
      return false;

    BookRating that = (BookRating) o;

    return bookRatingId.equals(that.bookRatingId);

  }

  @Override public int hashCode()
  {
    return bookRatingId.hashCode();
  }
}
