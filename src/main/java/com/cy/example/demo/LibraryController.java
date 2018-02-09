package com.cy.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

import java.util.List;

import static java.lang.Long.parseLong;
import static org.springframework.web.bind.annotation.RequestMethod.GET;

@Controller
public class LibraryController {
    String borrowed;

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
        model.addAttribute("books", bookRepository.findBookByHasbeenBorrowed("N"));
        return "borrowbookform";
    }

    @RequestMapping("/returnbook")
    public String returnbookForm(Model model) {
        model.addAttribute("books", bookRepository.findBookByHasbeenBorrowed("Y"));
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

    @RequestMapping(value="/processborrow", params={"id"}, method=GET)
    public String processborrowForm( @RequestParam("id") String id, Model model)
    {
        //System.out.println("Entering processborrowform id = " +id);
        List <Book> books = bookRepository.findBookById(Long.parseLong(id));
        for (Book book: books) {
            book.setHasbeenBorrowed("Y");
            bookRepository.save(book);
        }

      /*  if (result.hasErrors()){
            return "borrowbookform";
        }*/
       return "msgcheckout";
       //return "redirect:/";
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


    @RequestMapping(value="/processreturn", params={"id"}, method=GET)
    public String processreturnForm(@RequestParam("id") String id, Model model)
    {
        List <Book> books = bookRepository.findBookById(Long.parseLong(id));
        for (Book book: books) {
            book.setHasbeenBorrowed("N");
            bookRepository.save(book);
        }
       /* if (result.hasErrors()){
            return "returnbookform";
        }
        bookRepository.save(book); */
        return "msgcheckin";
        //return "redirect:/";
    }


}
