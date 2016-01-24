package it.gabrieletondi.hexagonalbooks.console;

import it.gabrieletondi.hexagonalbooks.app.usecase.BookRatingRequest;
import it.gabrieletondi.hexagonalbooks.app.usecase.UseCase;
import org.jmock.Expectations;
import org.jmock.auto.Mock;
import org.jmock.integration.junit4.JUnitRuleMockery;
import org.junit.Rule;
import org.junit.Test;

public class BookRatingCommandExecutionTest
{
  @Rule
  public JUnitRuleMockery context = new JUnitRuleMockery();

  @Mock
  private UseCase useCase;

  @Test
  public void executesUseCase() throws Exception
  {
    BookRatingCommand command = new BookRatingCommand(useCase);

    context.checking(new Expectations(){{
      oneOf(useCase).execute(new BookRatingRequest("1234567", 7));
    }});

    command.execute("Book Rating 1234567 7");
  }
}
