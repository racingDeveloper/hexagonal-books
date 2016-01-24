package it.gabrieletondi.hexagonalbooks.console;

import it.gabrieletondi.hexagonalbooks.app.usecase.BookRatingRequest;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class BookRatingCommand implements Command
{
  private final Pattern pattern = Pattern.compile("Book\\sRating\\s(.+)\\s(\\d+)");
  private final UseCase useCase;

  public BookRatingCommand(UseCase useCase)
  {
    this.useCase = useCase;
  }

  @Override public boolean recognize(String commandPattern)
  {
    return pattern.matcher(commandPattern).matches();
  }

  @Override public void execute(String commandPattern)
  {
    Matcher matcher = pattern.matcher(commandPattern);
    matcher.matches();
    String bookId = matcher.group(1);
    int rating = Integer.parseInt(matcher.group(2));

    BookRatingRequest request = new BookRatingRequest(
        bookId,
        rating);

    useCase.execute(request);
  }
}
