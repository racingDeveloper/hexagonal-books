package it.gabrieletondi.hexagonalbooks.rest;

import it.gabrieletondi.hexagonalbooks.app.usecase.UseCase;
import it.gabrieletondi.hexagonalbooks.app.usecase.topBooks.TopBooksRequest;
import it.gabrieletondi.hexagonalbooks.app.usecase.topBooks.TopBooksResponse;
import it.gabrieletondi.hexagonalbooks.app.usecase.topBooks.TopBooksResponse.BookStandings;
import it.gabrieletondi.hexagonalbooks.app.usecase.topBooks.TopBooksResponse.BookStandings.BookStandingsItem;
import org.jmock.Expectations;
import org.jmock.auto.Mock;
import org.jmock.integration.junit4.JUnitRuleMockery;
import org.junit.*;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class Top10BookControllerTest
{
  @Rule
  public JUnitRuleMockery context = new JUnitRuleMockery();

  @Mock
  public UseCase<TopBooksRequest, TopBooksResponse> useCase;

  private Top10BookController controller;

  @Before
  public void setUp() throws Exception
  {
    controller = new Top10BookController(useCase);
  }

  @Test
  public void returnsTop10() throws Exception
  {
    TopBooksResponse response = new TopBooksResponse(new BookStandings(new BookStandingsItem("A", 9),
                                                                       new BookStandingsItem("B", 2)));
    context.checking(new Expectations() {{
      allowing(useCase).execute(new TopBooksRequest(10));
      will(returnValue(response));
    }});

    assertThat(controller.top10(), is(response.getStandings().getItems()));
  }
}
