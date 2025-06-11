package com.alura.bookchallenge.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public record Book(
		@JsonAlias("id") Integer id,
		@JsonAlias("title") String title,
		@JsonAlias("authors") List<Person> authors,
		@JsonAlias("summaries") List<String> summaries,
		@JsonAlias("download_count") Integer downloadCount) {

	@Override
	public String toString() {
		return "Book{" +
				"id=" + id +
				", title='" + title + '\'' +
				", authors=" + authors +
				", downloadCount=" + downloadCount +
				'}';
	}
}
