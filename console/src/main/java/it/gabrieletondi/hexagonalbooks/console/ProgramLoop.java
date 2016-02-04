package it.gabrieletondi.hexagonalbooks.console;

import it.gabrieletondi.hexagonalbooks.console.command.Command;

import java.io.BufferedReader;
import java.io.Reader;
import java.util.List;

import static java.util.Arrays.asList;

public class ProgramLoop
{
  private final List<Command> commands;

  public ProgramLoop(Command... commands)
  {
    this.commands = asList(commands);
  }

  public void run(Reader reader)
  {
    new BufferedReader(reader)
        .lines()
        .forEach(line -> commands.stream()
            .filter(command -> command.recognize(line))
            .forEach(command -> command.execute(line))
        );
  }
}
