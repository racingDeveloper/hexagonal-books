package it.gabrieletondi.hexagonalbooks.console.display;

public class ConsoleDisplay implements Display
{
  @Override public void show(String message)
  {
    System.out.println(message);
  }
}
