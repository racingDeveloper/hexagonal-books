package it.gabrieletondi.hexagonalbooks.app.repository;

import it.gabrieletondi.hexagonalbooks.app.model.RatedBook;

import java.util.List;

public interface RatedBookRepository
{
  List<RatedBook> listAll();
}
