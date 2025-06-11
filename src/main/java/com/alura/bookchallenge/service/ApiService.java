package com.alura.bookchallenge.service;

import com.alura.bookchallenge.Animations.LoadingAnimation;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.concurrent.CompletableFuture;

public class ApiService {

	public String getData(String urlApi) {
		HttpClient client = HttpClient.newHttpClient();
		HttpRequest request = HttpRequest.newBuilder()
				.uri(URI.create(urlApi))
				.build();
		LoadingAnimation loading = new LoadingAnimation();
		loading.start();
		CompletableFuture<HttpResponse<String>> futureResponse = client.sendAsync(request, HttpResponse.BodyHandlers.ofString());
		try {
			HttpResponse<String> response = futureResponse.join();
			loading.stop();
			System.out.print("\r");
			System.out.println("✅ Ok res");
			return response.body();
		} catch (Exception e) {
			loading.stop();
			System.out.print("\r");
			throw new RuntimeException("API error res", e);
		}
	}



}
