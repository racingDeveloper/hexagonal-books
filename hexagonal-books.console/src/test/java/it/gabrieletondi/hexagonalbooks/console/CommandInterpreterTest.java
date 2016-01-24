package it.gabrieletondi.hexagonalbooks.console;

import org.jmock.Expectations;
import org.jmock.auto.Mock;
import org.jmock.integration.junit4.JUnitRuleMockery;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class CommandInterpreterTest
{
  private static final String UNRECOGNIZED_COMMAND_PATTERN = "unrecognized command pattern";
  private static final String RECOGNIZED_COMMAND_PATTERN = "recognized command pattern";

  @Rule
  public JUnitRuleMockery context = new JUnitRuleMockery();

  @Rule
  public ExpectedException expectedException = ExpectedException.none();

  @Mock
  private Command unrecognizedCommand;

  @Mock
  private Command recognizedCommand;

  @Test
  public void commandUnrecognized() throws Exception
  {
    CommandInterpreter interpreter = new CommandInterpreter(unrecognizedCommand);

    context.checking(new Expectations(){{
      allowing(unrecognizedCommand).recognize(UNRECOGNIZED_COMMAND_PATTERN);
      will(returnValue(false));

      never(unrecognizedCommand).execute(UNRECOGNIZED_COMMAND_PATTERN);
    }});

    expectedException.expect(CommandNotFoundException.class);
    interpreter.interpret(UNRECOGNIZED_COMMAND_PATTERN);
  }

  @Test
  public void recognizedCommand() throws Exception
  {
    CommandInterpreter interpreter = new CommandInterpreter(recognizedCommand);

    context.checking(new Expectations(){{
      allowing(recognizedCommand).recognize(RECOGNIZED_COMMAND_PATTERN);
      will(returnValue(true));

      oneOf(recognizedCommand).execute(RECOGNIZED_COMMAND_PATTERN);
    }});

    interpreter.interpret(RECOGNIZED_COMMAND_PATTERN);
  }
}
