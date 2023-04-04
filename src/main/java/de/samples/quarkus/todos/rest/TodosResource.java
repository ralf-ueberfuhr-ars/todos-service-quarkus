package de.samples.quarkus.todos.rest;

import java.util.Collection;
import java.util.Map;
import java.util.Optional;
import java.util.TreeMap;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

@Path("/todos")
public class TodosResource {

	// manage todos by their id (sorted)
	private final Map<Long, Todo> todos = new TreeMap<>();
	private long idCounter; // simple ID generation mechanism ;-)

	@GET
	public Collection<Todo> findAll() {
		return todos.values();
	}

	@GET
	@Path("/{id}")
	public Todo findById(@PathParam("id") Long id) {
		var result = todos.get(id);
		if(null == result) {
			throw new NotFoundException();
		} else {
			return result;
		}
		// alternativ:
		// return Optional.ofNullable(todos.get(id))
		//		.orElseThrow(NotFoundException::new);
	}

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Response create(Todo todo, @Context UriInfo info) {
		// find new id
		var id = idCounter++;
		todo.setId(id);
		// save
		this.todos.put(id, todo);
		// create response
		var location = info.getAbsolutePathBuilder() // current URL
				.path(Long.toString(todo.getId())) // add "/<id>"
				.build();
		return Response.created(location).build();

	}

}
