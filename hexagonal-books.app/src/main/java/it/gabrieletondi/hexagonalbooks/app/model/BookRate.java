package it.gabrieletondi.hexagonalbooks.app.model;

public class BookRate
{
  private final BookId bookId;
  private final Rate rate;

  public BookRate(BookId bookId, Rate rate)
  {
    this.bookId = bookId;
    this.rate = rate;
  }

  @Override public String toString()
  {
    return "BookRate{" +
        "bookId=" + bookId +
        ", rate=" + rate +
        '}';
  }

  @Override public boolean equals(Object o)
  {
    if (this == o)
      return true;
    if (o == null || getClass() != o.getClass())
      return false;

    BookRate bookRate = (BookRate) o;

    if (!bookId.equals(bookRate.bookId))
      return false;
    return rate.equals(bookRate.rate);
  }

  @Override public int hashCode()
  {
    int result = bookId.hashCode();
    result = 31 * result + rate.hashCode();
    return result;
  }
}
