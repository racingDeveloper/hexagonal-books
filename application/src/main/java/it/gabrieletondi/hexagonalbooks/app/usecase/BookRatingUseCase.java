package it.gabrieletondi.hexagonalbooks.app.usecase;

import it.gabrieletondi.hexagonalbooks.app.model.*;
import it.gabrieletondi.hexagonalbooks.app.repository.BookCatalog;
import it.gabrieletondi.hexagonalbooks.app.repository.BookRatingRepository;

public class BookRatingUseCase implements UseCase
{
  private final BookCatalog catalog;
  private final BookRatingRepository bookRatingRepository;

  public BookRatingUseCase(BookCatalog catalog, BookRatingRepository bookRatingRepository)
  {
    this.catalog = catalog;
    this.bookRatingRepository = bookRatingRepository;
  }

  public void execute(BookRatingRequest request)
  {
    Book book = aBookFoundWithId(request.getBookId());
    BookRating rate = book.rate(Rating.value(request.getRating()));

    bookRatingRepository.add(rate);
  }

  private Book aBookFoundWithId(String bookId)
  {
    Book book = catalog.bookWithId(new BookId(bookId));

    if (book == null)
      throw new BookNotFoundException();

    return book;
  }
}
