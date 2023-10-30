package com.graphql.spring.poc.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.graphql.data.method.annotation.SchemaMapping;
import org.springframework.stereotype.Controller;

import com.graphql.spring.poc.model.Author;
import com.graphql.spring.poc.model.Book;
import com.graphql.spring.poc.repository.AuthorRepository;
import com.graphql.spring.poc.repository.BookRepository;

@Controller
public class BookController {

  @Autowired
  private BookRepository bookRepository;
  
  @Autowired
  private AuthorRepository authorRepository;

  @SchemaMapping(typeName = "Query", value = "allBooks")
  public Iterable<Book> getAllBooks() {
    return bookRepository.findAll();
  }

  @QueryMapping
  public Optional<Book> bookById(@Argument Integer id) {
    return bookRepository.findById(id);
  }

  @MutationMapping
  public Book updateBook(@Argument Integer id, @Argument String title) {
	  Book bk = new Book();
	  bk.setId(id);
	  bk.setTitle(title);
	  
    return bookRepository.save(bk);
  }
  
  @MutationMapping
  public Book createBook(@Argument Integer id, @Argument String title, @Argument Integer pages, @Argument Long author) {
	  Book bk = new Book();
	  bk.setId(id);
	  bk.setTitle(title);
	  bk.setPages(pages);
	  
	Author auth = authorRepository.findById(author).get();
	bk.setAuthor(auth);
    return bookRepository.save(bk);
  }

}