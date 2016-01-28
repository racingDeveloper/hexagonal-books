package it.gabrieletondi.hexagonalbooks.rest.e2e;

import it.gabrieletondi.hexagonalbooks.rest.Application;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import javax.annotation.Resource;

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
    mvc = MockMvcBuilders.webAppContextSetup(context).build();
  }

  @Test
  public void bookNotFound() throws Exception
  {
    mvc.perform(post("/book/UNKNOWN_BOOK_ID/rating")
                    .contentType(MediaType.APPLICATION_JSON)
                    .content("{ \"rating\": 3 }"))
        .andExpect(status().is(404));
  }
}
