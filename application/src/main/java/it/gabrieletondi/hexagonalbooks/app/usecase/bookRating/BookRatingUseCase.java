package it.gabrieletondi.hexagonalbooks.app.usecase.bookRating;

import it.gabrieletondi.hexagonalbooks.app.model.*;
import it.gabrieletondi.hexagonalbooks.app.repository.BookCatalog;
import it.gabrieletondi.hexagonalbooks.app.repository.BookRatingRepository;
import it.gabrieletondi.hexagonalbooks.app.usecase.UseCase;

public class BookRatingUseCase implements UseCase<BookRatingRequest, BookRatingResponse>
{
  private final BookCatalog catalog;
  private final BookRatingRepository bookRatingRepository;

  public BookRatingUseCase(BookCatalog catalog, BookRatingRepository bookRatingRepository)
  {
    this.catalog = catalog;
    this.bookRatingRepository = bookRatingRepository;
  }

  public BookRatingResponse execute(BookRatingRequest request)
  {
    Book book = aBookFoundWithId(request.getBookId());
    BookRating rate = book.rate(Rating.value(request.getRating()));

    bookRatingRepository.add(rate);

    return new BookRatingResponse();
  }

  private Book aBookFoundWithId(String bookId)
  {
    Book book = catalog.bookWithId(new BookId(bookId));

    if (book == null)
      throw new BookNotFoundException();

    return book;
  }
}
