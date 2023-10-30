package com.graphql.spring.poc.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.graphql.data.method.annotation.SchemaMapping;
import org.springframework.stereotype.Controller;

import com.graphql.spring.poc.model.Author;
import com.graphql.spring.poc.repository.AuthorRepository;

@Controller
public class AuthorController {

  
  @Autowired
  private AuthorRepository authorRepository;

  @SchemaMapping(typeName = "Query", value = "allAuthor")
  public Iterable<Author> getAuthors() {
    return  authorRepository.findAll();
  }

  @QueryMapping
  public Optional<Author> author(@Argument Long id) {
    return authorRepository.findById(id);
  }

  @MutationMapping
  public Author updateAuthor(@Argument Long id, @Argument String name,@Argument String country) {
	  Author author = new Author();
	  author.setId(id);
	  author.setName(name);
	  author.setCountry(country);
    return authorRepository.save(author);
  }
  
  @MutationMapping
  public Author createAuthor(@Argument Long id, @Argument String name,@Argument String country) {
	  Author author = new Author();
	  author.setId(id);
	  author.setName(name);
	  author.setCountry(country);
    return authorRepository.save(author);
  }

}