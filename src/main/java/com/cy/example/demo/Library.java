package com.cy.example.demo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class Library {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @NotNull
    @Size(min=1)
    private String name;

    public Library() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }



   /* public boolean addBook(String title,
                           String author,
                           String publication_yr,
                           String ISBN,
                           String image
                           ){
        boolean success = false;
        return success;
    }

    public boolean borrowBook(Book book){
        boolean success = false;
        return success;
    }

    public boolean returnBook(Book book){
        boolean success = false;
        return success;
    }
    */
}
