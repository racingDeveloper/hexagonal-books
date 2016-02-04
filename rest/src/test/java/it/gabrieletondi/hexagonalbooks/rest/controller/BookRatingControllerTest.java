package it.gabrieletondi.hexagonalbooks.rest.controller;

import it.gabrieletondi.hexagonalbooks.app.usecase.UseCase;
import it.gabrieletondi.hexagonalbooks.app.usecase.bookRating.*;
import org.jmock.Expectations;
import org.jmock.auto.Mock;
import org.jmock.integration.junit4.JUnitRuleMockery;
import org.junit.*;
import org.junit.rules.ExpectedException;

public class BookRatingControllerTest
{
  private static final String A_BOOK_ID = "A_BOOK_ID";
  private static final int A_RATING = 3;
  private static final String UNKNOWN_BOOK_ID = "UNKNOWN_BOOK_ID";

  @Rule
  public JUnitRuleMockery context = new JUnitRuleMockery();

  @Rule
  public ExpectedException expectedException = ExpectedException.none();

  @Mock
  public UseCase<BookRatingRequest, BookRatingResponse> useCase;

  private BookRatingController controller;

  @Before
  public void setUp() throws Exception
  {
    controller = new BookRatingController(useCase);
  }

  @Test
  public void successful() throws Exception
  {
    context.checking(new Expectations(){{
      oneOf(useCase).execute(new BookRatingRequest(A_BOOK_ID, A_RATING));
    }});

    controller.rateBook(A_BOOK_ID, new BookRatingDTO(A_RATING));
  }

  @Test
  public void bookNotFound() throws Exception
  {
    context.checking(new Expectations(){{
      allowing(useCase).execute(new BookRatingRequest(UNKNOWN_BOOK_ID, A_RATING));
      will(throwException(new BookNotFoundException()));
    }});

    expectedException.expect(BookNotFoundException.class);

    controller.rateBook(UNKNOWN_BOOK_ID, new BookRatingDTO(A_RATING));
  }
}
