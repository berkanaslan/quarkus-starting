package com.berkanaslan.quarkus.starting.repository;

import com.berkanaslan.quarkus.starting.model.Book;

import javax.enterprise.context.ApplicationScoped;
import javax.ws.rs.PathParam;
import java.util.List;
import java.util.Optional;

@ApplicationScoped
public class BookRepository {
    public List<Book> getAllBoks() {
        return List.of(
                new Book(1, "Understanding Quarkus", "Antonio Goncalves", 2021, "IT"),
                new Book(2, "Practising Quarkus", "Antonio Goncalves", 2020, "IT"),
                new Book(3, "Effective Java", "Josh Block", 2001, "IT"),
                new Book(4, "Thinking in Java", "Bruce Eckel", 2020, "IT"),
                new Book(5, "C++", "K. Audin", 1998, "IT")
        );
    }

    public Optional<Book> getBookById(@PathParam("id") int id) {
        return getAllBoks().stream()
                .filter(book -> book.getId() == id)
                .findFirst();
    }
}
