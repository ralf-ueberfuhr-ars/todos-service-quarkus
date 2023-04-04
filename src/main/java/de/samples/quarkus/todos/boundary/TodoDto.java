package de.samples.quarkus.todos.boundary;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonProperty;

public class TodoDto {

	private Long id;
	private String title;
	private boolean completed;
	@JsonProperty("due_date") // TODO global Quarkus-Property?
	private LocalDate dueDate;

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public boolean isCompleted() {
		return completed;
	}
	public void setCompleted(boolean completed) {
		this.completed = completed;
	}
	public LocalDate getDueDate() {
		return dueDate;
	}
	public void setDueDate(LocalDate dueDate) {
		this.dueDate = dueDate;
	}
	
}
