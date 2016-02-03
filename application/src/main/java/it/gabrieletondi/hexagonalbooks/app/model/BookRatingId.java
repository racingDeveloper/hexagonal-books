package it.gabrieletondi.hexagonalbooks.app.model;

import java.util.UUID;

public class BookRatingId
{
  private final String id;

  public BookRatingId()
  {
    this.id = UUID.randomUUID().toString();
  }

  @Override public String toString()
  {
    return "BookRatingId{" +
        "id='" + id + '\'' +
        '}';
  }

  @Override public boolean equals(Object o)
  {
    if (this == o)
      return true;
    if (o == null || getClass() != o.getClass())
      return false;

    BookRatingId that = (BookRatingId) o;

    return id.equals(that.id);

  }

  @Override public int hashCode()
  {
    return id.hashCode();
  }
}
