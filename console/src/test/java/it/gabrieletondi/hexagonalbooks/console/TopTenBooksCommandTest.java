package it.gabrieletondi.hexagonalbooks.console;

import it.gabrieletondi.hexagonalbooks.app.usecase.*;
import org.jmock.Expectations;
import org.jmock.auto.Mock;
import org.jmock.integration.junit4.JUnitRuleMockery;
import org.junit.Rule;
import org.junit.Test;

public class TopTenBooksCommandTest
{
  private static final String FORMATTED_STANDINGS = "FORMATTED_STANDINGS";

  @Rule
  public JUnitRuleMockery context = new JUnitRuleMockery();

  @Mock
  private UseCase<TopBooksRequest, TopBooksResponse> useCase;

  @Mock
  private BookStandingsFormatter formatter;

  @Mock
  private Display display;

  @Test
  public void outputsTopBooks() throws Exception
  {
    TopBooksResponse response = new TopBooksResponse(new TopBooksResponse.BookStandings());

    context.checking(new Expectations(){{
      allowing(useCase).execute(new TopBooksRequest(10));
      will(returnValue(response));

      allowing(formatter).format(response.getStandings());
      will(returnValue(FORMATTED_STANDINGS));

      oneOf(display).show(FORMATTED_STANDINGS);
    }});

    new TopTenBooksCommand(useCase, formatter, display).execute(null);
  }
}
