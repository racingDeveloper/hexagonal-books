package it.gabrieletondi.hexagonalbooks.rest.e2e;

import it.gabrieletondi.hexagonalbooks.app.model.Book;
import it.gabrieletondi.hexagonalbooks.app.model.BookId;
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
import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.NOT_FOUND;
import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {Application.class})
@WebAppConfiguration
public class BookRatingE2ETest
{
  @Resource
  private WebApplicationContext context;

  private MockMvc mvc;

  @Before
  public void init()
  {
    SharedMemory.clearAll();
    SharedMemory.books.addAll(asList(new Book(new BookId("123456")),
                                     new Book(new BookId("654321"))));

    mvc = MockMvcBuilders.webAppContextSetup(context).build();
  }

  @Test
  public void bookNotFound() throws Exception
  {
    mvc.perform(post("/book/UNKNOWN_BOOK_ID/rating")
                    .contentType(APPLICATION_JSON)
                    .content("{ \"rating\": 3 }"))
        .andExpect(status().is(NOT_FOUND.value()));
  }

  @Test
  public void bookFound() throws Exception
  {
    mvc.perform(post("/book/123456/rating")
                    .contentType(APPLICATION_JSON)
                    .content("{ \"rating\": 3 }"))
        .andExpect(status().is(CREATED.value()));
  }
}
