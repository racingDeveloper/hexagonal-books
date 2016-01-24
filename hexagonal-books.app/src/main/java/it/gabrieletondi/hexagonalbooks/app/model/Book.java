package it.gabrieletondi.hexagonalbooks.app.model;

public class Book
{
  private final BookId id;

  public Book(BookId id)
  {
    this.id = id;
  }

  public BookRating rate(Rating rating)
  {
    return new BookRating(id, rating);
  }

  public boolean hasId(BookId otherId)
  {
    return this.id.equals(otherId);
  }

  @Override public String toString()
  {
    return "Book{" +
        "id=" + id +
        '}';
  }

  @Override public boolean equals(Object o)
  {
    if (this == o)
      return true;
    if (o == null || getClass() != o.getClass())
      return false;

    Book book = (Book) o;

    return id.equals(book.id);

  }

  @Override public int hashCode()
  {
    return id.hashCode();
  }
}
