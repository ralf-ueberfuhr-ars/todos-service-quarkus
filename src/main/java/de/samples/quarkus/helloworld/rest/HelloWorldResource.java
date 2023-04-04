package de.samples.quarkus.helloworld.rest;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;

@Path("/greetings/")
public class HelloWorldResource {
	
	@GET
	@Path("/default")
	//@Produces(MediaType.TEXT_PLAIN)
	public Greeting greet(@QueryParam("name") String name) { // TODO required?, defaultValue
		Greeting g = new Greeting();
		g.setMessage("Hello " + name);
		return g;
	}
	

}
