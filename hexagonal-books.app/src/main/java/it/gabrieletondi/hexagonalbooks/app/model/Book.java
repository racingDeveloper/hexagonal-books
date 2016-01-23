package it.gabrieletondi.hexagonalbooks.app.model;

public class Book
{
  private final BookId id;

  public Book(BookId id)
  {
    this.id = id;
  }

  public BookRate rate(Rate rate)
  {
    return new BookRate(id, rate);
  }
}
