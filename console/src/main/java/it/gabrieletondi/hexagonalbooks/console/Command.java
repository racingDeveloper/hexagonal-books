package it.gabrieletondi.hexagonalbooks.console;

public interface Command
{
  boolean recognize(String commandPattern);

  void execute(String commandPattern);
}
