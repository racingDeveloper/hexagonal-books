package it.gabrieletondi.hexagonalbooks.rest;

import it.gabrieletondi.hexagonalbooks.app.usecase.*;
import org.springframework.web.bind.annotation.*;

import javax.inject.Inject;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.NOT_FOUND;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

@RestController
@RequestMapping(value = "/book/{bookId}/rating")
public class BookRatingController
{
  private final UseCase<BookRatingRequest, BookRatingResponse> useCase;

  @Inject
  public BookRatingController(UseCase<BookRatingRequest, BookRatingResponse> bookRatingUseCase)
  {
    this.useCase = bookRatingUseCase;
  }

  @RequestMapping(method = POST)
  @ResponseStatus(value = CREATED)
  public void rateBook(@PathVariable String bookId, @RequestBody BookRatingDTO bookRatingDTO)
  {
    useCase.execute(new BookRatingRequest(bookId, bookRatingDTO.getRating()));
  }

  @ExceptionHandler(value = BookNotFoundException.class)
  @ResponseStatus(value = NOT_FOUND)
  public void exceptionHandler(BookNotFoundException e)
  {
  }
}
