package de.samples.quarkus.todos.domain;

import java.util.Collection;
import java.util.Map;
import java.util.Optional;
import java.util.TreeMap;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class TodosService {

	// manage todos by their id (sorted)
	private final Map<Long, Todo> todos = new TreeMap<>();
	private long idCounter; // simple ID generation mechanism ;-)

	public Collection<Todo> findAll() {
		return todos.values();
	}

	public Optional<Todo> findById(Long id) {
		return Optional.ofNullable(todos.get(id));
	}

	public void add(Todo todo) {
		// find new id
		var id = idCounter++;
		todo.setId(id);
		// save
		this.todos.put(id, todo);
	}

}
