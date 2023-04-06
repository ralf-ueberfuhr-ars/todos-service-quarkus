package de.samples.quarkus.helloworld.rest;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;

import org.eclipse.microprofile.config.inject.ConfigProperties;

import de.samples.quarkus.helloworld.config.HelloWorldConfig;

@Path("/greetings/")
public class HelloWorldResource {
	
	private final HelloWorldConfig config;
	
	public HelloWorldResource(@ConfigProperties HelloWorldConfig config) {
		super();
		this.config = config;
	}

	@GET
	@Path("/default")
	//@Produces(MediaType.TEXT_PLAIN)
	public Greeting greet(@QueryParam("name") String name) { // TODO required?, defaultValue
		Greeting g = new Greeting();
		if(null == name) {
			name = config.getDefaultName();
		}
		g.setMessage(config.getTemplate().replaceAll("\\{0\\}", name));
		return g;
	}
	

}
