package it.gabrieletondi.hexagonalbooks.app.model;

public class Rating
{
  private final int value;

  private Rating(int value)
  {
    guardInvalidRatingValue(value);
    this.value = value;
  }

  private void guardInvalidRatingValue(int value)
  {
    if (value < 0 || value > 10)
      throw new IllegalArgumentException();
  }

  public static Rating value(int value)
  {
    return new Rating(value);
  }

  @Override public String toString()
  {
    return "Rating{" +
        "value=" + value +
        '}';
  }

  @Override public boolean equals(Object o)
  {
    if (this == o)
      return true;
    if (o == null || getClass() != o.getClass())
      return false;

    Rating rating = (Rating) o;

    return value == rating.value;

  }

  @Override public int hashCode()
  {
    return value;
  }
}
