package com.todo.controller;

import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.todo.entity.Todo;
import com.todo.entity.TodoStatus;
import com.todo.models.Response;
import com.todo.service.TodoService;

@RequestMapping("/todo")
@RestController
public class TodoController {

	@Autowired
	TodoService ts;

	// add new Task to do
	@PostMapping("/addTask")
	public ResponseEntity<?> save(Todo task) {
		task.setTodoStatus(TodoStatus.NOT_COMPLETED);
		return Response.success(ts.save(task));
	}

	// get list of all the tasks to do
	@GetMapping("/listAll")
	public ResponseEntity<?> findAll() {
		List<Todo> list = ts.findAll();
		Collections.reverse(list);
		return Response.success(list);
	}

	// find task by Id
	@GetMapping("/taskId/{id}")
	public ResponseEntity<?> findTaskById(@PathVariable("id") long id) {
		Todo task = ts.findById(id);
		return Response.success(task);
	}

	// find task by title
	@GetMapping("/{title}")
	public ResponseEntity<?> findTaskBytitle(@PathVariable("title") String title) {
		Todo task = ts.findByTitle(title);
		return Response.success(task);
	}

	@PutMapping("/editTask/{id}")
	public ResponseEntity<String> updateTask(Todo task, @PathVariable("id") long id) {
		Todo task1 = ts.findById(task.getId());
		if (task.getDescription() != null)
			task1.setDescription(task.getDescription());
		if (task.getTitle() != null)
			task1.setTitle(task.getTitle());
		ts.save(task1);
		return ResponseEntity.ok("Task updated");
	}

	@PutMapping("/updateStatus/{id}")
	public ResponseEntity<String> updateStatus(@PathVariable("id") long id) {
		Todo task = ts.findById(id);
		task.setTodoStatus(TodoStatus.COMPLETED);
		ts.save(task);
		return ResponseEntity.ok("Task Status Updated");
	}

	// Delete task by Id
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> delete(@PathVariable("id") long id) {
		ts.deleteById(id);
		return ResponseEntity.ok("Task deleted");
	}
}
