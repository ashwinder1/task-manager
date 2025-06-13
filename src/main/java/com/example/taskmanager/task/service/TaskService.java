// service/TaskService.java
package com.example.taskmanager.task.service;

import java.util.List;
import com.example.taskmanager.task.dto.TaskDTO;
import com.example.taskmanager.task.model.Task;

public interface TaskService{
	Task createTask(TaskDTO dto);
	List<Task> getAllTasks();
	Task updateTask(Long id, TaskDTO dto);
}