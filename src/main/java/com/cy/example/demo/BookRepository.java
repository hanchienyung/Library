package com.cy.example.demo;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface BookRepository extends CrudRepository<Book, Long>{
    List<Book> findBookByTitle(String title);
    List<Book> findBookByHasbeenBorrowed(String hasbeenBorrowed);
    List<Book> findBookById(long id);
}
