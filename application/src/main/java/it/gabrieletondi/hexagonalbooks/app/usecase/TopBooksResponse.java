package it.gabrieletondi.hexagonalbooks.app.usecase;

import java.util.Arrays;

public class TopBooksResponse
{
  private final BookStandings standings;

  public TopBooksResponse(BookStandings standings)
  {
    this.standings = standings;
  }

  public BookStandings getStandings()
  {
    return standings;
  }

  public static class BookStandings
  {
    private final BookStandingsItem[] items;

    public BookStandings(BookStandingsItem... items)
    {
      this.items = items;
    }

    @Override public String toString()
    {
      return "BookStandings{" +
          "items=" + Arrays.toString(items) +
          '}';
    }

    @Override public boolean equals(Object o)
    {
      if (this == o)
        return true;
      if (o == null || getClass() != o.getClass())
        return false;

      BookStandings that = (BookStandings) o;

      return Arrays.equals(items, that.items);
    }

    @Override public int hashCode()
    {
      return Arrays.hashCode(items);
    }

    public static class BookStandingsItem
    {
      private final String bookId;
      private final double avgRating;

      public BookStandingsItem(String bookId, double avgRating)
      {
        this.bookId = bookId;
        this.avgRating = avgRating;
      }

      @Override public String toString()
      {
        return "BookStandingsItem{" +
            "bookId='" + bookId + '\'' +
            ", avgRating=" + avgRating +
            '}';
      }

      @Override public boolean equals(Object o)
      {
        if (this == o)
          return true;
        if (o == null || getClass() != o.getClass())
          return false;

        BookStandingsItem that = (BookStandingsItem) o;

        if (Double.compare(that.avgRating, avgRating) != 0)
          return false;
        return bookId.equals(that.bookId);

      }

      @Override public int hashCode()
      {
        int result;
        long temp;
        result = bookId.hashCode();
        temp = Double.doubleToLongBits(avgRating);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
      }
    }
  }
}
