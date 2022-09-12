package com.serverprogramming.bookstore.bookstore.web;
import com.serverprogramming.bookstore.bookstore.domain.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class BookStoreController {
    @Autowired
    private BookRepository repository;
    @RequestMapping(value="/bookList", method=RequestMethod.GET)
    public String studentList(Model model) {
        model.addAttribute("books", repository.findAll());
        return "bookList";
    }
}
