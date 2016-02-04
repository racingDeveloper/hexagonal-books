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
    BookStandingsItem[] items = repository.listAll()
        .stream()
        .sorted((r1, r2) -> Double.compare(r2.avgRating(), r1.avgRating()))
        .limit(command.getTopBooksCount())
        .map(ratedBook -> new BookStandingsItem(ratedBook.bookId().id(), ratedBook.avgRating()))
        .toArray(BookStandingsItem[]::new);

    return new TopBooksResponse(new BookStandings(items));
  }
}
