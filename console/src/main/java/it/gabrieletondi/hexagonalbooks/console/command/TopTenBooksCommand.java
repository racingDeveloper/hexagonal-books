package it.gabrieletondi.hexagonalbooks.console.command;

import it.gabrieletondi.hexagonalbooks.app.usecase.UseCase;
import it.gabrieletondi.hexagonalbooks.app.usecase.topBooks.TopBooksRequest;
import it.gabrieletondi.hexagonalbooks.app.usecase.topBooks.TopBooksResponse;
import it.gabrieletondi.hexagonalbooks.console.display.Display;
import it.gabrieletondi.hexagonalbooks.console.format.BookStandingsFormatter;

import java.util.regex.Pattern;

import static java.util.regex.Pattern.CASE_INSENSITIVE;

public class TopTenBooksCommand implements Command
{
  private final Pattern pattern = Pattern.compile("Top10\\sBooks", CASE_INSENSITIVE);
  private final UseCase<TopBooksRequest, TopBooksResponse> useCase;
  private final BookStandingsFormatter formatter;
  private final Display display;

  public TopTenBooksCommand(
      UseCase<TopBooksRequest, TopBooksResponse> useCase, BookStandingsFormatter formatter, Display display)
  {
    this.useCase = useCase;
    this.formatter = formatter;
    this.display = display;
  }

  @Override public boolean recognize(String commandPattern)
  {
    return pattern.matcher(commandPattern).matches();
  }

  @Override public void execute(String commandPattern)
  {
    TopBooksResponse response = useCase.execute(new TopBooksRequest(10));
    display.show(formatter.format(response.getStandings()));
  }
}
