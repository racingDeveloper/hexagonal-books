package it.gabrieletondi.hexagonalbooks.repository;

import it.gabrieletondi.hexagonalbooks.app.model.Book;
import it.gabrieletondi.hexagonalbooks.app.model.BookId;
import it.gabrieletondi.hexagonalbooks.app.repository.BookCatalog;

import static java.util.Arrays.asList;

public class InMemoryBookCatalogTest extends BookCatalogContractTest
{
  @Override protected BookCatalog aBookCatalogWithout(BookId toExclude)
  {
    return new InMemoryBookCatalog(asList(
        new Book(new BookId("not " + toExclude.id())),
        new Book(new BookId("definitely not " + toExclude.id()))
    ));
  }

  @Override protected BookCatalog aBookCatalogWith(BookId toInclude)
  {
    return new InMemoryBookCatalog(asList(
        new Book(new BookId("not " + toInclude.id())),
        new Book(toInclude),
        new Book(new BookId("definitely not " + toInclude.id()))
    ));
  }
}
