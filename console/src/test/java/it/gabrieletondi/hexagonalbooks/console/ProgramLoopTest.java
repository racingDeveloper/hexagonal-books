package it.gabrieletondi.hexagonalbooks.console;

import it.gabrieletondi.hexagonalbooks.console.command.Command;
import org.jmock.Expectations;
import org.jmock.auto.Mock;
import org.jmock.integration.junit4.JUnitRuleMockery;
import org.junit.Rule;
import org.junit.Test;

import java.io.StringReader;

public class ProgramLoopTest
{
  @Rule
  public JUnitRuleMockery context = new JUnitRuleMockery();

  @Mock
  private Command command1;

  @Mock
  private Command command2;

  @Test
  public void allCommandsRecognized() throws Exception
  {
    ProgramLoop loop = new ProgramLoop(command1, command2);

    context.checking(new Expectations(){{
      allowing(command1).recognize("command1");
      will(returnValue(true));

      allowing(command1).recognize("command2");
      will(returnValue(false));

      allowing(command2).recognize("command2");
      will(returnValue(true));

      allowing(command2).recognize("command1");
      will(returnValue(false));

      oneOf(command1).execute("command1");
      oneOf(command2).execute("command2");
    }});

    loop.run(new StringReader("command1\ncommand2"));
  }
}
