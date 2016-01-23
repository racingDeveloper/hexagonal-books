package it.gabrieletondi.hexagonalbooks.app.model;

public class Rate
{
  private final int value;

  private Rate(int value)
  {
    this.value = value;
  }

  public static Rate value(int value)
  {
    return new Rate(value);
  }

  @Override public String toString()
  {
    return "Rate{" +
        "value=" + value +
        '}';
  }

  @Override public boolean equals(Object o)
  {
    if (this == o)
      return true;
    if (o == null || getClass() != o.getClass())
      return false;

    Rate rate = (Rate) o;

    return value == rate.value;

  }

  @Override public int hashCode()
  {
    return value;
  }
}
