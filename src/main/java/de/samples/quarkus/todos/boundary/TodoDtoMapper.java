package de.samples.quarkus.todos.boundary;

import javax.enterprise.context.ApplicationScoped;

import de.samples.quarkus.todos.domain.Todo;

@ApplicationScoped
public class TodoDtoMapper {

	// TODO use MapStruct

	public TodoDto map(Todo source) {
		if (null == source) {
			return null;
		} else {
			var result = new TodoDto();
			result.setId(source.getId());
			result.setTitle(source.getTitle());
			result.setDueDate(source.getDueDate());
			result.setCompleted(source.isCompleted());
			return result;
		}
	}

	public Todo map(TodoDto source) {
		if (null == source) {
			return null;
		} else {
			var result = new Todo();
			result.setId(source.getId());
			result.setTitle(source.getTitle());
			result.setDueDate(source.getDueDate());
			result.setCompleted(source.isCompleted());
			return result;
		}
	}

}
