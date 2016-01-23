package it.gabrieletondi.hexagonalbooks.app;

import it.gabrieletondi.hexagonalbooks.app.model.*;
import it.gabrieletondi.hexagonalbooks.app.repository.BookCatalog;
import it.gabrieletondi.hexagonalbooks.app.repository.BookRateRepository;
import it.gabrieletondi.hexagonalbooks.app.usecase.*;
import org.jmock.Expectations;
import org.jmock.auto.Mock;
import org.jmock.integration.junit4.JUnitRuleMockery;
import org.junit.*;
import org.junit.rules.ExpectedException;

public class RateBookTest
{
  private static final BookId UNEXISTING_BOOK_ID = new BookId("unexisting");
  private static final BookId EXISTING_BOOK_ID = new BookId("existing");
  @Rule
  public JUnitRuleMockery context = new JUnitRuleMockery();

  @Rule
  public ExpectedException expectedException = ExpectedException.none();

  @Mock
  private BookCatalog catalog;

  @Mock
  private BookRateRepository bookRateRepository;

  private RateBookUseCase useCase;

  @Before
  public void setUp() throws Exception
  {
    useCase = new RateBookUseCase(catalog, bookRateRepository);
  }

  @Test
  public void bookNotFound() throws Exception
  {
    context.checking(new Expectations(){{
      allowing(catalog).bookWithId(UNEXISTING_BOOK_ID);
      will(returnValue(null));
    }});

    expectedException.expect(BookNotFoundException.class);
    useCase.execute(new RateBookCommand(UNEXISTING_BOOK_ID.id(), 0));
  }

  @Test
  public void bookFound() throws Exception
  {
    context.checking(new Expectations(){{
      allowing(catalog).bookWithId(EXISTING_BOOK_ID);
      will(returnValue(new Book(EXISTING_BOOK_ID)));

      oneOf(bookRateRepository).add(new BookRate(EXISTING_BOOK_ID, Rate.value(3)));
    }});

    useCase.execute(new RateBookCommand(EXISTING_BOOK_ID.id(), 3));
  }
}
