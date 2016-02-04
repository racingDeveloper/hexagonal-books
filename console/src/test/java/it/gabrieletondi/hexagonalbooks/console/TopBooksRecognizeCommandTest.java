package it.gabrieletondi.hexagonalbooks.console;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

@RunWith(Parameterized.class)
public class TopBooksRecognizeCommandTest
{

  @Parameterized.Parameters(name = "{0}")
  public static Collection<Object[]> data() {
    return Arrays.asList(new Object[][] {
        { "Top10 Books", true },
        { "top10 books", true },
        { "topbooks", false },
        { "top books argument", false },
        { "bla bla bla", false },
    });
  }

  private final TopTenBooksCommand command = new TopTenBooksCommand(null, null, null);

  private String pattern;
  private boolean shouldBeRecognized;

  public TopBooksRecognizeCommandTest(String pattern, boolean shouldBeRecognized)
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
