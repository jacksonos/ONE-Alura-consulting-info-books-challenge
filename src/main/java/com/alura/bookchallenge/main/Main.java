package com.alura.bookchallenge.main;

import com.alura.bookchallenge.model.ApiResponse;
import com.alura.bookchallenge.model.Book;
import com.alura.bookchallenge.service.ApiService;
import com.alura.bookchallenge.service.ConvertData;

import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
	private final Scanner sc = new Scanner(System.in);
	private final ApiService apiService = new ApiService();
	private final LocalDate currentDate = LocalDate.now();

	public void showMenu() {
		System.out.println("=====================");
		System.out.println("      BOOKS API      ");
		System.out.println("=====================");

		String BASE_URL = "https://gutendex.com/books/";
		getTopFiveBooks(BASE_URL);
		searchBooks(BASE_URL);
		getDownloadStats(BASE_URL);
	}

	public void getTopFiveBooks(String BASE_URL) {
		System.out.printf("Top five books in %s!%n", currentDate.format(DateTimeFormatter.ofPattern("dd-MM-yyyy")));
		List<Book> bookList = getApiResults(BASE_URL).results();
		bookList.stream().filter(book -> book.downloadCount() > 0)
				.sorted(Comparator.comparing(Book::downloadCount).reversed())
				.limit(5)
				.forEach(System.out::println);
	}

	public void searchBooks(String BASE_URL) {
		System.out.println("\nEnter the book title you are looking for: ");
		String bookTitle = sc.nextLine();

		String encodedBookTitle = URLEncoder.encode(bookTitle, StandardCharsets.UTF_8).replace("+", "%20");
		String json = apiService.getData(BASE_URL + "?search=" + encodedBookTitle);
		ApiResponse apiResponse = new ConvertData().getData(json, ApiResponse.class);
		List<Book> bookList = apiResponse.results();
		System.out.println(bookList);
		Optional<Book> bookSearched = bookList.stream()
				.filter(book -> book.title().toLowerCase().contains(bookTitle.toLowerCase()))
				.findFirst();

		if (bookSearched.isPresent()) {
			Book book = bookSearched.get();
			System.out.println("Title: " + book);
			System.out.println("Book summary: " + book.summaries());
		} else {
			System.out.println("Book not found");
		}
	}

	public void getDownloadStats(String BASE_URL) {
		List<Book> bookList = getApiResults(BASE_URL).results();
		IntSummaryStatistics statistics = bookList.stream()
				.filter(book1 -> book1.downloadCount() > 0)
				.collect(Collectors.summarizingInt(Book::downloadCount));
		System.out.println("Download percentage: " + statistics.getAverage());
		System.out.println("Download count: " + statistics.getSum());
		System.out.println("Highest download percentage: " + statistics.getMax());
		System.out.println("Lowest download percentage: " + statistics.getMin());
		System.out.println("Total download count: " + statistics.getCount());
	}

	public ApiResponse getApiResults(String BASE_URL) {
		String json = apiService.getData(BASE_URL);
		return new ConvertData().getData(json, ApiResponse.class);
	}
}
