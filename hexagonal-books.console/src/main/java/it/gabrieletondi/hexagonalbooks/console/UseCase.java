package it.gabrieletondi.hexagonalbooks.console;

import it.gabrieletondi.hexagonalbooks.app.usecase.BookRatingRequest;

public interface UseCase
{
  void execute(BookRatingRequest command);
}
