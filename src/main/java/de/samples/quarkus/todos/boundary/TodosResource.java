package de.samples.quarkus.todos.boundary;

import java.util.Collection;
import java.util.stream.Collectors;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

import de.samples.quarkus.todos.domain.TodosService;

@Path("/todos")
public class TodosResource {

	private final TodosService service;
	private final TodoDtoMapper mapper;

	public TodosResource(TodosService service, TodoDtoMapper mapper) {
		super();
		this.service = service;
		this.mapper = mapper;
	}

	@GET
	public Collection<TodoDto> findAll() {
		return service.findAll()
				.stream()
				.map(mapper::map)
				.collect(Collectors.toList());
	}

	@GET
	@Path("/{id}")
	public TodoDto findById(@PathParam("id") Long id) {
		return service.findById(id)
				.map(mapper::map)
				.orElseThrow(NotFoundException::new);
	}

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Response create(TodoDto todoDto, @Context UriInfo info) {
		var todo = mapper.map(todoDto);
		service.add(todo);
		// create response
		var location = info.getAbsolutePathBuilder() // current URL
				.path(Long.toString(todo.getId())) // add "/<id>"
				.build();
		return Response.created(location).build();

	}

}
