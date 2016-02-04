package it.gabrieletondi.hexagonalbooks.repository;

import it.gabrieletondi.hexagonalbooks.app.model.*;
import it.gabrieletondi.hexagonalbooks.app.repository.RatedBookRepository;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class InMemoryRatedBookRepository implements RatedBookRepository
{
  private final List<BookRating> bookRatings;

  public InMemoryRatedBookRepository(List<BookRating> bookRatings)
  {
    this.bookRatings = bookRatings;
  }

  @Override public List<RatedBook> listAll()
  {
    Stream<BookId> bookIds = bookRatings.stream()
        .map(BookRating::bookId).distinct();

    return bookIds.map(bookId ->
                           new RatedBook(bookId, bookRatings.stream()
                               .filter(bookRating -> bookRating.bookId().equals(bookId))
                               .map(BookRating::rating)
                               .collect(Collectors.toList())))
        .collect(Collectors.toList());
  }
}
