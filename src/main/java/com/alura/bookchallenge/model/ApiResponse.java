package com.alura.bookchallenge.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public record ApiResponse(
		@JsonAlias("count") Integer count,
		@JsonAlias("next") String next,
		@JsonAlias("previous") String previous,
		@JsonAlias("results") List<Book> results) {
}
