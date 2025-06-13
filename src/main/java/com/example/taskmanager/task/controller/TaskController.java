// controller/TaskController.java
package com.example.taskmanager.task.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.taskmanager.task.dto.TaskDTO;
import com.example.taskmanager.task.model.Task;
import com.example.taskmanager.task.service.TaskService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/v1")
public class TaskController{
	private TaskService taskService;
	
	public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }
	
	@PostMapping("/tasks")
	public ResponseEntity<Task> createTask(@Valid @RequestBody TaskDTO taskDTO) {
		Task task = taskService.createTask(taskDTO);
		return ResponseEntity.ok(task);
	}
	
	@GetMapping("/tasks")
	public List<Task> getTasks() {
		return taskService.getAllTasks();
	}
	
	@PutMapping("/tasks/{id}")
	public Task updateTask(@PathVariable Long id, @RequestBody TaskDTO taskDTO) {
		return taskService.updateTask(id, taskDTO);
	}
	
}
