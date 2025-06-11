package com.alura.bookchallenge.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record Person(
		@JsonAlias("birth_year") Integer birthYear,
		@JsonAlias("death_year") Integer deathYear,
		@JsonAlias("name") String name) {
}
