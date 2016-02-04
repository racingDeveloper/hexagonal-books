package it.gabrieletondi.hexagonalbooks.console;

import it.gabrieletondi.hexagonalbooks.app.model.Book;
import it.gabrieletondi.hexagonalbooks.app.model.BookId;
import it.gabrieletondi.hexagonalbooks.app.usecase.BookRatingUseCase;
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
            ), new ConsoleDisplay()))
        .run(new InputStreamReader(System.in));
  }
}
