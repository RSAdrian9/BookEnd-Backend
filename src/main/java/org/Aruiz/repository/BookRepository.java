package org.Aruiz.repository;

import org.Aruiz.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book, Integer> {
    List<Book> findByTitle(String title);

    List<Book> findByIsbn(String isbn);

}

