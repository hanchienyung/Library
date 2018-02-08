package com.cy.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
public class LibraryController {

    @Autowired
    LibraryRepository libraryRepository;

    @Autowired
    BookRepository bookRepository;

     @RequestMapping("/")
     public String listLibraries(Model model) {
         model.addAttribute("libraries", libraryRepository.findAll());
         return "mainpage";
     }

    @RequestMapping("/listbook")
    public String listbookForm(Model model) {
        model.addAttribute("book", bookRepository.findAll());
        return "listbook";
    }

    @RequestMapping("/addlibrary")
    public String libraryForm(Model model) {
        model.addAttribute("library", new Library());
        return "libraryform";
    }

    @RequestMapping("/addbook")
    public String bookForm(Model model) {
        model.addAttribute("book", new Book());
        return "addbookform";
    }

    @RequestMapping("/borrowbook")
    public String borrowbookForm(Model model) {
        model.addAttribute("book", new Book());
        return "borrowbookform";
    }

    @RequestMapping("/returnbook")
    public String returnbookForm(Model model) {
        model.addAttribute("book", new Book());
        return "returnbookform";
    }

    @PostMapping("/process")
    public String processForm(@Valid Library library, BindingResult result)
    {
        if (result.hasErrors()){
            return "libraryform";
        }
        libraryRepository.save(library);
        return "redirect:/";
    }

    @PostMapping("/processadd")
    public String processaddForm(@Valid Book book, BindingResult result)
    {
        if (result.hasErrors()){
            return "addbookform";
        }
        bookRepository.save(book);
        return "redirect:/";
    }

    @PostMapping("/processborrow")
    public String processborrowForm(@Valid Book book, BindingResult result)
    {
        if (result.hasErrors()){
            return "borrowbookform";
        }
        bookRepository.save(book);
        return "redirect:/";
    }

    @PostMapping("/processreturn")
    public String processreturnForm(@Valid Book book, BindingResult result)
    {
        if (result.hasErrors()){
            return "returnbookform";
        }
        bookRepository.save(book);
        return "redirect:/";
    }
}
