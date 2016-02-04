package it.gabrieletondi.hexagonalbooks.repository;

import it.gabrieletondi.hexagonalbooks.app.model.Book;
import it.gabrieletondi.hexagonalbooks.app.model.BookId;
import it.gabrieletondi.hexagonalbooks.app.repository.BookCatalog;

import java.util.List;

public class InMemoryBookCatalog implements BookCatalog
{
  private final List<Book> books;

  public InMemoryBookCatalog(List<Book> books)
  {
    this.books = books;
  }

  @Override public Book bookWithId(BookId bookId)
  {
    for (Book book : books)
    {
      if (book.hasId(bookId))
        return book;
    }

    return null;
  }
}
