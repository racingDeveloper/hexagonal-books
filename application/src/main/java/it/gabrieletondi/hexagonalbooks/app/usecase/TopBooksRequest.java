package it.gabrieletondi.hexagonalbooks.app.usecase;

public class TopBooksRequest
{
  private final int topBooksCount;

  public TopBooksRequest(int topBooksCount)
  {
    this.topBooksCount = topBooksCount;
  }

  public int getTopBooksCount()
  {
    return topBooksCount;
  }

  @Override public String toString()
  {
    return "TopBooksRequest{" +
        "topBooksCount=" + topBooksCount +
        '}';
  }

  @Override public boolean equals(Object o)
  {
    if (this == o)
      return true;
    if (o == null || getClass() != o.getClass())
      return false;

    TopBooksRequest that = (TopBooksRequest) o;

    return topBooksCount == that.topBooksCount;

  }

  @Override public int hashCode()
  {
    return topBooksCount;
  }
}
