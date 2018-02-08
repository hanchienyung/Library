package com.cy.example.demo;

import org.springframework.data.repository.CrudRepository;

import java.awt.print.Book;
import java.util.ListIterator;

public interface AvailablebookRepository extends CrudRepository<Availablebook, Long>{
    ListIterator<Availablebook> findByHasbeenBorrowed (String hasbeenBorrowed);

}
