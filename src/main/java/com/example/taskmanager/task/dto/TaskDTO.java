package com.example.taskmanager.task.dto;
import jakarta.validation.constraints.Size;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;


public class TaskDTO{
	
	@NotBlank(message="Title is required")
	@Size(min = 3, max = 100, message = "Title must be between 3 and 100 characters")
	private String title;
	
	@Size(max = 250, message = "Description cannot exceed 250 characters")
	private String description;
	
	@NotBlank(message="Status is required")
	@Pattern(regexp = "PENDING|IN_PROGRESS|COMPLETED", message = "Status must be PENDING, IN_PROGRESS, or COMPLETED")
	private String status;
	
	public void setTitle(String title) {
		this.title = title;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	public String getTitle() {
		return title;
	}
	public String getDescription() {
		return description;
	}
	public String getStatus() {
		return status;
	}
}