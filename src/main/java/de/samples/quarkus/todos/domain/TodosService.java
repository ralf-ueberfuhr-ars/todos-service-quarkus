package de.samples.quarkus.todos.domain;

import java.util.Collection;
import java.util.Map;
import java.util.Optional;
import java.util.TreeMap;

import javax.enterprise.context.ApplicationScoped;
import javax.validation.Valid;

import de.samples.quarkus.interceptor.LogMethodCall;

@ApplicationScoped
//@MethodValidated
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

	@LogMethodCall
	public void add(@Valid Todo todo) {
		// find new id
		var id = idCounter++;
		todo.setId(id);
		// save
		this.todos.put(id, todo);
	}

}
