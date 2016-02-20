package it.gabrieletondi.hexagonalbooks.app.usecase.topBooks;

import it.gabrieletondi.hexagonalbooks.app.repository.RatedBookRepository;
import it.gabrieletondi.hexagonalbooks.app.usecase.UseCase;
import it.gabrieletondi.hexagonalbooks.app.usecase.topBooks.TopBooksResponse.BookStandings;
import it.gabrieletondi.hexagonalbooks.app.usecase.topBooks.TopBooksResponse.BookStandings.BookStandingsItem;

public class TopBooksUseCase implements UseCase<TopBooksRequest, TopBooksResponse>
{
  private final RatedBookRepository repository;

  public TopBooksUseCase(RatedBookRepository repository)
  {
    this.repository = repository;
  }

  @Override public TopBooksResponse execute(TopBooksRequest command)
  {
    // REFACTOR: maybe this could be an object, extract me and show
    // decoupling between clients and inner hexagon
    BookStandingsItem[] items = repository.listAll()
        .stream()
        .sorted((r1, r2) -> Double.compare(r2.avgRating(), r1.avgRating()))
        .limit(command.getTopBooksCount())
        .map(ratedBook -> new BookStandingsItem(ratedBook.bookId().id(), ratedBook.avgRating()))
        .toArray(BookStandingsItem[]::new);

    return new TopBooksResponse(new BookStandings(items));
  }
}
