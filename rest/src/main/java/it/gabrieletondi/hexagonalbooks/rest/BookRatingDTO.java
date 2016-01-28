package it.gabrieletondi.hexagonalbooks.rest;

public class BookRatingDTO
{
  private int rating;

  public BookRatingDTO()
  {
  }

  public BookRatingDTO(int rating)
  {
    this.rating = rating;
  }

  public int getRating()
  {
    return rating;
  }

  public void setRating(int rating)
  {
    this.rating = rating;
  }
}
