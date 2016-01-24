package it.gabrieletondi.hexagonalbooks.console;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

@RunWith(Parameterized.class)
public class BookRatingRecognizeCommandTest
{

  @Parameterized.Parameters(name = "{0}")
  public static Collection<Object[]> data() {
    return Arrays.asList(new Object[][] {
        { "Book Rating 1234567 7", true },
        { "Book Rating 1234567 acv", false },
        { "Book Rating A_BOOK_ID 3", true },
    });
  }

  private final BookRatingCommand command = new BookRatingCommand(null);

  private String pattern;
  private boolean shouldBeRecognized;

  public BookRatingRecognizeCommandTest(String pattern, boolean shouldBeRecognized)
  {
    this.pattern = pattern;
    this.shouldBeRecognized = shouldBeRecognized;
  }

  @Test
  public void test()
  {
    assertThat(command.recognize(pattern), is(shouldBeRecognized));
  }
}
