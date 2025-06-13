package com.example.taskmanager.task.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.taskmanager.task.dto.TaskDTO;
import com.example.taskmanager.task.model.Task;
import com.example.taskmanager.task.repository.TaskRepository;

@Service
public class TaskServiceImpl implements TaskService{
	
	private TaskRepository taskRepository;
	
	public TaskServiceImpl(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }
	
	@Override
	public Task createTask(TaskDTO dto) {
		Task task = new Task();
		task.setTitle(dto.getTitle());
		task.setDescription(dto.getDescription());
		task.setStatus(dto.getStatus());
		System.out.print(task);
		return taskRepository.save(task);
	}

	@Override
	public List<Task> getAllTasks() {
		return taskRepository.findAll();
	}
	
	@Override
	public Task updateTask(Long id, TaskDTO taskDto) {
		Task task = taskRepository.findById(id).orElseThrow(()-> new RuntimeException("Task not found"));
		task.setTitle(taskDto.getTitle());
		task.setDescription(taskDto.getDescription());
		task.setStatus(taskDto.getStatus());
		return taskRepository.save(task);
	}
}