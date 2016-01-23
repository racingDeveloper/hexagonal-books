package it.gabrieletondi.hexagonalbooks.app.usecase;

import it.gabrieletondi.hexagonalbooks.app.model.*;
import it.gabrieletondi.hexagonalbooks.app.repository.BookCatalog;
import it.gabrieletondi.hexagonalbooks.app.repository.BookRateRepository;

public class RateBookUseCase
{
  private final BookCatalog catalog;
  private final BookRateRepository bookRateRepository;

  public RateBookUseCase(BookCatalog catalog, BookRateRepository bookRateRepository)
  {
    this.catalog = catalog;
    this.bookRateRepository = bookRateRepository;
  }

  public void execute(RateBookCommand command)
  {
    Book book = catalog.bookWithId(new BookId(command.getBookId()));

    guardBookNotFound(book);

    BookRate rate = book.rate(Rate.value(command.getRate()));
    bookRateRepository.add(rate);
  }

  private void guardBookNotFound(Book book)
  {
    if (book == null)
      throw new BookNotFoundException();
  }
}
