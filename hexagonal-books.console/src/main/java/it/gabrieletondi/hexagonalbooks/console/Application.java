package it.gabrieletondi.hexagonalbooks.console;

import it.gabrieletondi.hexagonalbooks.app.model.Book;
import it.gabrieletondi.hexagonalbooks.app.model.BookId;
import it.gabrieletondi.hexagonalbooks.app.usecase.BookRatingUseCase;
import it.gabrieletondi.hexagonalbooks.repository.InMemoryBookCatalog;
import it.gabrieletondi.hexagonalbooks.repository.InMemoryBookRatingRepository;

import java.io.InputStreamReader;

public class Application
{
  public static void main(String[] args)
  {
    Book[] books = { new Book(new BookId("1234567")), new Book(new BookId("7654321")) };

    new ProgramLoop(
        new BookRatingCommand(
            new BookRatingUseCase(
                new InMemoryBookCatalog(books),
                new InMemoryBookRatingRepository()
            ))).run(new InputStreamReader(System.in));
  }
}
