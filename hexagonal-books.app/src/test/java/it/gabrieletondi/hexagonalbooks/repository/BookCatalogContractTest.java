package it.gabrieletondi.hexagonalbooks.repository;

import it.gabrieletondi.hexagonalbooks.app.model.Book;
import it.gabrieletondi.hexagonalbooks.app.model.BookId;
import it.gabrieletondi.hexagonalbooks.app.repository.BookCatalog;
import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.nullValue;
import static org.junit.Assert.assertThat;

public abstract class BookCatalogContractTest
{
  private static final BookId UNEXISTING_BOOK_ID = new BookId("999");
  private static final BookId EXISTING_BOOK_ID = new BookId("456");

  @Test
  public void notFound() throws Exception
  {
    assertThat(aBookCatalogWithout(UNEXISTING_BOOK_ID)
                   .bookWithId(UNEXISTING_BOOK_ID), is(nullValue()));
  }

  @Test
  public void found() throws Exception
  {
    assertThat(aBookCatalogWith(EXISTING_BOOK_ID)
                   .bookWithId(EXISTING_BOOK_ID), is(new Book(EXISTING_BOOK_ID)));
  }

  protected abstract BookCatalog aBookCatalogWithout(BookId toExclude);

  protected abstract BookCatalog aBookCatalogWith(BookId toInclude);
}
