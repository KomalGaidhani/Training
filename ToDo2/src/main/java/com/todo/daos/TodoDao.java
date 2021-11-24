package com.todo.daos;

import org.springframework.data.jpa.repository.JpaRepository;
import com.todo.entity.Todo;

public interface TodoDao extends JpaRepository<Todo, Integer> {
	Todo findByTitle(String title);
	Todo findById (long id);
	void deleteById(long id);
}
