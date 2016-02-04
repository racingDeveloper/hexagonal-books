package it.gabrieletondi.hexagonalbooks.console.format;

import it.gabrieletondi.hexagonalbooks.app.usecase.topBooks.TopBooksResponse;

public interface BookStandingsFormatter
{
  String format(TopBooksResponse.BookStandings standings);
}
