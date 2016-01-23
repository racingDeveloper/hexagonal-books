package it.gabrieletondi.hexagonalbooks.app;

import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class RunnableEnvironmentTest
{
  @Test
  public void environmentIsRunnable() throws Exception
  {
    assertThat(true, is(true));
  }
}
