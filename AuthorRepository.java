package com.graphql.spring.poc.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.graphql.data.GraphQlRepository;

import com.graphql.spring.poc.model.Author;


@GraphQlRepository
public interface AuthorRepository extends CrudRepository<Author, Long> {
	

	
}