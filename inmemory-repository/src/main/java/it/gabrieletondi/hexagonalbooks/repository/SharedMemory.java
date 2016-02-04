package it.gabrieletondi.hexagonalbooks.repository;

import it.gabrieletondi.hexagonalbooks.app.model.Book;
import it.gabrieletondi.hexagonalbooks.app.model.BookRating;

import java.util.ArrayList;
import java.util.List;

public class SharedMemory
{
  public static List<Book> books = new ArrayList<>();
  public static List<BookRating> bookRatings = new ArrayList<>();

  private SharedMemory()
  {
  }

  public static void clearAll()
  {
    books.clear();
    bookRatings.clear();
  }
}
