package it.gabrieletondi.hexagonalbooks.app.usecase;

import it.gabrieletondi.hexagonalbooks.app.model.*;
import it.gabrieletondi.hexagonalbooks.app.repository.RatedBookRepository;
import org.jmock.Expectations;
import org.jmock.auto.Mock;
import org.jmock.integration.junit4.JUnitRuleMockery;
import org.junit.*;

import java.util.List;

import static java.util.Arrays.asList;
import static java.util.Collections.singletonList;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class TopBooksUseCaseTest
{
  private static final String BOOK_A = "BOOK_A";
  private static final String BOOK_B = "BOOK_B";
  private static final String BOOK_C = "BOOK_C";

  @Rule
  public JUnitRuleMockery context = new JUnitRuleMockery();

  @Mock
  private RatedBookRepository repository;

  private TopBooksUseCase useCase;

  @Before
  public void setUp() throws Exception
  {
    useCase = new TopBooksUseCase(repository);
  }

  @Test
  public void returnsStandings() throws Exception
  {
    List<RatedBook> ratedBooks = asList(
        new RatedBook(
            new BookId(BOOK_A),
            asList(
                Rating.value(1),
                Rating.value(3)
            )
        ),
        new RatedBook(
            new BookId(BOOK_B),
            singletonList(Rating.value(10))
        ),
        new RatedBook(
            new BookId(BOOK_C),
            asList(
                Rating.value(5),
                Rating.value(7),
                Rating.value(6)
            )
        )
    );

    context.checking(new Expectations(){{
      allowing(repository).listAll();
      will(returnValue(ratedBooks));
    }});

    TopBooksResponse response = useCase.execute(new TopBooksRequest(2));

    TopBooksResponse.BookStandings expectedStandings = new TopBooksResponse.BookStandings(
        new TopBooksResponse.BookStandings.BookStandingsItem(BOOK_B, 10),
        new TopBooksResponse.BookStandings.BookStandingsItem(BOOK_C, 6)
    );

    assertThat(response.getStandings(), is(expectedStandings));
  }
}
