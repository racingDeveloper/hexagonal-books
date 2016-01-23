package it.gabrieletondi.hexagonalbooks.app.repository;

import it.gabrieletondi.hexagonalbooks.app.model.Book;
import it.gabrieletondi.hexagonalbooks.app.model.BookId;

public interface BookCatalog
{
  Book bookWithId(BookId bookId);
}
