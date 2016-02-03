package it.gabrieletondi.hexagonalbooks.app;

import it.gabrieletondi.hexagonalbooks.app.model.*;
import it.gabrieletondi.hexagonalbooks.app.repository.BookCatalog;
import it.gabrieletondi.hexagonalbooks.app.repository.BookRatingRepository;
import it.gabrieletondi.hexagonalbooks.app.usecase.*;
import org.hamcrest.*;
import org.jmock.Expectations;
import org.jmock.auto.Mock;
import org.jmock.integration.junit4.JUnitRuleMockery;
import org.junit.*;
import org.junit.rules.ExpectedException;

public class RatingBookTest
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
  private BookRatingRepository bookRatingRepository;

  private BookRatingUseCase useCase;

  @Before
  public void setUp() throws Exception
  {
    useCase = new BookRatingUseCase(catalog, bookRatingRepository);
  }

  @Test
  public void bookNotFound() throws Exception
  {
    context.checking(new Expectations(){{
      allowing(catalog).bookWithId(UNEXISTING_BOOK_ID);
      will(returnValue(null));
    }});

    expectedException.expect(BookNotFoundException.class);
    useCase.execute(new BookRatingRequest(UNEXISTING_BOOK_ID.id(), 0));
  }

  @Test
  public void bookFound() throws Exception
  {
    context.checking(new Expectations(){{
      allowing(catalog).bookWithId(EXISTING_BOOK_ID);
      will(returnValue(new Book(EXISTING_BOOK_ID)));

      oneOf(bookRatingRepository).add(with(aRatingFor(EXISTING_BOOK_ID, Rating.value(3))));
    }});

    useCase.execute(new BookRatingRequest(EXISTING_BOOK_ID.id(), 3));
  }

  private Matcher<BookRating> aRatingFor(BookId expectedBook, Rating expectedValue)
  {
    return new TypeSafeMatcher<BookRating>()
    {
      @Override protected boolean matchesSafely(BookRating item)
      {
        return item.bookId().equals(expectedBook) && item.rating().equals(expectedValue);
      }

      @Override public void describeTo(Description description)
      {
        description.appendValue(expectedBook).appendValue(expectedValue);
      }
    };
  }

}
