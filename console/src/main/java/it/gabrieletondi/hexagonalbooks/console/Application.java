package it.gabrieletondi.hexagonalbooks.console;

import it.gabrieletondi.hexagonalbooks.app.model.Book;
import it.gabrieletondi.hexagonalbooks.app.model.BookId;
import it.gabrieletondi.hexagonalbooks.app.usecase.bookRating.BookRatingUseCase;
import it.gabrieletondi.hexagonalbooks.app.usecase.topBooks.TopBooksUseCase;
import it.gabrieletondi.hexagonalbooks.console.command.BookRatingCommand;
import it.gabrieletondi.hexagonalbooks.console.command.TopTenBooksCommand;
import it.gabrieletondi.hexagonalbooks.console.display.ConsoleDisplay;
import it.gabrieletondi.hexagonalbooks.console.format.PlainTextBookStandingsFormatter;
import it.gabrieletondi.hexagonalbooks.repository.*;

import java.io.InputStreamReader;

import static java.util.Arrays.asList;

public class Application
{
  public static void main(String[] args)
  {
    SharedMemory.books.addAll(asList(new Book(new BookId("1234567")),
                                     new Book(new BookId("7654321"))));

    new ProgramLoop(
        new BookRatingCommand(
            new BookRatingUseCase(
                new InMemoryBookCatalog(SharedMemory.books),
                new InMemoryBookRatingRepository(SharedMemory.bookRatings)
            ), new ConsoleDisplay()),
        new TopTenBooksCommand(
            new TopBooksUseCase(
                new InMemoryRatedBookRepository(SharedMemory.bookRatings)
            ),
            new PlainTextBookStandingsFormatter(),
            new ConsoleDisplay()
        )
    ).run(new InputStreamReader(System.in));
  }
}
