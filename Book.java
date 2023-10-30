package com.graphql.spring.poc.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
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
public class Book {
	@Id
	 @Column(name="book_id", nullable = false)
    @GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;
	@Column(name="book_title", nullable = false)
    @NonNull
	private String title;
	@Column(name="book_pages", nullable = false)
    @NonNull
	private Integer pages;
	@ManyToOne
    @JoinColumn(name = "author_id",
    nullable = false, updatable = false)
    @NonNull
	private Author author;

	

}