package com.graphql.spring.poc.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.graphql.data.GraphQlRepository;

import com.graphql.spring.poc.model.Book;

@GraphQlRepository
public interface BookRepository extends CrudRepository<Book, Integer> {

	

}