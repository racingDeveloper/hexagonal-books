package it.gabrieletondi.hexagonalbooks.console;

import it.gabrieletondi.hexagonalbooks.app.usecase.TopBooksResponse;
import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class PlainTextBookStandingsFormatterTest
{
  @Test
  public void formatsMultipleItemsStandings() throws Exception
  {
    TopBooksResponse.BookStandings standings = new TopBooksResponse.BookStandings(
        new TopBooksResponse.BookStandings.BookStandingsItem("BOOK_A", 8.67),
        new TopBooksResponse.BookStandings.BookStandingsItem("BOOK_B", 4),
        new TopBooksResponse.BookStandings.BookStandingsItem("BOOK_C", 3.45),
        new TopBooksResponse.BookStandings.BookStandingsItem("BOOK_D", 2.94)
    );

    String formatted = new PlainTextBookStandingsFormatter().format(standings);
    String expectedFormatted =
        "1) BOOK_A [8.67]" + "\n" +
        "2) BOOK_B [4.00]" + "\n" +
        "3) BOOK_C [3.45]" + "\n" +
        "4) BOOK_D [2.94]" + "\n";

    assertThat(formatted, is(expectedFormatted));
  }
}
