package com.berkanaslan.quarkus.starting.controller;

import com.berkanaslan.quarkus.starting.model.Book;
import com.berkanaslan.quarkus.starting.repository.BookRepository;
import org.jboss.logging.Logger;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;
import java.util.Optional;

@Path("/api/books")
@Produces(MediaType.APPLICATION_JSON)
public class BookController {

    @Inject
    private BookRepository bookRepository;

    @GET
    public List<Book> getAllBoks() {
        return bookRepository.getAllBoks();
    }

    @GET
    @Path("{id}")
    public Optional<Book> getBookById(@PathParam("id") int id) {
        return bookRepository.getBookById(id);
    }

    @GET
    @Path("/count")
    @Produces(MediaType.TEXT_PLAIN)
    public int countAllBooks() {
        return bookRepository.getAllBoks().size();
    }
}