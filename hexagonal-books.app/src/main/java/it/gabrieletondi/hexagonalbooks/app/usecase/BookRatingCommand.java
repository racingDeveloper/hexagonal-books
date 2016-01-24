package it.gabrieletondi.hexagonalbooks.app.usecase;

public class BookRatingCommand
{
  private final String bookId;
  private final int rating;

  public BookRatingCommand(String bookId, int rating)
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
}
