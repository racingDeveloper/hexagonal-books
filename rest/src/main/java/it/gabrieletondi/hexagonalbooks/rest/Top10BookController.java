package it.gabrieletondi.hexagonalbooks.rest;

import it.gabrieletondi.hexagonalbooks.app.usecase.*;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.inject.Inject;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

@RestController
@RequestMapping(value = "/top10")
public class Top10BookController
{
  private final UseCase<TopBooksRequest, TopBooksResponse> useCase;

  @Inject
  public Top10BookController(UseCase<TopBooksRequest, TopBooksResponse> topBookUseCase)
  {
    this.useCase = topBookUseCase;
  }

  @RequestMapping(method = GET)
  public TopBooksResponse.BookStandings.BookStandingsItem[] top10()
  {
    TopBooksResponse response = useCase.execute(new TopBooksRequest(10));
    return response.getStandings().getItems();
  }
}
