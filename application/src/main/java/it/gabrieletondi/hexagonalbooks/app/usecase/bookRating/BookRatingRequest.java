package it.gabrieletondi.hexagonalbooks.app.usecase.bookRating;

public class BookRatingRequest
{
  private final String bookId;
  private final int rating;

  public BookRatingRequest(String bookId, int rating)
  {
    this.bookId = bookId;
    this.rating = rating;
  }

  public String getBookId()
  {
    return bookId;
  }

  public int getRating()
  {
    return rating;
  }

  @Override public String toString()
  {
    return "BookRatingRequest{" +
        "bookId='" + bookId + '\'' +
        ", rating=" + rating +
        '}';
  }

  @Override public boolean equals(Object o)
  {
    if (this == o)
      return true;
    if (o == null || getClass() != o.getClass())
      return false;

    BookRatingRequest that = (BookRatingRequest) o;

    if (rating != that.rating)
      return false;
    return bookId.equals(that.bookId);

  }

  @Override public int hashCode()
  {
    int result = bookId.hashCode();
    result = 31 * result + rating;
    return result;
  }
}
