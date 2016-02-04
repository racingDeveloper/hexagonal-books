package it.gabrieletondi.hexagonalbooks.app.usecase;

public interface UseCase<Request, Response>
{
  Response execute(Request command);
}
