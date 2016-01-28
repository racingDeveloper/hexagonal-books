package it.gabrieletondi.hexagonalbooks.rest;

import it.gabrieletondi.hexagonalbooks.app.usecase.*;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.inject.Inject;

@RestController
@RequestMapping(value = "/book/{bookId}/rating")
public class BookRatingController
{
  private final UseCase useCase;

  @Inject
  public BookRatingController(UseCase bookRatingUseCase)
  {
    this.useCase = bookRatingUseCase;
  }

  @RequestMapping(method = RequestMethod.POST)
  @ResponseStatus(value = HttpStatus.OK)
  public void rateBook(@PathVariable String bookId, @RequestBody BookRatingDTO bookRatingDTO)
  {
    useCase.execute(new BookRatingRequest(bookId, bookRatingDTO.getRating()));
  }

  @ExceptionHandler(value = BookNotFoundException.class)
  @ResponseStatus(value = HttpStatus.NOT_FOUND)
  public void exceptionHandler(BookNotFoundException e)
  {
  }
}
