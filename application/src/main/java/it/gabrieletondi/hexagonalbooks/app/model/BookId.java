package it.gabrieletondi.hexagonalbooks.app.model;

public class BookId
{
  private final String id;

  public BookId(String id)
  {
    this.id = id;
  }

  public String id()
  {
    return id;
  }

  @Override public String toString()
  {
    return "BookId{" +
        "id='" + id + '\'' +
        '}';
  }

  @Override public boolean equals(Object o)
  {
    if (this == o)
      return true;
    if (o == null || getClass() != o.getClass())
      return false;

    BookId bookId = (BookId) o;

    return id.equals(bookId.id);
  }

  @Override public int hashCode()
  {
    return id.hashCode();
  }
}
