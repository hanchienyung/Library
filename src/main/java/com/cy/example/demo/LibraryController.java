package com.cy.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;

@Controller
public class LibraryController {
    String borrowed;

    @Autowired
    LibraryRepository libraryRepository;

    @Autowired
    BookRepository bookRepository;

    @Autowired
    AvailablebookRepository availablebookRepository;

    @Autowired
    BorrowedbookRepository borrowedbookRepository;

     @RequestMapping("/")
     public String listLibraries(Model model) {
         model.addAttribute("libraries", libraryRepository.findAll());
         return "mainpage";
     }

    @RequestMapping("/listbook")
    public String listbookForm(Model model) {
        model.addAttribute("books", bookRepository.findAll());
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
        model.addAttribute("availablebooks", availablebookRepository.findByHasbeenBorrowed("N"));
        return "borrowbookform";
    }

    @RequestMapping("/returnbook")
    public String returnbookForm(Model model) {
        model.addAttribute("borrowedbooks", borrowedbookRepository.findByHasbeenBorrowed("Y"));
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
