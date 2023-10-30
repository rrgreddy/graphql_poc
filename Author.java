package com.graphql.spring.poc.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Author {
	

	@Id
    @Column(name="author_id", nullable = false)
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
	

    @Column(name="author_name", nullable = false)
  	private String name;

        
    @Column(name="author_country", nullable = false)
    @NonNull
    private String country;

	
}