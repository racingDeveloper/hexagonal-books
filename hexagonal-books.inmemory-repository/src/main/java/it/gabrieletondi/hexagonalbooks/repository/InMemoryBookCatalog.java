package it.gabrieletondi.hexagonalbooks.repository;

import it.gabrieletondi.hexagonalbooks.app.model.Book;
import it.gabrieletondi.hexagonalbooks.app.model.BookId;
import it.gabrieletondi.hexagonalbooks.app.repository.BookCatalog;

import java.util.List;

import static java.util.Arrays.asList;

public class InMemoryBookCatalog implements BookCatalog
{
  private final List<Book> books;

  public InMemoryBookCatalog(Book... books)
  {
    this.books = asList(books);
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
