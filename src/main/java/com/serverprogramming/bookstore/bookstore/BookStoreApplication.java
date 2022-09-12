package com.serverprogramming.bookstore.bookstore;

import com.serverprogramming.bookstore.bookstore.domain.Book;
import com.serverprogramming.bookstore.bookstore.domain.BookRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class BookStoreApplication {

    public static void main(String[] args) {
        SpringApplication.run(BookStoreApplication.class, args);
    }
    @Bean
    public CommandLineRunner demo(BookRepository repository) {
        return (args) -> {
            // Your code...add some demo data to db
            Book book1 = new Book("123456789", "les fleurs du mal", "Charles Baudelaire", "2010", 12.99);
            System.out.println("Saving books to database...");
            repository.save(book1);
        };
    }

}
