package it.gabrieletondi.hexagonalbooks.app.usecase;

import it.gabrieletondi.hexagonalbooks.app.model.*;
import it.gabrieletondi.hexagonalbooks.app.repository.BookCatalog;
import it.gabrieletondi.hexagonalbooks.app.repository.BookRatingRepository;

public class BookRatingUseCase
{
  private final BookCatalog catalog;
  private final BookRatingRepository bookRatingRepository;

  public BookRatingUseCase(BookCatalog catalog, BookRatingRepository bookRatingRepository)
  {
    this.catalog = catalog;
    this.bookRatingRepository = bookRatingRepository;
  }

  public void execute(BookRatingCommand command)
  {
    Book book = catalog.bookWithId(new BookId(command.getBookId()));

    guardBookNotFound(book);

    BookRating rate = book.rate(Rating.value(command.getRating()));
    bookRatingRepository.add(rate);
  }

  private void guardBookNotFound(Book book)
  {
    if (book == null)
      throw new BookNotFoundException();
  }
}
