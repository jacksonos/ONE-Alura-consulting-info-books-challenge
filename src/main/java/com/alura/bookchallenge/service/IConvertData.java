package com.alura.bookchallenge.service;

public interface IConvertData {
	<T> T getData(String json, Class<T> clazz);
}
