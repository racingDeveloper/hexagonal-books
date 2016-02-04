package it.gabrieletondi.hexagonalbooks.console;

import it.gabrieletondi.hexagonalbooks.app.usecase.UseCase;
import it.gabrieletondi.hexagonalbooks.app.usecase.bookRating.BookNotFoundException;
import it.gabrieletondi.hexagonalbooks.app.usecase.bookRating.BookRatingRequest;
import org.jmock.Expectations;
import org.jmock.auto.Mock;
import org.jmock.integration.junit4.JUnitRuleMockery;
import org.junit.*;

public class BookRatingCommandExecutionTest
{
  @Rule
  public JUnitRuleMockery context = new JUnitRuleMockery();

  @Mock
  private UseCase useCase;

  @Mock
  private Display display;

  private BookRatingCommand command;

  @Before
  public void setUp() throws Exception
  {
    command = new BookRatingCommand(useCase, display);
  }

  @Test
  public void successfulExecution() throws Exception
  {
    context.checking(new Expectations(){{
      oneOf(useCase).execute(new BookRatingRequest("1234567", 7));
    }});

    command.execute("Book Rating 1234567 7");
  }

  @Test
  public void bookNotFound() throws Exception
  {
    context.checking(new Expectations(){{
      allowing(useCase).execute(with(any(BookRatingRequest.class)));
      will(throwException(new BookNotFoundException()));

      oneOf(display).show("Book not found!");
    }});

    // SMELL: I need to pass in a valid pattern in the execution
    // even if I don't need it
    command.execute("Book Rating 1234567 7");
  }
}
