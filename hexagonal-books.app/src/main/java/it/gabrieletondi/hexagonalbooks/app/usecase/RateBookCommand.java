package it.gabrieletondi.hexagonalbooks.app.usecase;

public class RateBookCommand
{
  private final String bookId;
  private final int rate;

  public RateBookCommand(String bookId, int rate)
  {
    this.bookId = bookId;
    this.rate = rate;
  }

  public String getBookId()
  {
    return bookId;
  }

  public int getRate()
  {
    return rate;
  }
}
