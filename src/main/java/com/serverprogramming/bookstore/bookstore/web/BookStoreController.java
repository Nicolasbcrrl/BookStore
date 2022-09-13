package com.serverprogramming.bookstore.bookstore.web;
import com.serverprogramming.bookstore.bookstore.domain.Book;
import com.serverprogramming.bookstore.bookstore.domain.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class BookStoreController {
    @Autowired
    private BookRepository repository;
    @RequestMapping(value="/booklist", method=RequestMethod.GET)
    public String bookList(Model model) {
        model.addAttribute("books", repository.findAll());
        return "bookList";
    }

    @RequestMapping(value="/add")
    public String addBook(Model model) {
        model.addAttribute("book", new Book());
        return "addBook";
    }

    @RequestMapping(value="/save", method=RequestMethod.POST)
    public String save(Book book) {
        repository.save(book);
        return "redirect:booklist";
    }

    @RequestMapping(value="/delete/{id}", method=RequestMethod.GET)
    public String deleteBook(@PathVariable("id") String bookId, Model model) {
        repository.deleteById(bookId);
        return "redirect:../booklist";
    }

    @RequestMapping(value="/edit", method=RequestMethod.GET)
    public String editBook(@RequestParam(name="isbn") String isbn, Model model) {
        model.addAttribute("book", repository.findById(isbn));
        System.out.println("---------------------------------------------------------------------------------");
        return "bookedit";
    }
}
