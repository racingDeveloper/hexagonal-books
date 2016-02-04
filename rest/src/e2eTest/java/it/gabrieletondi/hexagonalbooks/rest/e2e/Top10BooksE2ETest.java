package it.gabrieletondi.hexagonalbooks.rest.e2e;

import it.gabrieletondi.hexagonalbooks.app.model.*;
import it.gabrieletondi.hexagonalbooks.repository.SharedMemory;
import it.gabrieletondi.hexagonalbooks.rest.Application;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import javax.annotation.Resource;

import static java.util.Arrays.asList;
import static org.hamcrest.Matchers.equalTo;
import static org.springframework.http.HttpStatus.OK;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { Application.class })
@WebAppConfiguration
public class Top10BooksE2ETest
{
  @Resource
  private WebApplicationContext context;

  private MockMvc mvc;

  @Before
  public void init()
  {
    SharedMemory.clearAll();
    SharedMemory.bookRatings.addAll(asList(
        new BookRating(new BookRatingId(), new BookId("1234567"), Rating.value(10)),
        new BookRating(new BookRatingId(), new BookId("1234567"), Rating.value(6)),
        new BookRating(new BookRatingId(), new BookId("1234567"), Rating.value(8)),
        new BookRating(new BookRatingId(), new BookId("7654321"), Rating.value(3))
    ));

    mvc = MockMvcBuilders.webAppContextSetup(context).build();
  }

  @Test
  public void standings() throws Exception
  {
    mvc.perform(get("/top10"))
        .andDo(print())
        .andExpect(status().is(OK.value()))
        .andExpect(jsonPath("[0].bookId", equalTo("1234567")))
        .andExpect(jsonPath("[0].avgRating", equalTo(8.0)))
        .andExpect(jsonPath("[1].bookId", equalTo("7654321")))
        .andExpect(jsonPath("[1].avgRating", equalTo(3.0)));
  }
}
