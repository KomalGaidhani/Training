package com.todo.service;

import java.util.List;

import com.todo.entity.Todo;

public interface TodoService {
	Todo findByTitle(String title);

	Todo findById(long id);

	Todo save(Todo todo);

	Todo update(Todo todo);

	void deleteById(long id);

	List<Todo> findAll();

}
