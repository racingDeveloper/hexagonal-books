package it.gabrieletondi.hexagonalbooks.rest;

import it.gabrieletondi.hexagonalbooks.app.model.Book;
import it.gabrieletondi.hexagonalbooks.app.model.BookId;
import it.gabrieletondi.hexagonalbooks.app.usecase.BookRatingUseCase;
import it.gabrieletondi.hexagonalbooks.app.usecase.UseCase;
import it.gabrieletondi.hexagonalbooks.repository.*;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import static java.util.Arrays.asList;

@SpringBootApplication
@Configuration
public class Application
{
  public static void main(String[] args) throws Exception
  {
    SpringApplication.run(Application.class, args);
  }

  @Bean
  public UseCase bookRatingUseCase()
  {
    SharedMemory.books.addAll(asList(new Book(new BookId("123456")),
                                     new Book(new BookId("654321"))));

    return new BookRatingUseCase(
        new InMemoryBookCatalog(SharedMemory.books),
        new InMemoryBookRatingRepository(SharedMemory.bookRatings));
  }
}
