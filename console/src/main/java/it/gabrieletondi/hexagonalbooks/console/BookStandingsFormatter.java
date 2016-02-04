package it.gabrieletondi.hexagonalbooks.console;

import it.gabrieletondi.hexagonalbooks.app.usecase.TopBooksResponse;

public interface BookStandingsFormatter
{
  String format(TopBooksResponse.BookStandings standings);
}
