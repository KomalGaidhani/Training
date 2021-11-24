package com.todo.service;

import java.util.List;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.todo.daos.TodoDao;
import com.todo.entity.Todo;

@Transactional
@Service
public class TodoServiceImpl implements TodoService{
	@Autowired
	TodoDao todoDao;

	@Override
	public Todo findById(long id) {
		return todoDao.findById(id);
	}
	@Override
	public Todo save(Todo todo) {
		return todoDao.save(todo);
	}
	@Override
	public Todo update(Todo todo) {
		return todoDao.save(todo);
	}
	@Override
	public void deleteById(long id) {
		todoDao.deleteById(id);
	}
	@Override
	public Todo findByTitle(String title) {
		return todoDao.findByTitle(title);
	}
	@Override
	public List<Todo> findAll() {
		return todoDao.findAll();
	}
}
