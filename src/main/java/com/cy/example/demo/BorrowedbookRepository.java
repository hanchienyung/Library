package com.cy.example.demo;

import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.ListIterator;

public interface BorrowedbookRepository extends CrudRepository<Book, Long>{
    ListIterator<Borrowedbook> findByHasbeenBorrowed (String hasbeenBorrowed);
}