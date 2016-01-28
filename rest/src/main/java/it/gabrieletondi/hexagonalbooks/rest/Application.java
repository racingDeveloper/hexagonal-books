package it.gabrieletondi.hexagonalbooks.rest;

import it.gabrieletondi.hexagonalbooks.app.model.Book;
import it.gabrieletondi.hexagonalbooks.app.model.BookId;
import it.gabrieletondi.hexagonalbooks.app.usecase.BookRatingUseCase;
import it.gabrieletondi.hexagonalbooks.app.usecase.UseCase;
import it.gabrieletondi.hexagonalbooks.repository.InMemoryBookCatalog;
import it.gabrieletondi.hexagonalbooks.repository.InMemoryBookRatingRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

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
    return new BookRatingUseCase(
        new InMemoryBookCatalog(
            new Book(new BookId("123456")),
            new Book(new BookId("654321"))),
        new InMemoryBookRatingRepository());
  }
}
