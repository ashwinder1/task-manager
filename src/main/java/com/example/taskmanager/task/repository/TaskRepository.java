package com.example.taskmanager.task.repository;

import com.example.taskmanager.task.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepository extends JpaRepository<Task, Long>{	
}