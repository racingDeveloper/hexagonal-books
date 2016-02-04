package it.gabrieletondi.hexagonalbooks.console;

import it.gabrieletondi.hexagonalbooks.app.usecase.TopBooksResponse;
import it.gabrieletondi.hexagonalbooks.app.usecase.TopBooksResponse.BookStandings.BookStandingsItem;

public class PlainTextBookStandingsFormatter implements BookStandingsFormatter
{
  @Override public String format(TopBooksResponse.BookStandings standings)
  {
    StringBuilder builder = new StringBuilder();

    for(int i=0; i<standings.getItems().length; i++)
    {
      builder.append(formatSingleRow(standings.getItems()[i], i+1));
    }

    return builder.toString();
  }

  private String formatSingleRow(BookStandingsItem bookStandingsItem, int position)
  {
    return String.format("%d) %s [%.2f]\n",
                         position,
                         bookStandingsItem.getBookId(),
                         bookStandingsItem.getAvgRating());
  }
}
