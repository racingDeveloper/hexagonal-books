package it.gabrieletondi.hexagonalbooks.console;

public class CommandInterpreter
{
  private final Command command;

  public CommandInterpreter(Command command)
  {
    this.command = command;
  }

  public void interpret(String commandPattern)
  {
    if (!command.recognize(commandPattern))
      throw new CommandNotFoundException();

    command.execute(commandPattern);
  }
}
