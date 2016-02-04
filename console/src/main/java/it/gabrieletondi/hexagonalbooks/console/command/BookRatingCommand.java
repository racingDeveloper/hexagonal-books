package it.gabrieletondi.hexagonalbooks.console.command;

import it.gabrieletondi.hexagonalbooks.app.usecase.UseCase;
import it.gabrieletondi.hexagonalbooks.app.usecase.bookRating.BookNotFoundException;
import it.gabrieletondi.hexagonalbooks.app.usecase.bookRating.BookRatingRequest;
import it.gabrieletondi.hexagonalbooks.console.display.Display;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class BookRatingCommand implements Command
{
  private final Pattern pattern = Pattern.compile("Book\\sRating\\s(.+)\\s(\\d+)");
  private final UseCase useCase;
  private final Display display;

  public BookRatingCommand(UseCase useCase, Display display)
  {
    this.useCase = useCase;
    this.display = display;
  }

  @Override public boolean recognize(String commandPattern)
  {
    return pattern.matcher(commandPattern).matches();
  }

  @Override public void execute(String commandPattern)
  {
    try
    {
      useCase.execute(buildUseCaseRequest(commandPattern));
    }
    catch (BookNotFoundException e)
    {
      display.show("Book not found!");
    }
  }

  private BookRatingRequest buildUseCaseRequest(String commandPattern)
  {
    Matcher matcher = pattern.matcher(commandPattern);
    matcher.matches();
    String bookId = matcher.group(1);
    int rating = Integer.parseInt(matcher.group(2));

    return new BookRatingRequest(bookId, rating);
  }
}
