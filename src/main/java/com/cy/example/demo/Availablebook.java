package com.cy.example.demo;

import org.springframework.beans.factory.annotation.Value;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class Availablebook {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @NotNull
    @Size(min=1)
    private String title;

    @NotNull
    @Size(min=3)
    private String author;

    @NotNull
    @Size(min=1)
    private String publicationYr;

    private String isbn;

    private String image;

    @Value("N")
    private String hasbeenBorrowed;


    public Availablebook() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getPublicationYr() {
        return publicationYr;
    }

    public void setPublicationYr(String publicationYr) {
        this.publicationYr = publicationYr;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getHasbeenBorrowed() {
        return hasbeenBorrowed;
    }

    public void setHasbeenBorrowed(String hasbeenBorrowed) {
        this.hasbeenBorrowed = hasbeenBorrowed;
    }
}